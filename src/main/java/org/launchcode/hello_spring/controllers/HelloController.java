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

    @GetMapping("formByLanguage")
    public String helloFormWithLanguage() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form action = 'greet' method = 'post'>" +
                        "<input type = 'text' name = 'name' />" +
                        "<select name='language'>" +
                        "<option value='english'>English</option>" +
                        "<option value='russian'>Russian</option>" +
                        "<option value='french'>French</option>" +
                        "<option value='german'>German</option>" +
                        "<option value='spanish'>Spanish</option>" +
                        "</select>"+
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

   @PostMapping("greet")
   @ResponseBody
    public String greetBuyNameAndLanguage(@RequestParam String language, @RequestParam String name){
        String returnValue = "Hello, ";
        if(language.equalsIgnoreCase("french")){
            returnValue = "Bonjour, ";
        }
        if(language.equalsIgnoreCase("russian")){
            returnValue = "Привет, ";
        }
        if(language.equalsIgnoreCase("german")){
            returnValue = "Hallo, ";
        }
        if(language.equalsIgnoreCase("spanish")){
            returnValue = "Ola, ";
        }
        return returnValue.concat(name);
    }
}
