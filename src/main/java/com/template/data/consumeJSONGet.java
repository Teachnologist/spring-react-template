package com.template.data;

import com.template.restmethods.GetData;
import org.json.JSONObject;

public class consumeJSONGet {

    JSONObject json;
    Boolean is_error = true;

    public consumeJSONGet(String url){

        GetData data  = new GetData(url);

        if(!data.hasError()) {
            is_error = false;
            json = new JSONObject(data.GetResponse());
        }else{
            json = new JSONObject(data.getError());
        }
    }

    public JSONObject getData() {
        JSONObject obj = new JSONObject();
        obj.put("has_error",is_error);
        obj.put("data",json);
        return obj;
    }
}
