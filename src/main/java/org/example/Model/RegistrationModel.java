package org.example.Model;

import org.example.Entities.Courses;
import org.example.Entities.Registration;
import org.example.Entities.Students;
import org.example.Persistence.CRUD;
import org.example.Persistence.ConfigDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegistrationModel  implements CRUD {
    @Override
    public Object create(Object object) {
        //Open Connection
        Connection connection = ConfigDB.openConnection();

        //Transform Object
        Registration registration = (Registration) object;

        try{

            //Create SQLQUERY
            String sqlQuery = "INSERT INTO Inscripciones(nombre_curso,id_estudiante_fk, cursos_estudiante values(?,?,?);";

            //Create Prepared Statement
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            //Assign to ?
            preparedStatement.setString(1, registration.getNombre_curso());
            preparedStatement.setInt(2, Integer.parseInt(registration.getId_student_Registration()));
            preparedStatement.setInt(3, Integer.parseInt(registration.getCursos_estudiante()));

            //Query execute
            preparedStatement.execute();

            //Getting results
            ResultSet result = preparedStatement.getGeneratedKeys();

            while(result.next()){
                registration.setId((result.getInt(1)));
            }

            preparedStatement.close();

            JOptionPane.showMessageDialog(null, "The registration has been successfully created", sqlQuery, 0);

        }catch (SQLException e){
            System.out.println("ERROR: The registration could not be created correctly");
            e.printStackTrace();
        }

        //Close Connection
        ConfigDB.closeConnection();

        return registration;
    }

    @Override
    public Object readById(int id) {
        return null;
    }

    @Override
    public ArrayList<Students> readAll() {
        return null;
    }

    @Override
    public Object uptade(Object object, int id) {
        return null;
    }

    @Override
    public Boolean delete(int id) {
        return null;
    }
}
