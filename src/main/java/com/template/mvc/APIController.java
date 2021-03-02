package com.template.mvc;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class APIController {

@RequestMapping("/json")
public Map getString(){

    Map<String, Object> obj = new HashMap<>();

    obj.put("error",false);
    obj.put("data","data goes here");
    return obj;
}

    @RequestMapping("/list")
    public Map getArray(){

        Map<String, Object> obj = new HashMap<>();

        obj.put("error",false);

        List list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");

        obj.put("data",list);
        return obj;
    }

}
