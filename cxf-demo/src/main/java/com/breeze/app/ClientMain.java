package com.breeze.app;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class ClientMain {
    public static void main(String[] args) {
        String baseAddress = "http://localhost:8080/ws/rest";
        List<Object> providerList = new ArrayList<Object>();
        providerList.add(new JacksonJsonProvider());
        List productList = WebClient.create(baseAddress, providerList).path("/products")
                .accept(MediaType.APPLICATION_JSON).get(List.class);
        System.out.println(productList);
        for (Object product : productList) {
            System.out.println(product);
        }
    }
}
