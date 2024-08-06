package org.example.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    static Connection connection = null;

    //Method to open
    public static Connection openConnection(){

        try{

            //Install drivers
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Credentials
            String URL = "jdbc:mysql://localhost:3306/RiwiAcademyDB";
            String user = "root";
            String password = "Rlwl2023.";

            //Establish the connection
            connection = DriverManager.getConnection(URL, user, password);
            System.out.println("Establish connection");

        }catch (ClassNotFoundException e){
            System.out.println("ERROR: Driver not found");
        }catch (SQLException e){
            System.out.println("ERROR: Connection failed");
        }

        return connection;

    }

    //Method to close

    public static void closeConnection(){

        try{

            if(connection !=null){
                connection.close();
                System.out.println("Connection finished");
            }

        }catch (SQLException e){
            System.out.println("ERROR: Connection not completed");
        }

    }

}
