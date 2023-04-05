package org.example.dao;

import org.example.antity.User;
import org.example.dto.Animals;

import java.util.List;


public interface UserDao {



     void saveUser(String name, String lastName, int age);

     List<User> getAllUsers();

    User getUserById(long id);
    List<Animals> getAllAnimals();

//    void saveCat(String name);
//    void saveFish(String name);
//    void saveTest();

}
