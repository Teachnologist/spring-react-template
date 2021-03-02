package com.template.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HTMLController {


    @GetMapping("/")
    public String getHomePage() {
        System.out.println("homepage");
        return "index";
    }

}
