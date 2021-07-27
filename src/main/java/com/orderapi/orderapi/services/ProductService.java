package com.orderapi.orderapi.services;


import com.orderapi.orderapi.entities.Product;
import com.orderapi.orderapi.repository.ProductRepository;
import com.orderapi.orderapi.validations.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product findProductById(Long idProduct) {
        return productRepository.findById(idProduct)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Transactional
    public void deleteProductById(Long idProduct) {
        Product productFound = productRepository.findById(idProduct)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(productFound);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public Product saveProduct(Product product) {

        //Validator of the product object
        ProductValidator.save(product);

        if (product.getId() == null) {
            Product newProduct = productRepository.save(product);
            return newProduct;
        }
        Product existProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existProduct.setName(product.getName());
        existProduct.setPrice(product.getPrice());
        return existProduct;
    }

    /* above function make the instructions from this two functions
    @Transactional
    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Transactional
    public Product updateProduct(Product product) {
        Product existProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existProduct.setName(product.getName());
        existProduct.setPrice(product.getPrice());
        productRepository.save(existProduct);
        return existProduct;
    }
*/


}
