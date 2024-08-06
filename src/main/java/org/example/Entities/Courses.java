package org.example.Entities;

public class Courses {

    private int id;
    private String name;
    private int id_student_Courses;

    //Generate constructors and getter and setter

    public Courses(){}

    public Courses(String name, int id_student_Courses){
        this.name = name;
        this.id_student_Courses = id_student_Courses;
    }

    public Courses(int id, String name, int id_student_Courses){
        this.id = id;
        this.name = name;
        this.id_student_Courses = id_student_Courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId_student_Courses() {
        return String.valueOf(id_student_Courses);
    }

    public void setId_student_Courses(int id_student_Courses) {
        this.id_student_Courses = id_student_Courses;
    }

    @Override

    public String toString(){
        return "Courses {"+
                "id" + this.id +
                "name" + this.name +
                "id_student_Courses" + this.id_student_Courses +
                "}";
    }

}
