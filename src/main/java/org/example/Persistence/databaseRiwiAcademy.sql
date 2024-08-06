CREATE DATABASE RiwiAcademyDB;

USE RiwiAcademyDB;

CREATE TABLE Estudiantes(
	id_estudiante int primary key auto_increment,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    correo_electronico varchar(100) not null,
    state boolean default true
);

CREATE TABLE Cursos(
	id_cursos int primary key auto_increment,
	nombre varchar(50) not null,
    id_estudiante_fk int,
    FOREIGN KEY (id_estudiante_fk) REFERENCES Estudiantes(id_estudiante)
);

CREATE TABLE Inscripciones(
	id_inscripciones int primary key auto_increment,
	id_estudiante_fk int,
    id_cursos_fk int,
    FOREIGN KEY (id_estudiante_fk) REFERENCES Estudiantes(id_estudiante),
	FOREIGN KEY (id_cursos_fk) REFERENCES Cursos(id_cursos)
);

CREATE TABLE Calificaciones (
	id_calificaciones int primary key auto_increment,
    calificacion_descripcion varchar(100) not null,
    id_estudiante_fk int,
	id_cursos_fk int,
	FOREIGN KEY (id_estudiante_fk) REFERENCES Estudiantes(id_estudiante),
	FOREIGN KEY (id_cursos_fk) REFERENCES Cursos(id_cursos)
);