package br.com.ingenieux.jekyll;

import org.pegdown.PegDownProcessor;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;
import static org.apache.commons.lang.StringUtils.*;

public abstract class ManipuladorTag {
    private static final PegDownProcessor PROCESSOR = new PegDownProcessor();

    private static final Pattern PATTERN_ATTR = Pattern.compile("(\\w+)(=[^\\s]+)");

    private static final Pattern PATTERN_TAG = Pattern.compile("\\[(\\w+)([^\\]]*)](.*?)(\\[/\\1\\])?", Pattern.MULTILINE);

    public abstract String obtemCodigo(String rawAttrs, Map<String, String> attrs, String corpo);

    private static final Map<String, ManipuladorTag> MANIPULADORES = new TreeMap<String, ManipuladorTag>() {{
        put("caption", new ManipuladorTag() {
            @Override
            public String obtemCodigo(String rawAttrs, Map<String, String> attrs, String corpo) {
                String id = defaultString(attrs.get("id"));
                String align = defaultString(attrs.get("align"));
                Integer width = 10 + Integer.valueOf(defaultString(attrs.get("width")));
                String caption = defaultString(attrs.get("caption")).replaceAll("\\Q[/caption]\\E", "");
                // '<div ' . $id . 'class="wp-caption ' . esc_attr($align) . '" style="width: ' . (10 + (int) $width) . 'px">'
                // . do_shortcode( $content ) . '<p class="wp-caption-text">' . $caption . '</p></div>'

                corpo = PROCESSOR.markdownToHtml(corpo);

                return format("<div id=\"%s\" class=\"wp-caption\" align=\"%s\" style=\"width: %dpx\">%s<p class=\"wp-caption-text\"></p></div>\n",
                        id, align, width, corpo);

                //return corpo;
            }
        });
        put("slideshare", new ManipuladorTag() {
            @Override
            public String obtemCodigo(String rawAttrs, Map<String, String> attrs, String corpo) {
                String id = rawAttrs.replaceAll(".*id=(\\d+).*", "$1");

                if (isBlank(id))
                    return null;

                return format("<iframe src=\"http://www.slideshare.net/slideshow/embed_code/%s\" width=\"427\" height=\"356\" frameborder=\"0\" marginwidth=\"0\" marginheight=\"0\" scrolling=\"no\" style=\"border:1px solid #CCC; border-width:1px 1px 0; margin-bottom:5px; max-width: 100%%;\" allowfullscreen></iframe>", id);
            }
        });
        put("youtube", new ManipuladorTag() {
            @Override
            public String obtemCodigo(String rawAttrs, Map <String, String> attrs, String corpo) {
                String id = rawAttrs.replaceAll(".*v=(\\p{Alnum}+).*", "$1");
                return format("<iframe width=\"560\" height=\"315\" src=\"//www.youtube.com/embed/%s\" frameborder=\"0\" allowfullscreen></iframe>", id);
            }
        });
        put("code", new ManipuladorTag() {
            @Override
            public String obtemCodigo(String rawAttrs, Map<String, String> attrs, String corpo) {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });

    }};

    public static String manipular(String _s) {
        StringBuilder s = new StringBuilder(_s);

        boolean hasMatches;
        main:
        while (true) {
            Matcher m = PATTERN_TAG.matcher(s);

            while (m.find()) {
                String bloco = m.group(0);
                String tagName = m.group(1);

                if (!MANIPULADORES.containsKey(tagName))
                    continue;

                String tagAttrs = m.group(2);
                String body = m.group(3);

                Map<String, String> attrs = new TreeMap<String, String>();

                Matcher a = PATTERN_ATTR.matcher(tagAttrs);

                while (a.find()) {
                    String name = a.group(1);
                    String value = a.group(2).replaceAll("\"", "").replaceFirst("=", "");

                    attrs.put(name, value);
                }

                String resultado = defaultString(MANIPULADORES.get(tagName).obtemCodigo(tagAttrs, attrs, body));

                if (isNotBlank(resultado)) {
                    s.replace(m.start(), m.end(), resultado);

                    continue main;
                }
            }

            break;
        };

        return s.toString().replaceAll("\\Q[/caption]\\E", "");
    }
}
