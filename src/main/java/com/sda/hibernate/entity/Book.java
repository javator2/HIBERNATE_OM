package com.sda.hibernate.entity;

import javax.persistence.*;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private String isbn;
    @Column
    private String author;

    public Book(String tytle, String isbn, String author) {
        this.title = tytle;
        this.isbn = isbn;
        this.author = author;
    }

    public Book() {
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTytle() {
        return title;
    }
    public void setTytle(String tytle) {
        this.title = tytle;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }


}
