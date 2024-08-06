package org.example.Entities;

public class Registration {

    private int id;
    private String nombre_curso;
    private int id_student_Registration;
    private int cursos_estudiante;

    //Generate constructors and getter and setter

    public Registration(){}

    public Registration(String nombre_curso, int id_student_Registration, int cursos_estudiante){
        this.nombre_curso = nombre_curso;
        this.id_student_Registration = id_student_Registration;
        this.cursos_estudiante = cursos_estudiante;
    }

    public Registration(int id, String nombre_curso, int id_student_Registration, int cursos_estudiante){
        this.id = id;
        this.nombre_curso = nombre_curso;
        this.id_student_Registration = id_student_Registration;
        this.cursos_estudiante = cursos_estudiante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_student_Registration() {
        return String.valueOf(id_student_Registration);
    }

    public void setId_student_Registration(int id_student_Registration) {
        this.id_student_Registration = id_student_Registration;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getCursos_estudiante() {
        return String.valueOf(cursos_estudiante);
    }

    public void setCursos_estudiante(int cursos_estudiante) {
        this.cursos_estudiante = cursos_estudiante;
    }

    public String toString(){
        return "Registration {"+
                "id" + this.id +
                "id_student_Registration" + this.id_student_Registration +
                "id_courses_Registration" + this.cursos_estudiante +
                "}";
    }

}
