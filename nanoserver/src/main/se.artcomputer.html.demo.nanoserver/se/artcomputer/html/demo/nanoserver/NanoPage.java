package se.artcomputer.html.demo.nanoserver;

import com.sun.net.httpserver.HttpHandler;
import se.artcomputer.html.Attribute;

import java.io.OutputStream;
import java.io.PrintWriter;

abstract class NanoPage {
    final Attribute blueText = new Attribute("style", "color : blue");
    final Attribute greenText = new Attribute("style", "color : green");

    HttpHandler handler() {
        return http -> {
            http.getResponseHeaders().add("Content-type", "text/html");
            http.sendResponseHeaders(200, 0);
            OutputStream stream = http.getResponseBody();
            PrintWriter printWriter = new PrintWriter(stream);
            printWriter.write(content());
            printWriter.close();
        };
    }

    abstract String content();
}
