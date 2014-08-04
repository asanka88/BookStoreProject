package org.asanka.projects.bookstore.dao;

/**
 * Created by asanka on 8/4/14.
 */
public class SQLQueries {
    public final static String GET_ALL_AUHTORS="SELECT * FROM AUTHORS";
    public final static String GET_AUHTOR_WITH_NAME ="SELECT * FROM AUTHORS WHERE name=?";
    public final static String ADD_AUTHOR="INSERT INTO AUTHORS (name) VALUES (?)";
    public final static String DELETE_AUTHOR="DELETE FROM AUTHORS WHERE name=?";


}
