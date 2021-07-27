package com.orderapi.orderapi.controllers;

import com.orderapi.orderapi.converters.ProductConverter;
import com.orderapi.orderapi.dtos.ProductDTO;
import com.orderapi.orderapi.entities.Product;
import com.orderapi.orderapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    private final ProductConverter productConverter = new ProductConverter();

    @GetMapping(value = "/products/{idProduct}")
    public ResponseEntity<ProductDTO> findProductById(
            @PathVariable(value = "idProduct") Long idProduct
    ) {
        Product product = productService.findProductById(idProduct);
        ProductDTO productDTO = productConverter.fromEntity(product);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/products/{idProduct}")
    public ResponseEntity<Void> deleteProductById(
            @PathVariable(value = "idProduct") Long idProduct
    ) {
        productService.deleteProductById(idProduct);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<Product> listProducts = productService.getProducts();
        List<ProductDTO> listProductsDTO = productConverter.fromEntity(listProducts);
        return new ResponseEntity<>(listProductsDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/products")
    public ResponseEntity<ProductDTO> createProduct(
            @RequestBody ProductDTO product
    ) {
        Product newProduct = productService.saveProduct(productConverter.fromDTO(product));
        ProductDTO productDTO = productConverter.fromEntity(newProduct);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }


    @PutMapping(value = "/products")
    public ResponseEntity<ProductDTO> updateProduct(
            @RequestBody ProductDTO product
    ) {
        Product existProduct = productService.saveProduct(productConverter.fromDTO(product));
        ProductDTO productDTO = productConverter.fromEntity(existProduct);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }




    /* Test operations
    private final List<Product> listProducts = new ArrayList<>();

    public ProductController() {
        for (int i = 0; i < 10; i++) {
            listProducts.add(new Product(
                    i+1L,
                    "Product"+(i+1L)
            ));
        }
    }

    @GetMapping(value = "/products")
    public List<Product> findAll() {
        return listProducts;
    }

    @GetMapping(value = "/products/{id}")
    public Product findById(@PathVariable(value = "id") Long id){
        for(Product productCreate : this.listProducts){
            if (productCreate.getId() == id.longValue()) return productCreate;
        }
        return null;
    }

    @PostMapping(value = "/products")
    public Product createProduct(@RequestBody Product product){
        this.listProducts.add(product);
        return product;
    }

    @PutMapping(value = "/products")
    public Product updateProduct(@RequestBody Product product) {
        for (Product productUpdate : this.listProducts){
            if(productUpdate.getId() == product.getId().longValue()){
                productUpdate.setName(product.getName());
                return productUpdate;
            }
        }
        throw new RuntimeException("Product not found");
    }

    @DeleteMapping(value = "/products/{id}")
    public void deleteProduct(@PathVariable(value = "id") Long id){
        this.listProducts.removeIf(productDelete -> productDelete.getId() == id.longValue());
    }

*/


}
