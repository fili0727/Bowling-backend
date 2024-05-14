package kea.eksamen.bowling.repositories;

import kea.eksamen.bowling.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
