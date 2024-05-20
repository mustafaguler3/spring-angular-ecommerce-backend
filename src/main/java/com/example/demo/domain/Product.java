package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private String pictureUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private Type type;

    public Product(Integer id, String name, String description, BigDecimal price, String pictureUrl, Type type,Brand brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.brand = brand;
        this.type = type;
    }

    public Integer getProductBrandId() {
        return (this.brand != null) ? this.brand.getId() : null;
    }

    public Integer getProductTypeId() {
        return (this.type != null) ? this.type.getId() : null;
    }
}
