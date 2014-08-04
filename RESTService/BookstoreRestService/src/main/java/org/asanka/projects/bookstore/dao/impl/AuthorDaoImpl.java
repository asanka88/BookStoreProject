package org.asanka.projects.bookstore.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.asanka.projects.bookstore.beans.Author;
import org.asanka.projects.bookstore.dao.AuthorDao;
import org.asanka.projects.bookstore.dao.SQLQueries;
import org.asanka.projects.bookstore.dao.SQLTableColumnNames;
import org.asanka.projects.bookstore.utils.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asanka on 8/4/14.
 */
public class AuthorDaoImpl implements AuthorDao {
    private Log log= LogFactory.getLog(AuthorDaoImpl.class);
    private boolean isDebugEnabled=log.isDebugEnabled();

    Connection dbConnection=null;

    public AuthorDaoImpl(){
        javax.sql.DataSource datasource = Util.getDatasource();
        try {
            dbConnection= datasource.getConnection();
            if(isDebugEnabled){
                log.debug("DB connection acquired for "+ dbConnection.getSchema());
            }

        } catch (SQLException e) {
            log.error("Failed to create DB Connection "+e.getMessage());
            throw new NullPointerException("Database connection creation falied");
        }

    }

    /**
     * use this method to get the Author object when the user name is presence.
     * This method assumes that the author name field of the database table is unique.
     * @param name
     * @return
     * @throws SQLException
     */
    public Author getAuthor(String name) throws SQLException {
        if(isDebugEnabled){
            log.debug("inside getAuthors method");
        }
        PreparedStatement st=dbConnection.prepareStatement(SQLQueries.GET_AUHTOR_WITH_NAME);
        st.setString(1,name);
        ResultSet resultSet = st.executeQuery();
        Author result=null;
        int id;
         while(resultSet.next()){
            id=resultSet.getInt(SQLTableColumnNames.AUTHOR_TABLE_AUTHOR_ID);
             result =new Author(id,name);
        }

        if(isDebugEnabled){
            log.debug("Leaving getAuthors method");
        }
        return result;
    }

    public boolean addAuthor(String name) throws SQLException {
        if(isDebugEnabled){
            log.debug("inside getAuthors method");
        }
        PreparedStatement st=dbConnection.prepareStatement(SQLQueries.ADD_AUTHOR);
        st.setString(1,name);
        boolean result=st.execute();
        if(isDebugEnabled){
            log.debug("Leaving getAuthors method");
        }
        return result;
    }

    public void updateAuthor(Author author) {

    }

    public List<Author> getAuthors() throws SQLException {
        if(isDebugEnabled){
            log.debug("inside getAuthors method");
        }
        Statement st=dbConnection.createStatement();
        ResultSet resultSet = st.executeQuery(SQLQueries.GET_ALL_AUHTORS);
        List<Author> authorList= new ArrayList<Author>();
        int id;
        String name;
        while(resultSet.next()){
            id=resultSet.getInt(SQLTableColumnNames.AUTHOR_TABLE_AUTHOR_ID);
            name=resultSet.getString(SQLTableColumnNames.AUTHOR_TABLE_AUTHOR_NAME);
            authorList.add(new Author(id,name));
        }

        if(isDebugEnabled){
            log.debug("Leaving getAuthors method");
        }
        return authorList;

    }

    public boolean deleteAuthor(String name) throws SQLException {
        if(isDebugEnabled){
            log.debug("inside getAuthors method");
        }
        PreparedStatement st=dbConnection.prepareStatement(SQLQueries.DELETE_AUTHOR);
        st.setString(1,name);
        boolean result=st.execute();
        if(isDebugEnabled){
            log.debug("Leaving getAuthors method");
        }
        return result;    }
}
