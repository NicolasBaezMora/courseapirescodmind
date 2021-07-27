package com.orderapi.orderapi.controllers;
 
import com.orderapi.orderapi.entities.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello!!";
    }

    @GetMapping(value = "/product")
    public Product findProduct(){
        Product product = new Product();
        product.setId(1234L);
        product.setName("Milk");
        return product;
    }

}
