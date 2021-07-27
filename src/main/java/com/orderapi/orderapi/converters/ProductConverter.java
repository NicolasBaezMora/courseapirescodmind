package com.orderapi.orderapi.converters;

import com.orderapi.orderapi.dtos.ProductDTO;
import com.orderapi.orderapi.entities.Product;

public class ProductConverter extends AbstractConverter<Product, ProductDTO> {

    @Override
    public ProductDTO fromEntity(Product entity) {
        return new ProductDTO(
                entity.getId(),
                entity.getName(),
                entity.getPrice()
        );
    }

    @Override
    public Product fromDTO(ProductDTO dto) {
        return new Product(
                dto.getId(),
                dto.getName(),
                dto.getPrice()
        );
    }
}
