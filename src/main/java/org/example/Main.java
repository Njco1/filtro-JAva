package org.example;

import org.example.Controllers.CoursesController;
import org.example.Controllers.StudentController;
import org.example.Entities.Students;
import org.example.Persistence.ConfigDB;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        ConfigDB.openConnection();

        StudentController objStudentController = new StudentController();
        CoursesController objCoursesController = new CoursesController();

        int Menu = Integer.parseInt(JOptionPane.showInputDialog("Sr usuario, que desea realizar: \n" +
                "1: Crear estudiante \n" +
                "2: Actualizar estudiantes \n" +
                "3: Ver estudiantes por ID \n" +
                "4: Buscar estudiante por email \n" +
                "5: Crear Curso \n" +
                "6: Buscar curso por nombre \n" +
                "7: Actualizar curso \n" +
                "8: Eliminar curso \n"));

        switch (Menu){

            case 1:
                objStudentController.create();
                break;

            case 2:
                objStudentController.update();
                break;

            case 3:
                objStudentController.readById();
                break;

            case 4:
                    objStudentController.readByEmail();
                break;

            case 5:
                objCoursesController.create();
                break;

            case 6:
                break;

            case 7:
                objCoursesController.update();
                break;

            case 8:
                objCoursesController.delete();

        }



        //objStudentController.readAll();
        //objCoursesController.readByName();





        ConfigDB.closeConnection();

    }
}