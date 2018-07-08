package com.breeze.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;

import com.breeze.model.Product;

public class ProductServiceImpl implements ProductService {

    public List<Product> retireveAllProducts() {
        System.out.println("retireveAllProducts");

        List<Product> result = new ArrayList<Product>();
        Product p = new Product();
        p.setId(13);
        p.setName("dsfsdf");
        result.add(p);
        return result;
    }

    public String retireveProductById(long id) {
        System.out.println("retireveProductById");

        return "dsfsdf";
    }

    public List<Product> retireveProductsByName(@FormParam("name") String name) {

        System.out.println("retireveProductsByName");

        List<Product> result = new ArrayList<Product>();
        Product p = new Product();
        p.setId(13);
        p.setName("dsfsdf");
        result.add(p);
        return result;
    }

    public String createProduct(String product) {
        System.out.println("createProduct");

        return "dsfsdf";
    }

    public String updateProductById(long id, Map<String, Object> fieldMap) {
        System.out.println("updateProductById");

        return "dsfsdf";
    }

    public String deleteProductById(long id) {
        System.out.println("deleteProductById");
        return "dsfsdf";
    }

}
