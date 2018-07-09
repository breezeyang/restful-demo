package com.breeze.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseController {
    
    Gson gson = new GsonBuilder().serializeNulls().create();
    
    public String success(Object obj) {
        String json = gson.toJson(obj);
        return json;
    }

}
