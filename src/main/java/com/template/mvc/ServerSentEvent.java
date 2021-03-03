package com.template.mvc;


import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.Date;

@Controller
@RequestMapping(value="/sse",produces = "text/event-stream;charset=UTF-8")
public class ServerSentEvent {

    @CrossOrigin
    @RequestMapping(value="/test",
            method= RequestMethod.GET,
            produces="text/event-stream;charset=UTF-8")
    public @ResponseBody
    String sendTrades(HttpServletResponse response) {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/event-stream;charset=UTF-8");

        try {
            System.out.println("in the event");
            Long time = Instant.now().getEpochSecond();
            String timestamp = time.toString();
            Thread.sleep(5000);




            JSONObject json = new JSONObject();
            json.put("text",timestamp);
            return "data: " +json.toString()+ "\n\n";
        }catch(Exception e){
            return "data: " +e.toString();
        }
    }

}
