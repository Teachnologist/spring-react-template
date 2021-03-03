package com.template.data;

import com.template.restmethods.GetData;
import com.template.restmethods.PostData;
import org.json.JSONObject;

public class consumeJSONPost {

    JSONObject json;
    Boolean is_error = true;

    public consumeJSONPost(String url, JSONObject body){

        PostData data  = new PostData(url,body);

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
