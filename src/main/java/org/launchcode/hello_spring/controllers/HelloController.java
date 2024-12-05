package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("helloTest")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handle requests with name as query param /hello?name=value
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithParams(@RequestParam String name, Model model) {
        String myGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", myGreeting);
        return "hello";
    }

    //handle requests with name with path param
    @GetMapping("hello/{name}")
    public String helloWithParamsAsPath(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    @GetMapping("form2")
    public String helloForm() {
        return "form";
    }

    @GetMapping("form")
    @ResponseBody
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
    @ResponseBody
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
        return "<html>" +
                "<body>" +
                "<h1 style='color:blue;text-align: center;'>" + returnValue.concat(name) + "</h1>" +
                "<img src='https://media.istockphoto.com/id/1065465342/vector/cute-vector-speech-bubble-icon-with" +
                "-hello-greeting.jpg?s=612x612&w=0&k=20&c=dIq85nTuC9OGJAuuIUdz0u0EQg2N4pEpWzKxa8S0gbY=' " +
                "style='display: block; margin-left: auto;" +
                "  margin-right: auto;" +
                "  width: 50%;'" +
                "width=\"500\" height=\"600\">" +
                "</body>" +
                "</html>";
    }
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Olga");
        names.add("Java");
        names.add("Tiger");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
