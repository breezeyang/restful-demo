package com.breeze.app;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

import com.breeze.controller.ProductServiceImpl;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class ServerMain {
    
    public static void main(String[] args) {
        //添加ResourceClass
        List<Class<?>> resourceClassList=new ArrayList<Class<?>>();
        resourceClassList.add(ProductServiceImpl.class);
        //添加ResourceProvider
        List<ResourceProvider> resourceProviderList=new ArrayList<ResourceProvider>();
        resourceProviderList.add(new SingletonResourceProvider(new ProductServiceImpl()));

        //添加Provider
        List<Object> providerList=new ArrayList<Object>();
        providerList.add(new JacksonJsonProvider());
        //发布REST服务
        JAXRSServerFactoryBean factory=new JAXRSServerFactoryBean();
        factory.setAddress("http://localhost:8080/ws/rest");
        factory.setResourceClasses(resourceClassList);
        factory.setResourceProviders(resourceProviderList);
        factory.setProviders(providerList);
        factory.create();
        System.out.println("rest ws is published");
    }

}
