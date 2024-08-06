package org.example.Persistence;

import org.example.Entities.Students;

import java.util.ArrayList;

public interface CRUD {

     public Object create(Object object);
     public Object readById(int id);
     public ArrayList<Students> readAll();
     public Object uptade(Object object, int id);
     public Boolean delete (int id);

}
