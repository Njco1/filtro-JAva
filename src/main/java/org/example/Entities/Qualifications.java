package org.example.Entities;

public class Qualifications {

    private int id;
    private String Qualifications_and_Description;
    private int id_student_Qualifications;
    private int id_courses_Qualifications;

    //Generate constructors and getter and setter

    public Qualifications(){}

    public Qualifications(String Qualifications_and_Description, int id_student_Qualifications, int id_courses_Qualifications){
        this.Qualifications_and_Description = Qualifications_and_Description;
        this.id_student_Qualifications = id_student_Qualifications;
        this.id_courses_Qualifications = id_courses_Qualifications;
    }

    public Qualifications(int id, String Qualifications_and_Description, int id_student_Qualifications, int id_courses_Qualifications){
        this.id = id;
        this.Qualifications_and_Description = Qualifications_and_Description;
        this.id_student_Qualifications = id_student_Qualifications;
        this.id_courses_Qualifications = id_courses_Qualifications;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQualifications_and_Description() {
        return Qualifications_and_Description;
    }

    public void setQualifications_and_Description(String qualifications_and_Description) {
        Qualifications_and_Description = qualifications_and_Description;
    }

    public int getId_student_Qualifications() {
        return id_student_Qualifications;
    }

    public void setId_student_Qualifications(int id_student_Qualifications) {
        this.id_student_Qualifications = id_student_Qualifications;
    }

    public int getId_courses_Qualifications() {
        return id_courses_Qualifications;
    }

    public void setId_courses_Qualifications(int id_courses_Qualifications) {
        this.id_courses_Qualifications = id_courses_Qualifications;
    }

    public String toString(){
        return "Qualifications {"+
                "id" + this.id +
                "Qualifications_and_Description" + this.Qualifications_and_Description +
                "id_student_Qualifications" + this.id_student_Qualifications +
                "id_courses_Qualifications" + this.id_courses_Qualifications +
                "}";
    }

}
