package com.orderapi.orderapi.validations;

import com.orderapi.orderapi.entities.Product;

public class ProductValidator {

    public static void save(Product product) {

        if (product.getName() == null ||
                        product.getName().trim().isEmpty()) {
            throw new RuntimeException("The product name is invalid");
        }
        if (product.getName().length() > 200) {
            throw new RuntimeException("Th length of the product name is too long");
        }
        if (product.getPrice() == null) {
            throw new RuntimeException("The product price don't must be null");
        }
        if (product.getPrice() < 0) {
            throw new RuntimeException("The product price don't must be less than 0");
        }

    }

}
