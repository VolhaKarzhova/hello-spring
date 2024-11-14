package org.launchcode.hello_spring.controllers;

import org.apache.coyote.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HelloController {

    @GetMapping("helloTest")
    public String hello() {
        return "Hello, Spring!";
    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handle requests with name as query param /hello?name=value
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithParams(@RequestParam String name) {
        return "Hello, ".concat(name);
    }

    //handle requests with name with path param
    @GetMapping("hello/{name}")
    public String helloWithParamsAsPath(@PathVariable String name) {
        return "Hello, ".concat(name);
    }

    @GetMapping("form2")
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = '/hello'>" +
                        "<input type = 'text' name = 'name' />" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

    @GetMapping("form")
    public String helloFormAsQueryParams() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form action = 'hello'>" +
                        "<input type = 'text' name = 'name' />" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }
}
