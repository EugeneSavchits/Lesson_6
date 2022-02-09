package core;


import org.testng.log4testng.Logger;

import java.sql.Connection;

public class DataBaseService {
    public static Logger logger = Logger.getLogger(DataBaseService.class);

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASSWORD = "postgres";

    Connection connection = null;

    public DataBaseService(){
        try{
            Class.forName("org.postgresql.Driver");
        }catch ()

    }
}
