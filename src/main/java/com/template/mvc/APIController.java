package com.template.mvc;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class APIController {

@RequestMapping("/json")
public Map getJSON(){

    Map<String, Object> obj = new HashMap<>();

    obj.put("error",false);
    obj.put("data","data goes here");
    return obj;
}

}
