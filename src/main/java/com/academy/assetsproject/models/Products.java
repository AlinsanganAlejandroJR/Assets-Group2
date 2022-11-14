package com.academy.assetsproject.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private LocalDate dateOfPurchase;

    public Products(Long id, String name, double price, LocalDate dateOfPurchase) {
        Id = id;
        this.name = name;
        this.price = price;
        this.dateOfPurchase = dateOfPurchase;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    @Override
    public String toString() {
        return "Products{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", dateOfPurchase=" + dateOfPurchase +
                '}';
    }
}
