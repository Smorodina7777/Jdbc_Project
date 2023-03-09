package org.example;

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
        UserDao userDao = new UserDao();
        userDao.createUsersTable();
        userDao.saveUser("Maxim", "Galkin", 23);
        userDao.saveUser("Anton", "Antonow", 43);
        userDao.saveUser("Ksenia", "Borodina", 34);
        System.out.println(userDao.getAllUsers());
        userDao.deleteUser(2);
        System.out.println(userDao.getAllUsers());
        UserDto userDto = userDao.getUserById(3);
        System.out.println("Попытка найти пользователя " + 3);
        System.out.println(userDto);
        userDao.cleanUserTable();
        System.out.println(userDao.getAllUsers());
        userDao.cleanUserTable();
        userDao.dropUserTable();

    }
}
