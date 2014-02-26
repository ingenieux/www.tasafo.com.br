status=published
date=2012-01-08
tags=blog
type=post
title=Melhorando a qualidade dos testes com refatoração e fluent interfaces
~~~~~~
Muita gente acha que não precisa dar muita atenção à qualidade na escrita dos testes. Mas o nível de qualidade dos testes deve ser tão alto quanto o do código de produção, afinal, os testes também tem que ser mantidos por tanto tempo quanto o código de produção. No seu livro _Clean Code_, Uncle Bob conta a história de uma equipe que decidiu abrandar as regras de qualidade nos testes. Traduzindo livremente:


> As variáveis não tinham que ser bem nomeadas, os métodos não tinham que ser pequenos e descritivos. O código de teste não tinha que ter um bom design. Contanto que o código de teste funcionasse e cobrisse o código de produção, estava tudo bem.

Quanto mais o tempo passava, mais difícil era alterar os testes e adicionar novos. Vez ou outra alguns testes falhavam quando a equipe mudava o código de produção, e corrigi-los também se tornou uma tarefa árdua e demorada. As estimativas ficaram cada vez mais altas, porque mexer nos testes era muito custoso. Depois de um tempo, eles jogaram fora toda a suite de testes. Mas sem os testes, muitos bugs começaram a aparecer, a equipe perdeu a confiança em alterar o código, e no final, clientes e desenvolvedores ficaram frustados.

Moral da história, se o código será mantido - seja de produção ou de testes - então ele tem que ser bem escrito.


<!-- more -->Então, vamos botar em prática essa regra. A seguir, temos um exemplo de como podemos melhorar a qualidade de um teste. No último projeto que participei, uma classe de testes estava nos incomodando. Cada vez que tínhamos que alterá-la, era uma demora. Toda vez que abríamos essa classe, demorávamos entendendo novamente a sua difícil lógica. Vou mostrar a evolução do seguinte método de teste:

[sourcecode language="java" wraplines="false"]
@Test
public void anActionOriginatedInClientShouldNotBeExecutedEvenIfReceivedFromServer() {
[/sourcecode]

O código original:


[sourcecode language="java" wraplines="false"]

actionSyncServiceTestUtils.getActionExecutionServiceMock().addActionExecutionListener(new ActionExecutionListener( {
    public void onActionExecution(final Action action, final ProjectContext context,
        final Set<UUID> inferenceInfluencedSet, final boolean isUserAction) {}
});

loadProjectContext(new ProjectContextLoadCallback() {
    public void onProjectContextLoaded(final ProjectContext context) {
        actionSyncServiceTestUtils.getActionExecutionServiceMock().onUserActionExecutionRequest(
            new Action(context.getProject().getId(), "filho"));
    }
    public void onProjectContextFailed(final Throwable caught) {
         assertEquals(SAME_CLIENT_EXCEPTION_MESSAGE, caught.getMessage());
    }
});

[/sourcecode]

Depois da primeira refatoração:

[sourcecode language="java" wraplines="false"]
final ArgumentCaptor<ActionSyncEvent> eventHandlerCaptor = getEventHandlerCaptor();

createInstance();

final ActionSyncEvent eventHandler = eventHandlerCaptor.getValue();

final UUID clientId = new UUID("123");
clientHasId(clientId);
try {
     eventHandler.onEvent(new ActionSyncEvent(createRequest(clientId)));
} catch (final RuntimeException e) {
     final String sameClientExceptionMessage = "This client received the same action it sent to server.";
     assertEquals(sameClientExceptionMessage, e.getMessage());
}

assertNoActionWasExecutedInClient();
[/sourcecode]

Aqui já ficou bem melhor, mas o código de stubbing e os diferentes níveis de abstração e o bloco try-catch ainda o deixavam confuso. Nessa hora veio à mente [esse post do Naresh Jain](http://blogs.agilefaqs.com/2008/12/27/fluent-interfaces-improve-readability-of-my-tests/) e percebemos que poderíamos fazer algo parecido com os nossos testes, inserindo _fluent interfaces_. E o resultado foi esse:

[sourcecode language="java" wraplines="false"]
final String clientId = "123";
given().aClientWithId(clientId);
when().aRequestArriveFrom(clientId);
verifyThat().noActionWasExecutedInClient();
[/sourcecode]

Aqui está outro exemplo:

[sourcecode language="java" wraplines="false"]
@Test
public void anActionOriginatedInClientShouldBeExecutedOnce() throws Exception {
    final int nTimes = 1;
    when().anActionWasExecutedInClient();
    verifyThat().userActionsWereExecutedInClient(nTimes);
}
[/sourcecode]

Assim fica bem fácil manter os testes, não é?

Segue o código completo abaixo.

[sourcecode language="java" wraplines="false"]

public class ActionSyncServiceTest {
private ActionSyncService ASS;
private ActionSyncRequest request;

@Test
public void anActionOriginatedInClientShouldNotBeExecutedEvenIfReceivedFromServer() throws Exception {
    final String clientId = "123";
    given().aClientWithId(clientId);
    when().aRequestArriveFrom(clientId);
    verifyThat().noActionWasExecutedInClient();
}

@Test
public void anActionOriginatedInClientShouldBeExecutedOnce() throws Exception {
    final int nTimes = 1;
    when().anActionWasExecutedInClient();
    verifyThat().userActionsWereExecutedInClient(nTimes);
}

@Test
public void actionsNotOriginatedInClientShouldBeExecutedAfterBeingReceivedFromServer() throws Exception {
    final short projectId = 1;
    given().aClientWithId("client being tested").ignoringProjectCheck(projectId);
    when().aRequestArriveFrom("other client");
    verifyThat().nonUserActionsWereExecutedInClient();
}

@Test
public void anActionNotOriginatedInClientShouldNotBeExecutedAsClientActionAfterBeingReceivedFromServer() throws Exception {
    final short projectId = 1;
    given().aClientWithId("client being tested").ignoringProjectCheck(projectId);
    when().aRequestArriveFrom("other client");
    verifyThat().nonUserActionsWereExecutedInClient();
}

@Test
public void anActionReceivedFromServerThatBelongsToAProjectDifferentFromClientCurrentProjectShouldNotBeExecuted() throws Exception {
    final int currentProject = 1;
    final int otherProject = 2;
    given().aClientWithId("client").aClientWithCurrentProject(currentProject);
    when().aRequestArrivedFrom("other client", otherProject);
    verifyThat().noActionWasExecutedInClient();
}

@Test
public void anActionReceivedFromServerThatBelongsToTheSameProjectOfClientCurrentProjectShouldBeExecuted() throws Exception {
    final short project = 1;
    given().aClientWithId("client").aClientWithCurrentProject(project);
    when().aRequestArrivedFrom("other client", project);
    verifyThat().nonUserActionsWereExecutedInClient();
}

private Given given() {
    return new Given();
}

private When when() {
    return new When();
}

private VerifyThat verifyThat() {
    return new VerifyThat();
}

private class Given {
  private Given aClientWithId(final String clientId) {
    Mockito.when(clientIdentificationProvider.getClientId()).thenReturn(new UUID(clientId));
    return this;
  }

  private Given aClientWithCurrentProject(final int projectId) {
    Mockito.when(projectRepresentationProvider.getCurrentProjectRepresentation()).thenReturn(ProjectTestUtils.createRepresentation(projectId));
    return this;
  }

  private Given ignoringProjectCheck(final int projectId) {
    Mockito.when(projectRepresentationProvider.getCurrentProjectRepresentation()).thenReturn(ProjectTestUtils.createRepresentation(projectId));
    return this;
  }
}

private class When {
  private void aRequestArriveFrom(final String clientId) {
    request = RequestTestUtils.createActionSyncRequest(clientId);
    fireEvent();
  }

  private void aRequestArrivedFrom(final String clientId, final int projectId) {
    request = RequestTestUtils.createActionSyncRequest(clientId, projectId);
    fireEvent();
  }

  private void anActionWasExecutedInClient() {
    createInstance();
    final Action action = mock(Action.class);
    actionExecution.onUserActionExecutionRequest(action);
  }

  private void fireEvent() {
    final ArgumentCaptor<ServerActionSyncEventHandler> eventHandlerCaptor = getEventHandlerCaptor();
    createInstance();

    try {
      fireActionSynEvent(request,  eventHandlerCaptor);
    }
    catch (final RuntimeException e) {}
    }

  private void createInstance() {
     // Create instance of the class being tested.
  }

  private ArgumentCaptor<ServerActionSyncEventHandler> getEventHandlerCaptor() {
    final ArgumentCaptor<ServerActionSyncEventHandler> eventHandlerCaptor = ArgumentCaptor.forClass(ServerActionSyncEventHandler.class);
    doNothing().when(serverPush).registerServerEventHandler(eq(ServerActionSyncEvent.class), eventHandlerCaptor.capture());
    return eventHandlerCaptor;
  }

  private void fireActionSynEvent(final ActionSyncRequest request, final ArgumentCaptor<ServerActionSyncEventHandler> eventHandlerCaptor) {
    final ServerActionSyncEventHandler eventHandler = eventHandlerCaptor.getValue();
    eventHandler.onEvent(new ServerActionSyncEvent(request));
  }
}

private class VerifyThat {
  private void nonUserActionsWereExecutedInClient() throws Exception {
    final int nTimes = request.getActionList().size();
    verify(actionExecution, never()).onUserActionExecutionRequest(any(Action.class));
    verify(actionExecution, times(nTimes)).onNonUserActionRequest(any(Action.class));
    verify(actionExecution, never()).onUserActionRedoRequest();
    verify(actionExecution, never()).onUserActionUndoRequest();
  }

  private void noActionWasExecutedInClient() throws Exception {
    verify(actionExecution, never()).onUserActionExecutionRequest(any(Action.class));
    verify(actionExecution, never()).onNonUserActionRequest(any(Action.class));
    verify(actionExecution, never()).onUserActionRedoRequest();
    verify(actionExecution, never()).onUserActionUndoRequest();
  }

  private void userActionsWereExecutedInClient(final int nTimes) throws Exception {
    verify(actionExecution, never()).onNonUserActionRequest(any(Action.class));
    verify(actionExecution, times(nTimes)).onUserActionExecutionRequest(any(Action.class));
    verify(actionExecution, never()).onUserActionRedoRequest();
    verify(actionExecution, never()).onUserActionUndoRequest();
  }
}
}
[/sourcecode]


