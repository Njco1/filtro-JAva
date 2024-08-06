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

public class CourseModel implements CRUD {
    @Override
    public Object create(Object object) {
        //Open Connection
        Connection connection = ConfigDB.openConnection();

        //Transform Object
        Courses courses = (Courses) object;

        try{

            //Create SQLQUERY
            String sqlQuery = "INSERT INTO Cursos(nombre, id_estudiante_fk) values(?,?);";

            //Create Prepared Statement
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            //Assign to ?
            preparedStatement.setString(1, courses.getName());
            preparedStatement.setInt(2, Integer.parseInt(courses.getId_student_Courses()));

            //Query execute
            preparedStatement.execute();

            //Getting results
            ResultSet result = preparedStatement.getGeneratedKeys();

            while(result.next()){
                courses.setId((result.getInt(1)));
            }

            preparedStatement.close();

            JOptionPane.showMessageDialog(null, "The course has been successfully created", sqlQuery, 0);

        }catch (SQLException e){
            System.out.println("ERROR: The course could not be created correctly");
            e.printStackTrace();
        }

        //Close Connection
        ConfigDB.closeConnection();

        return courses;
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
        //Open Connection
        Connection connection = ConfigDB.openConnection();

        //Transform Object
        Courses courses = (Courses) object;

        try{

            //Create SQLQUERY
            String sqlQuery = "UPDATE Cursos SET nombre = ?, id_estudiante_fk = ? WHERE id_cursos = ?;";

            //Create Prepared Statement
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            //Assign to ?
            preparedStatement.setString(1, courses.getName());
            preparedStatement.setString(2, courses.getId_student_Courses());
            preparedStatement.setInt(3, id);

            //Query execute
            int updateData = preparedStatement.executeUpdate();

            preparedStatement.close();

            if (updateData > 0){
                JOptionPane.showMessageDialog(null, "The course has been updated correctly");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "The course was not found with this id.");
                return false;
            }

        }catch (SQLException e){
            System.out.println("ERROR: Could not update the course");
            e.printStackTrace();
            return false;
        }finally {
            ConfigDB.closeConnection();
        }
    }

    @Override
    public Boolean delete(int id) {

        Connection connection = ConfigDB.openConnection();

        try{

            String sqlQuery = "DELETE FROM Cursos WHERE id_cursos = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, id);

            int idDelete = preparedStatement.executeUpdate();

            preparedStatement.close();

            if (idDelete > 0) {
                JOptionPane.showMessageDialog(null, "The course has been successfully deleted", sqlQuery, idDelete);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "The course with this ID was not found.", sqlQuery, idDelete);
                return false;
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Course could not be deleted correctly", null, id);
            return false;
        }finally{
            ConfigDB.closeConnection();
        }
    }

    public ArrayList<Courses> readByName(String nombre) {

        // Open Connection
        Connection connection = ConfigDB.openConnection();
        ArrayList<Courses> CourseList = new ArrayList<>();

        try {
            // Create SQLQUERY to search for courses by name
            String sqlQuery = "SELECT * FROM Cursos WHERE nombre = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, nombre);

            // Query execute
            ResultSet resultSet = preparedStatement.executeQuery();

            // Getting results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameCourses = resultSet.getString("nombre");
                int id_Student = resultSet.getInt("id_estudiante_fk");

                // Create courses object and add to list
                Courses courses = new Courses(id, nameCourses, id_Student);
                CourseList.add(courses);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("ERROR: Error when searching by name ");
        } finally {
            ConfigDB.closeConnection();
        }

        return CourseList;
    }

}
