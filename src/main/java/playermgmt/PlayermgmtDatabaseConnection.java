package playermgmt;

import java.sql.*;

public class PlayermgmtDatabaseConnection{
    static private String dbUser = "?user=postgres";
    static private String dbPW = "&password=asdf1234";
    static private String dbURN = "//localhost:5432/postgres";

    static public Connection dbConnection()throws Exception{
        try {
            Connection cn=DriverManager.getConnection("jdbc:postgresql:"+dbURN+dbUser+dbPW+"&stringtype=unspecified");

            return cn;
            
        } catch (SQLException ex) {
            System.out.println("Failed to create the database connection.");
            return null;
        }

    }  

    public static String dbUser(){
        return dbUser;
    }

    public static String dbPassword(){
        return dbPW;
    }

    public static String dbURN(){
        return dbURN;
    }
}