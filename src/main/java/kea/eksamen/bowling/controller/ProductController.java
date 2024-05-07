package kea.eksamen.bowling.controller;

import kea.eksamen.bowling.entity.Product;
import kea.eksamen.bowling.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
