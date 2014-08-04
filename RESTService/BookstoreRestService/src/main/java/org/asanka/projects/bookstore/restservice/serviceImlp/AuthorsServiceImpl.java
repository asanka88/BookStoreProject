package org.asanka.projects.bookstore.restservice.serviceImlp;

import org.asanka.projects.bookstore.beans.Author;
import org.asanka.projects.bookstore.dao.impl.AuthorDaoImpl;
import org.asanka.projects.bookstore.restservice.interfaces.AuthorsService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by asanka on 8/4/14.
 */
public class AuthorsServiceImpl implements AuthorsService {

    public Response getAuthor(String name) {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        StringBuilder resultBuilder = new StringBuilder();
        JSONArray result = new JSONArray();
        JSONObject tmp;
        Author author = null;
        try {
            author = authorDao.getAuthor(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //   return Response.status(200).entity(result).build();
        return Response.ok(author, MediaType.APPLICATION_JSON).build();//returning json payload with response

    }

    public Response getAuthors() {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        StringBuilder resultBuilder = new StringBuilder();
        JSONArray result = new JSONArray();
        JSONObject tmp;
        List<Author> authors = null;
        try {
            authors = authorDao.getAuthors();
//            for(Author author: authors){
//                tmp=new JSONObject();
//                tmp.put("id",author.getId());
//                tmp.put("name",author.getName());
//                result.add(tmp);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //   return Response.status(200).entity(result).build();
        return Response.ok(authors, MediaType.APPLICATION_JSON).build();//returning json payload with response
    }

    public Response addAuthor(String name) {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        boolean result = false;
        try {
            result = authorDao.addAuthor(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //   return Response.status(200).entity(result).build();
        return Response.ok(result, MediaType.TEXT_PLAIN).build();//returning json payload with response
    }

    public Response deleteAuthor(String name) {
        AuthorDaoImpl authorDao = new AuthorDaoImpl();
        boolean result = false;
        try {
            result = authorDao.deleteAuthor(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //   return Response.status(200).entity(result).build();
        return Response.ok(result, MediaType.TEXT_PLAIN).build();//returning json payload with response    }
    }
}

