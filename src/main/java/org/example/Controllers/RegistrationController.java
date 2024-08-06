package org.example.Controllers;

import org.example.Entities.Courses;
import org.example.Entities.Registration;
import org.example.Model.CourseModel;
import org.example.Model.RegistrationModel;

import javax.swing.*;

public class RegistrationController {
    //Model attribute
    RegistrationModel objRegistrationModel;

    public RegistrationController(){
        //Create the model instance
        this.objRegistrationModel = new RegistrationModel();
    }

    public void create(){

        //Insert course name
        String name = JOptionPane.showInputDialog("Insert course's name: ");


        //Id of student in the course
        int id_student = Integer.parseInt(JOptionPane.showInputDialog(("Insert student's id in this course:  ")));


        //Insert num of courses for the student
        int courses_of_student = Integer.parseInt(JOptionPane.showInputDialog(("Insert courses student is in him:  ")));

        Registration objRegistration = new Registration(name, id_student, courses_of_student);

        Registration result = (Registration) this.objRegistrationModel.create(objRegistration);

        JOptionPane.showMessageDialog(null,result);

    }

}
