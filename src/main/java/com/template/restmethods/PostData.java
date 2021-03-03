package com.template.restmethods;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;

import java.time.Instant;

public class PostData {

    String output = null;
    String error_output = null;

    public PostData(String url, JSONObject body){

        try {

            String method = "POST";


            Client client = Client.create();

            WebResource webResource = client.resource(url);

            ClientResponse response = webResource
                    .header("upgrade-insecure-requests","1")
                    .header("user-agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) " +
                            "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36")
                    .header("Content-Type","application/json")
                    .header("accept","application/json")
                    .header("accept-language","en-US,en;q=0.9")
                    .type("application/json")
                    .post(ClientResponse.class,body.toString());


            String res = response.getEntity(String.class);
            if(res.contains("message")){
                output = null;
                error_output = res;
            }else{
                output = res;
                error_output = null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String GetResponse(){
        return output;
    }

    public Boolean hasData() {
        if (output != null && output.length() > 0){
            return true;
        }

        return false;
    }

    public String getError(){
        return error_output;
    }

    public Boolean hasError() {
        if (error_output != null && error_output.length() > 0){
            return true;
        }

        return false;
    }
}
