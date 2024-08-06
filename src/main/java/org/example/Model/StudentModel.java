package org.example.Model;

import org.example.Entities.Courses;
import org.example.Entities.Students;
import org.example.Persistence.CRUD;
import org.example.Persistence.ConfigDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentModel  implements CRUD {

    @Override
    public Object create(Object object) {

        //Open Connection
        Connection connection = ConfigDB.openConnection();

        //Transform Object
        Students students = (Students) object;

        try{

            //Create SQLQUERY
            String sqlQuery = "INSERT INTO Estudiantes(nombre, apellido, correo_electronico) values(?,?,?);";

            //Create Prepared Statement
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            //Assign to ?
            preparedStatement.setString(1, students.getName());
            preparedStatement.setString(2, students.getLastName());
            preparedStatement.setString(3, students.getEmail());

            //Query execute
            preparedStatement.execute();

            //Getting results
            ResultSet result = preparedStatement.getGeneratedKeys();

            while(result.next()){
                students.setId((result.getInt(1)));
            }

            preparedStatement.close();

            JOptionPane.showMessageDialog(null, "The student has been successfully created", sqlQuery, 0);

        }catch (SQLException e){
            System.out.println("ERROR: The student could not be created correctly");
        }

        //Close Connection
        ConfigDB.closeConnection();

        return students;
    }

    @Override
    public Object readById(int id) {


        //Open Connection
        Connection connection = ConfigDB.openConnection();

        Students students = null;

        try{

            //Create SQLQUERY
            String sqlQuery = "SELECT * FROM Estudiantes WHERE id_estudiante = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("nombre");
                String lastName = resultSet.getString("apellido");
                String email = resultSet.getString("correo_electronico");

                students = new Students(id, name, lastName, email);
            }

        }catch(SQLException e){
            System.out.println("ERROR: The student could not be consulted ");
        }

        ConfigDB.closeConnection();
        return students;

    }

    @Override
    public ArrayList<Students> readAll() {

        //Open Connection
        Connection connection = ConfigDB.openConnection();

        //Transform Object-Arraylist
        ArrayList<Students> students_ = new ArrayList<>();

        try{

            //Create SQLQUERY
            String sqlQuery = "SELECT * FROM Estudiantes;";

            //Create Prepared Statement
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            //Getting results
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                int id = result.getInt("id");
                String name = result.getString("nombre");
                String apellido = result.getString("apellido");
                String email = result.getString("correo_electronico");

                Students stundents = new Students(id, name, apellido, email);
                students_.add(stundents);
            }

            preparedStatement.close();


        }catch (SQLException e){
            System.out.println("ERROR: Unable to search for students");
        }

        ConfigDB.closeConnection();

        return students_;
    }

    @Override
    public Object uptade(Object object, int id) {

        //Open Connection
        Connection connection = ConfigDB.openConnection();

        //Transform Object
        Students students = (Students) object;

        try{

            //Create SQLQUERY
            String sqlQuery = "UPDATE Estudiantes SET nombre = ?, apellido = ?, correo_electronico = ? WHERE id_estudiante = ?;";

            //Create Prepared Statement
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            //Assign to ?
            preparedStatement.setString(1, students.getName());
            preparedStatement.setString(2, students.getLastName());
            preparedStatement.setString(3, students.getEmail());
            preparedStatement.setInt(4, id);

            //Query execute
            int updateData = preparedStatement.executeUpdate();

            preparedStatement.close();

            if (updateData > 0){
                JOptionPane.showMessageDialog(null, "The student has been updated correctly");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "The student was not found with this id.");
                return false;
            }

        }catch (SQLException e){
            System.out.println("ERROR: Could not update the student"+e.getMessage());

            return false;
        }finally {
            ConfigDB.closeConnection();
        }
    }

    @Override
    public Boolean delete(int id) {
        return null;
    }

    public ArrayList<Students> readByEmail(String email) {

        // Open Connection
        Connection connection = ConfigDB.openConnection();
        ArrayList<Students> emailList = new ArrayList<>();

        try {
            // Create SQLQUERY to search for courses by name
            String sqlQuery = "SELECT * FROM Estudiantes WHERE correo_electronico = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, email);

            // Query execute
            ResultSet resultSet = preparedStatement.executeQuery();

            // Getting results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameCourses = resultSet.getString("nombre");
                String lastNameCourses = resultSet.getString("apellido");

                // Create courses object and add to list
                Students students = new Students(id, nameCourses, lastNameCourses);
                emailList.add(students);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("ERROR: Error when searching by email ");
        } finally {
            ConfigDB.closeConnection();
        }

        return emailList;
    }

}


