package org.asanka.projects;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.asanka.projects.bookstore.beans.Author;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        deleteAuthor("madhawa");//addAuthor("madhawa");
        getAuthors();


    }

    private static void getAuthors() {
        final String URL="http://10.100.0.182:9763/BookstoreRestService-1.0.0/author/getAll";

        HttpClient httpClient= new HttpClient();
        GetMethod getAuthors=new GetMethod(URL);
        getAuthors.setRequestHeader("Content-Type", "application/json");
        try {
            int result= httpClient.executeMethod(getAuthors);
            String jsonString= getAuthors.getResponseBodyAsString();
            JSONArray array= (JSONArray) new JSONParser().parse(jsonString);
            for(Object item :array){
                JSONObject p= (JSONObject)item;

                System.out.println("Name--"+p.get("name"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void addAuthor(String name){
        final String URL="http://10.100.0.182:9763/BookstoreRestService-1.0.0/author/add";

        HttpClient client=new HttpClient();
        PostMethod post=new PostMethod(URL);
        post.addParameter("name",name);
        try {
            client.executeMethod(post);
            String res=post.getResponseBodyAsString();
            System.out.println(res);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void deleteAuthor(String name){
        final String URL="http://10.100.0.182:9763/BookstoreRestService-1.0.0/author/"+name;

        HttpClient client=new HttpClient();
        DeleteMethod delete=new DeleteMethod(URL);
        try {
            client.executeMethod(delete);
            String res=delete.getResponseBodyAsString();
            System.out.println(res);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
