package se.artcomputer.html.demo.nanoserver;

import se.artcomputer.html.Html;

import static se.artcomputer.html.Attribute.className;
import static se.artcomputer.html.Attribute.href;
import static se.artcomputer.html.Html.*;

class HomePage extends NanoPage {

    private static final String PATH = "/";

    static String path() {
        return PATH;
    }

    @Override
    String content() {
        return Html.html(
                body(
                        attributes(blueText),
                        h1(
                                attributes(greenText),
                                text("Greetings from Nano server!")),
                        div(
                                text("Here we thrive with Java rendering pages.")),
                        div(
                                a(
                                        attributes(className("button"), href("/next")),
                                        text("Click here for next page"))
                        ),
                        div(
                                a(
                                        attributes(className("button"), href("/form")),
                                        text("Or here for a form demo!")
                                )
                        )
                )
        ).toString();
    }
}
