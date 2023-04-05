package org.example;

import org.example.dao.UserDao;
import org.example.dao.UserDaoHiber;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
UserDao userDao= context.getBean(UserDao.class);
//        userDao.saveUser("Maxim", "Ivanov", 23);
//        userDao.saveUser("Anton", "Melin", 28);
//        userDao.saveUser("Anna", "Krasnova", 18);
//        userDao.saveUser("Alexei", "Borianov", 31);
//
//        System.out.println(userDao.getAllUsers());
//        System.out.println();
//        System.out.println(userDao.getUserById(3));
        System.out.println(userDao.getAllAnimals());
    }
}
