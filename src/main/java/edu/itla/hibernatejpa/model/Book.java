package edu.itla.hibernatejpa.model;

import javax.persistence.*;


@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @Column(name = "BOOK_ID")
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL},  fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_AUTHOR")
    private Author author;

    @Column(name = "TITLE")
    private String title;

    public Book(){}

    public Book(Long id, Author author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (!id.equals(book.id)) return false;
        if (!author.equals(book.author)) return false;
        return title.equals(book.title);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", title='" + title + '\'' +
                '}';
    }
}
