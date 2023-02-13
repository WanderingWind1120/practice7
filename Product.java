package com.example.practice7.models;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Objects;

@Entity
@Table (name = "tblproduct")
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1;
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence";
    )
    private Long id;
    private int year;
    private String url;
    @Transient
    private int age;
    private int price;
    private String productName;

    public Product(String year, String url, int price, String productName) {
        this.year = year;
        this.url = url;
        this.price = price;
        this.productName = productName;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getUrl() {
        return url;
    }

    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR)- year;
    }

    public int getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return year == product.year && age == product.age && price == product.price && Objects.equals(id, product.id) && Objects.equals(url, product.url) && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, url, age, price, productName);
    }
}