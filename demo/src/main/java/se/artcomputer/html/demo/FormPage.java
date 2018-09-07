package se.artcomputer.html.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static se.artcomputer.html.Attribute.*;
import static se.artcomputer.html.CssUtil.styleSheet;
import static se.artcomputer.html.Html.*;

@RestController
public class FormPage {

    @RequestMapping("/form")
    public String formPage() {
        return html(
                head(
                        link(styleSheet("/main.css"))
                ),
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

    @RequestMapping("/formaction")
    public String formActioPage(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName) {
        return html(
                head(
                        link(styleSheet("/main.css"))
                ),
                body(
                        text("Thanks " + lastName + ", " + firstName),
                        div(
                                a(
                                        attributes(className("button"), href("/")),
                                        text("Go back home")
                                )
                        )
                )
        ).toString();
    }
}
