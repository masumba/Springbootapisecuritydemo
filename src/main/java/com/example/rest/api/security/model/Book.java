package com.example.rest.api.security.model;

import com.example.rest.api.security.error.validator.Author;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Please Provide a Name")
    private String name;

    @NotEmpty(message = "Please Provide a Author")
    @Author
    private String author;

    @NotNull(message = "Please Provide a Price")
    @DecimalMin("1.00")
    private BigDecimal price;

    public Book() {
    }

    public Book(Long id, @NotEmpty(message = "Please Provide a Name") String name, @NotEmpty(message = "Please Provide a Author") String author, @NotNull(message = "Please Provide a Price") @DecimalMin("1.00") BigDecimal price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book(@NotEmpty(message = "Please Provide a Name") String name, @NotEmpty(message = "Please Provide a Author") String author, @NotNull(message = "Please Provide a Price") @DecimalMin("1.00") BigDecimal price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
