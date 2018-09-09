package se.artcomputer.html.demo.nanoserver;

import static se.artcomputer.html.Attribute.*;
import static se.artcomputer.html.CssUtil.styleSheet;
import static se.artcomputer.html.Html.*;

class NextPage extends NanoPage {

    private static final String PATH = "/next";

    static String path() {
        return PATH;
    }

    @Override
    String content() {
        return html(
                body(
                        attributes(blueText),
                        h1(
                                attributes(greenText),
                                text("We are now on the next page")),
                        div(
                                text("Here we thrive with Java rendering pages.")),
                        div(
                                a(
                                        attributes(
                                                className("button"),
                                                href("/")),
                                        text("Click here for home page"))
                        ))
        ).toString();
    }
}
