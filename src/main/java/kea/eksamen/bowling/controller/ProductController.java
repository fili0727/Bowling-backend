package kea.eksamen.bowling.controller;

import kea.eksamen.bowling.dto.ProductPriceDTO;
import kea.eksamen.bowling.entity.Product;
import kea.eksamen.bowling.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProductPrice(@PathVariable int id, @RequestBody ProductPriceDTO product) {
        return productService.updateProductPrice(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

}
