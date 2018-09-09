package com.sda.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)          // wybieranie sposobu w jaki ma byc ustawiany klucz
    private int id;
    @Column                                                      // @Column(name =" ") sluzy do zmieniania nazwy kolumny
    private String title;
    @Column
    private String isbn;
    @Column
    private String author;
    @ManyToOne(cascade = CascadeType.ALL)
    private Set<Author> authors;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    private Publisher publisher;

    public Book(String title, String isbn, String author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public Book() {
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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