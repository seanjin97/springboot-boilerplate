package com.group8.controllers;

import com.group8.api.ProductAPI;
import com.group8.models.Product;
import com.group8.models.ProductDTO;
import com.group8.models.Rating;
import com.group8.utils.PropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class ProductController implements ProductAPI {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final PropertiesReader propertiesReader;
    private final RestTemplate restTemplate;
    private final String API;

    @Autowired
    public ProductController(PropertiesReader propertiesReader, RestTemplate restTemplate) {
        this.propertiesReader = propertiesReader;
        this.restTemplate = restTemplate;
        this.API = propertiesReader.getThirdPartyAPIUrl();
    }

    @GetMapping(API_PATH_WITH_ID)
    public ResponseEntity<Product> getProductById(@PathVariable("productId") int productId) {
        logger.info(API_PATH_WITH_ID + ": GET request received");
        Product product = restTemplate.getForObject(API + productId, Product.class);
        return ResponseEntity.ok(product);
    }

    @GetMapping(API_BASE_PATH)
    public ResponseEntity<Product[]> getAllProducts(){
        logger.info(API_BASE_PATH + ": GET ALL request received");
        Product[] products = restTemplate.getForObject(API, Product[].class);
        return ResponseEntity.ok(products);
    }

    @PostMapping(API_BASE_PATH)
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
        logger.info(API_PATH_WITH_ID + ": POST request received");
        Product newProduct = restTemplate.postForObject(API, productDTO, Product.class);
        return ResponseEntity.ok(newProduct);
    }

    @PutMapping(API_PATH_WITH_ID)
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") int productId, @RequestBody ProductDTO productDTO) {
        logger.info(API_PATH_WITH_ID + ": PUT request received");
        // Get response from PUT request
        // https://stackoverflow.com/questions/16899179/get-string-response-from-resttemplate-put
        // Have to use restTemplate.exchange to get access to response body
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProductDTO> entity = new HttpEntity<>(productDTO, headers);
        ResponseEntity<Product> productResponseEntity = restTemplate.exchange(API + productId, HttpMethod.PUT, entity, Product.class);
        return ResponseEntity.ok(productResponseEntity.getBody());
    }

    @DeleteMapping(API_PATH_WITH_ID)
    public ResponseEntity<Product> deleteProduct(@PathVariable ("productId") int productId) {
        logger.info(API_PATH_WITH_ID + ": DELETE request received");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProductDTO> entity = new HttpEntity<>(headers);
        ResponseEntity<Product> productResponseEntity = restTemplate.exchange(API + productId, HttpMethod.DELETE, entity, Product.class);
        return ResponseEntity.ok(productResponseEntity.getBody());
    }
}
