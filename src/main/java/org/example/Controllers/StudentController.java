package org.example.Controllers;

import org.example.Entities.Courses;
import org.example.Entities.Students;
import org.example.Model.StudentModel;

import javax.swing.*;
import java.util.ArrayList;

public class StudentController {

    //Model attribute
    StudentModel objStudentModel;

    public StudentController(){
        //Create the model instance
        this.objStudentModel = new StudentModel();
    }

    public void create(){

        //Insert students name
        String name = JOptionPane.showInputDialog("Insert student's name: ");

        //Insert lastname
        String lastName = JOptionPane.showInputDialog(("Insert student's last name:  "));

        //Insert email
        String email = JOptionPane.showInputDialog(("Insert the student's email address: "));

        Students objStudent = new Students(name, lastName, email);

        Students result = (Students) this.objStudentModel.create(objStudent);

        JOptionPane.showMessageDialog(null,result);

    }

    public void update(){

        //Ask for the id to be updated
        int id_Uptade = Integer.parseInt(JOptionPane.showInputDialog("Enter the id to uptade: "));

        //Current data students
        /*Students currentData = (Students) this.objStudentModel.uptade(Students, id_Uptade);

        if (currentData != null){
            //Current data
            JOptionPane.showMessageDialog(null, "Informacion actual del estudiante:\n" + "name: " + currentData.getName() + "\n lastName: " + currentData.getLastName() + "\n email: " + currentData.getEmail());
*/
            //New info Stundents
            String newName = JOptionPane.showInputDialog("Insert the new name: ");
            String newLastName = JOptionPane.showInputDialog("Insert the new lastname: ");
            String newEmail = JOptionPane.showInputDialog("Insert the new email: ");

            //Uptade object
            Students studentsUptade = new Students(id_Uptade, newName, newLastName, newEmail);

            this.objStudentModel.uptade(studentsUptade, id_Uptade);


        }

    public void readById() {

        // Request the ID of the student to be consulted
        int id_Search = Integer.parseInt(JOptionPane.showInputDialog("Insert the ID of the student you wish to consult: "));

        Students students = (Students) this.objStudentModel.readById(id_Search);

        if (students != null) {
            // Show the details of the student found
            JOptionPane.showMessageDialog(null, "Estudiante encontrado:\n" + "ID: " + students.getId() + "\n Nombre: " + students.getName() + "\n Apellido: " + students.getLastName() + "\n Email " + students.getEmail());
        } else {
            JOptionPane.showMessageDialog(null, "No student with the specified ID found");
        }
    }

    public void readByEmail() {
        // Request the email of the student to search
        String email = JOptionPane.showInputDialog("Insert the email of the student you wish to search: ");

        ArrayList<Students> emailList = this.objStudentModel.readByEmail(email);

        if (!emailList.isEmpty()) {
            // Show details of the courses found
            StringBuilder Result = new StringBuilder("Courses found:\n");
            for (Students students : emailList) {
                Result.append("ID: ").append(students.getId())
                        .append(", nombre: ").append(students.getName())
                        .append(", apellido: ").append(students.getLastName())
                        .append("\n");
            }
            JOptionPane.showMessageDialog(null, Result.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No students were found with this email");
        }
    }

    }


