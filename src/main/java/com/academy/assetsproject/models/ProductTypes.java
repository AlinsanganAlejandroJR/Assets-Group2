package com.academy.assetsproject.models;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;

@Entity
public class ProductTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String productTypeName;


    public ProductTypes() {
    }

    public ProductTypes(Long id, String productTypeName) {
        this.id = id;
        this.productTypeName = productTypeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
}
