package edu.itla.hibernatejpa.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AUTHOR")
public class Author {

    @Id
    @Column(name = "ID_AUTHOR")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NACIONALITY")
    private String nacionality;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    public Author() {}

    public Author(Long id, String name, String nacionality) {
        this.id = id;
        this.name = name;
        this.nacionality = nacionality;
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

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nacionality='" + nacionality + '\'' +
                '}';
    }
}

