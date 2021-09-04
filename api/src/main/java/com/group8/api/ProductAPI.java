package com.group8.api;

import com.group8.models.Product;
import com.group8.models.ProductDTO;
import org.springframework.http.ResponseEntity;

public interface ProductAPI {
    ResponseEntity<Product> getProductById(int productId);

    ResponseEntity<Product[]> getAllProducts();

    ResponseEntity<Product> createProduct(ProductDTO productDTO);

    ResponseEntity<Product> updateProduct(int productId, ProductDTO productDTO);

    ResponseEntity<Product> deleteProduct(int productId);

    String API_VERSION = "/v1";
    String API_BASE_PATH = API_VERSION + "/api/products/";
    String API_PATH_WITH_ID = API_BASE_PATH + "/{productId}";
}

