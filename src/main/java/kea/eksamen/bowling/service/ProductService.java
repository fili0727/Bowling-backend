package kea.eksamen.bowling.service;

import kea.eksamen.bowling.dto.ProductPriceDTO;
import kea.eksamen.bowling.entity.Product;
import kea.eksamen.bowling.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        if(product.getId() != null){
            throw new IllegalArgumentException("You cannot provide the id for a new product");
        }
        return productRepository.save(product);
    }

    public Product updateProductPrice(int id, ProductPriceDTO productPriceDTO) {
        Product productToUpdate = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        productToUpdate.setPrice(productPriceDTO.price());
        productRepository.save(productToUpdate);
        return productToUpdate;
    }


    public ResponseEntity deleteProduct(int id){
        Product productToDelete = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        productRepository.delete(productToDelete);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
