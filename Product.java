package org.launchcode.Songs4Soldiers.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Product extends AbstractEntity{


    private final String category;

    private final String name;

    private final String description;

    private final Double price;

    private final String imageName;

    public Product(String category, String name, String description, Double price, String imageName) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageName = imageName;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImage() {
        return imageName;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

}
