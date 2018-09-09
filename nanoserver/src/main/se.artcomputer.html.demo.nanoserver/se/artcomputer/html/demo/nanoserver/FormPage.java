package se.artcomputer.html.demo.nanoserver;

import static se.artcomputer.html.Attribute.action;
import static se.artcomputer.html.Attribute.name;
import static se.artcomputer.html.Html.*;

class FormPage extends NanoPage {

    private static final String PATH = "/form";

    static String path() {
        return PATH;
    }

    @Override
    String content() {
        return
                html(
                        body(
                                h1(
                                        text("Demonstrate filling in a form")
                                ),
                                div(
                                        text("Here we have a form and your job is to fill it in.")
                                ),
                                form(
                                        attributes(action("/formaction")),
                                        div(text("Form content")),
                                        div(
                                                text("First name: "),
                                                input(name("firstName"))
                                        ),
                                        div(
                                                text("Last name: "),
                                                input(name("lastName"))
                                        ),
                                        div(submit("Enter!"))
                                )
                        )
                ).toString();
    }
}
