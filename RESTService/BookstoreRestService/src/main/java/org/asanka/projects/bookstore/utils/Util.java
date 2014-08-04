package org.asanka.projects.bookstore.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.naming.InitialContext;


/**
 * Created by asanka on 8/4/14.
 */

public class Util {
    private static javax.sql.DataSource dataSource=null;
    private static Log log= LogFactory.getLog(Util.class);
    private static boolean isDebugEnabled=log.isDebugEnabled();
    public static javax.sql.DataSource getDatasource() {
        if(isDebugEnabled){
            log.debug("==About to aquire db connection");
        }
        if(dataSource==null){

            try {
                dataSource= (javax.sql.DataSource)(new InitialContext().lookup("jdbc/bookstoreDB"));
                 if(isDebugEnabled){
                    log.debug("Datasource aquired successfully");
                }
            } catch (Exception e) {
                log.error("Error occured while aquiring datasource"+ e.getMessage());
                throw new NullPointerException("Database acquisition failed");
            }
        }

        return dataSource;
    }
}
