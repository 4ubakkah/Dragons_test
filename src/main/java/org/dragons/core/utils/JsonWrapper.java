package org.dragons.core.utils;


import net.minidev.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonWrapper {

    private JsonWrapper(){};

    public static HttpEntity<JSONObject> wrap(Map<String, Object> map) {
        JSONObject requestBody = new JSONObject();
        requestBody.putAll(map);

        HttpHeaders requestHeaders = new HttpHeaders();
        List<MediaType> mediaTypeList = new ArrayList<MediaType>();
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(mediaTypeList);
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(requestBody, requestHeaders);
    }

}


