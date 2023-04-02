package org.example.dao;

import org.example.antity.User;
import java.util.List;


public interface UserDao {



    public void saveUser(String name, String lastName, int age);

    public List<User> getAllUsers();
    User getUserById(long id);

}
