package se.artcomputer.html.demo.nanoserver;

import com.sun.net.httpserver.HttpHandler;
import se.artcomputer.html.Node;

import java.io.PrintWriter;
import java.net.URI;

import static se.artcomputer.html.Html.*;

@SuppressWarnings("WeakerAccess")
public class FormAction {
    private static final String PATH = "/form-action";

    static String path() {
        return PATH;
    }

    HttpHandler handler() {
        return http -> {
            URI requestURI = http.getRequestURI();
            String[] query = requestURI.getQuery().split("&");

            http.getResponseHeaders().add("Content-type", "text/html");
            http.sendResponseHeaders(200, 0);

            PrintWriter printWriter = new PrintWriter(http.getResponseBody());
            printWriter.write(content(query));
            printWriter.close();
        };
    }

    private String content(String[] query) {
        return html(
                body(
                        ol(collectQuery(query))

                )
        ).toString();
    }

    private Node[] collectQuery(String[] query) {
        Node[] result = new Node[query.length];
        int index = 0;
        for (String s : query) {
            result[index] = splitValue(s);
            index++;
        }
        return result;
    }

    private Node splitValue(String nameAndValue) {
        return li(text(nameAndValue));
    }
}
