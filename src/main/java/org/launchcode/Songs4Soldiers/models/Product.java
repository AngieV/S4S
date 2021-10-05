package org.launchcode.Songs4Soldiers.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Product {

    @Id
    private final Integer ID;

    private final String category;

    private final String name;

    private final String description;

    private final Double price;

    private final String imageName;

    public Product(Integer ID, String category, String name, String description, Double price, String imageName) {
        this.ID = ID;
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageName = imageName;
    }



    public int getId() {
        return ID;
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
                "id=" + ID +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product products = (Product) o;
        return getId() == products.getId() && getName().equals(products.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
