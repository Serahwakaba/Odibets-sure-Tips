package com.example.odibetssuretips;

import org.json.JSONArray;
import org.json.JSONObject;

public interface ServerResponseCallback {
    public void onJSONRESPONSE(JSONObject  jsonObject);
    public void onJSONArrayRESPONSE(JSONArray jsonArray);
    public void onError(Exception e);

}
