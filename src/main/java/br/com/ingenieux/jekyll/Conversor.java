package br.com.ingenieux.jekyll;

import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.IOUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.String.format;

public class Conversor {
    private static final DateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    final File inputDir;

    final File outputDir;

    public Conversor(File inputDir, File outputDir) {
        this.inputDir = inputDir;
        this.outputDir = outputDir;
    }

    public void execute() throws Exception {
        List<File> files = new DirectoryWalker() {
            @Override
            protected void handleFile(File file, int depth, Collection results) throws IOException {
                if (file.getName().endsWith(".markdown")) {
                    results.add(file);
                }
            }

            public List<File> getFiles() throws IOException {
                List<File> results = new ArrayList<File>();

                walk(inputDir, results);

                return results;
            }
        }.getFiles();

        for (File f : files) {
            convertFile(f);
        }
    }

    public void convertFile(File f) throws IOException {
        info("Lendo arquivo: %s", f);

        String relFilename = f.getAbsolutePath().substring(1 + inputDir.getAbsolutePath().length()).replace('\\', '/');
        String outFilename = relFilename;
        String contents = IOUtils.toString(new FileInputStream(f), "UTF-8");
        Map<String, Object> headers = null;
        Properties outputHeaders = new Properties();
        final boolean isPost = relFilename.startsWith("_posts");

        { // Leitura
            String _header = contents.split("---")[1].substring(1);
            contents = ManipuladorTag.manipular(contents.split("---")[2].substring(2));

            headers = (Map<String, Object>) new Yaml().load(_header);
        }

        Date date = (Date) headers.get("date");

        // Tratamento

        {
            outputHeaders.put("type", headers.get("layout"));
            outputHeaders.put("title", headers.get("title"));
            outputHeaders.put("tags", isPost ? "blog" : "article");
            outputHeaders.put("status", "published");
            outputHeaders.put("date", SDF.format(date));
        }

        if (isPost) {
            outFilename = format("blog/%s/%s", 1900 + date.getYear(), relFilename.replaceFirst("^.*/\\d{4}-\\d{2}-\\d{2}-(.*)\\.markdown$", "$1.md"));
        } else {
            outFilename = relFilename.replaceFirst("\\.markdown$", ".md");
        }

        {
            StringBuilder fileContent = new StringBuilder();

            for (Map.Entry<Object, Object> entry : outputHeaders.entrySet()) {
                fileContent.append("" + entry.getKey()).append("=").append("" + entry.getValue()).append("\n");
            }
            fileContent.append("~~~~~~\n").append(contents);

            File outputFile = new File(outputDir, outFilename);

            if (! outputFile.getParentFile().exists()) {
                outputFile.getParentFile().mkdirs();
            }

            info("Salvando em %s", outputFile);

            IOUtils.write(fileContent.toString(), new FileOutputStream(outputFile));
        }



    }

    private void info(String mask, Object... args) {
        // System.err.println(String.format(mask, args));
    }

    public static void main(String[] args) throws Exception {
        new Conversor(new File("src/main/jekyll"), new File("src/main/jbake/content")).execute();
    }
}
