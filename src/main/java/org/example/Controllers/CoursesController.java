package org.example.Controllers;

import org.example.Entities.Courses;
import org.example.Entities.Students;
import org.example.Model.CourseModel;
import org.example.Model.StudentModel;

import javax.swing.*;
import java.util.ArrayList;

public class CoursesController {

    //Model attribute
    CourseModel objCourseModel;

    public CoursesController(){
        //Create the model instance
        this.objCourseModel = new CourseModel();
    }

    public void create(){


        //Insert course name
        String name = JOptionPane.showInputDialog("Insert course's name: ");

        //Insert id of the student in the course
        int id_estudiante = Integer.parseInt(JOptionPane.showInputDialog(("Insert student's id in this course:  ")));

        Courses objCourse = new Courses(name, id_estudiante);

        Courses result = (Courses) this.objCourseModel.create(objCourse);

        JOptionPane.showMessageDialog(null,result);

    }

    public void readByName() {
        // Request the name of the course to search
        String name = JOptionPane.showInputDialog("Insert the name of the course you wish to search: ");

        ArrayList<Courses> CourseList = this.objCourseModel.readByName(name);

        if (!CourseList.isEmpty()) {
            // Show details of the courses found
            StringBuilder Result = new StringBuilder("Courses found:\n");
            for (Courses courses : CourseList) {
                Result.append("ID: ").append(courses.getId())
                        .append(", nombre: ").append(courses.getName())
                        .append("\n");
            }
            JOptionPane.showMessageDialog(null, Result.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No courses were found with this name");
        }
    }

    public void update(){

        //Ask for the id to be updated
        int id_Uptade = Integer.parseInt(JOptionPane.showInputDialog("Enter the id to uptade: "));

        //Current data Course
        /*Students currentData = (Students) this.objStudentModel.uptade(Students, id_Uptade);

        if (currentData != null){
            //Current data
            JOptionPane.showMessageDialog(null, "Informacion actual del estudiante:\n" + "name: " + currentData.getName() + "\n lastName: " + currentData.getLastName() + "\n email: " + currentData.getEmail());
*/
        //New info Course
        String newName = JOptionPane.showInputDialog("Insert the new name: ");
        int newId = Integer.parseInt(JOptionPane.showInputDialog("Insert the new id: "));

        //Uptade object
        Courses coursesUpdate = new Courses(id_Uptade, newName,newId);

        this.objCourseModel.uptade(coursesUpdate, id_Uptade);

    }

    public void delete(){

        int idForDelete = Integer.parseInt(JOptionPane.showInputDialog("Enter the Id to delete: "));

        boolean deleteId = this.objCourseModel.delete(idForDelete);

        if (deleteId == true) {
            JOptionPane.showMessageDialog(null, "The course has been successfully deleted");
        }else{
            JOptionPane.showMessageDialog(null, "Error while deleting the course, check the id to be deleted", null, idForDelete);
        }

    }

}
