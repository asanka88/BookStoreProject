package org.asanka.projects.bookstore.beans;

import java.util.List;

/**
 * Created by asanka on 8/4/14.
 */
public class Author {
    private int id;
    private String name;
    private List<Book> books=null;

    public Author(int id,String name){
        this.id=id;
        this.name=name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


}
