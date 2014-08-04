package org.asanka.projects.bookstore.dao;

import org.asanka.projects.bookstore.beans.Author;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by asanka on 8/4/14.
 */
public interface AuthorDao {

    public Author getAuthor(String name) throws SQLException;
    public boolean addAuthor(String name) throws SQLException;
    public void updateAuthor(Author author);
    public List<Author> getAuthors() throws SQLException;
    public boolean deleteAuthor(String name) throws SQLException;

}
