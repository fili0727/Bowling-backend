package kea.eksamen.bowling.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Equipment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String imageURL;
    private int stock;
    private String restockURL;

    public Equipment(String name, String imageURL, int stock, String restockURL) {
        this.name = name;
        this.imageURL = imageURL;
        this.stock = stock;
        this.restockURL = restockURL;
    }

}
