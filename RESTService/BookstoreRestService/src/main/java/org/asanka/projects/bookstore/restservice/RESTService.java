package org.asanka.projects.bookstore.restservice;

import org.asanka.projects.bookstore.beans.Author;
import org.asanka.projects.bookstore.dao.impl.AuthorDaoImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by asanka on 8/4/14.
 */
@Path("/bookstore")
public class RESTService {
/*
following method is for heart beat purposes
 */
//    @GET
//    @Path("/echo/{input}")
//    @Produces("text/plain")
//    public String ping(@PathParam("input") String input) {
//        return input;
//    }
//
//    @GET
//    @Path("/authors")
//    @Produces("application/json")
//    public Response getAuthors(){
//        AuthorDaoImpl authorDao=new AuthorDaoImpl();
//        StringBuilder resultBuilder=new StringBuilder();
//        JSONArray result=new JSONArray();
//        JSONObject tmp;
//        List<Author> authors=null;
//        try {
//              authors = authorDao.getAuthors();
////            for(Author author: authors){
////                tmp=new JSONObject();
////                tmp.put("id",author.getId());
////                tmp.put("name",author.getName());
////                result.add(tmp);
////            }
//         } catch (SQLException e) {
//            e.printStackTrace();
//        }
//     //   return Response.status(200).entity(result).build();
//        return Response.ok(authors, MediaType.APPLICATION_JSON).build();//returning json payload with response
//
//    }
//    @GET
//    @Path("/author/{name}")
//    @Produces("application/json")
//    public Response getAuthor(@PathParam("name") String name){
//        AuthorDaoImpl authorDao=new AuthorDaoImpl();
//        StringBuilder resultBuilder=new StringBuilder();
//        JSONArray result=new JSONArray();
//        JSONObject tmp;
//        Author author=null;
//        try {
//            author = authorDao.getAuthor(name);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        //   return Response.status(200).entity(result).build();
//        return Response.ok(author, MediaType.APPLICATION_JSON).build();//returning json payload with response
//
//    }
//
//    @POST
//    @Path("/add/author")
//    @Produces("text/plain")
//    public Response addAuthor(@FormParam("name") String name){
//        AuthorDaoImpl authorDao=new AuthorDaoImpl();
//        StringBuilder resultBuilder=new StringBuilder();
//        JSONObject tmp;
//        boolean result=false;
//        try {
//            result = authorDao.addAuthor(name);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        //   return Response.status(200).entity(result).build();
//        return Response.ok(result, MediaType.APPLICATION_JSON).build();//returning json payload with response
//    }
//
//
//
//
//



}
