package com.breeze.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.breeze.model.Product;

import java.util.List;
import java.util.Map;


public interface ProductService {
    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    List<Product> retireveAllProducts();

    @GET
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    String retireveProductById(@PathParam("id") long id);

    @POST
    @Path("/product")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    List<Product> retireveProductsByName(@FormParam("name") String name);

    @POST
    @Path("/product")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String createProduct(String product);

    @PUT
    @Path("/product/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String updateProductById(@PathParam("id") long id, Map<String, Object> fieldMap);

    @DELETE
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    String deleteProductById(@PathParam("id") long id);
}
