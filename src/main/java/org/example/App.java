package org.example;

import org.example.dao.UserDao;
import org.example.dao.UserDaoHiber;

/**
 * Наша первое CRUD приложение с работой Базы данных
 * CRUD
 * Create - создать пользовтаеля
 * Read - считать пользователя
 * Update - обновление
 * Delete - удаление
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserDao userDaoJdbc = new UserDaoHiber();
        userDaoJdbc.createUserTable();
        userDaoJdbc.saveUser("Maxim", "Galkin", 23);
        userDaoJdbc.saveUser("Anton", "Antonow", 43);
        userDaoJdbc.saveUser("Ksenia", "Borodina", 34);
        System.out.println(userDaoJdbc.getAllUsers());
        userDaoJdbc.removeUserById(2);
        System.out.println(userDaoJdbc.getAllUsers());
        userDaoJdbc.cleanUserTable();
        System.out.println(userDaoJdbc.getAllUsers());
        userDaoJdbc.cleanUserTable();
        userDaoJdbc.dropUserTable();

    }
}
