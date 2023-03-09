package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public void createUsersTable() {
        try (Connection connection = Config.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS users(id int primary key auto_increment, name varchar(40), " +
                    "lastName varchar(40), age int )");
            System.out.println("Нам удалось успешно создать таблицу пользователей");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUserTable() {
        try (Connection connection = Config.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS users");
            System.out.println("Нам удалось успешно удалить таблицу пользователей");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, int age) {
        final String INSERT_NEW_USER = "INSERT INTO users(name, lastname, age)"
                + " VALUES(?,?,?)";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_NEW_USER)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.execute();
            System.out.println("Удалось создать пользователя:" + name + " ," + lastName + " ," + age);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(int id) {
        final String DELETE_USER = "DELETE FROM users WHERE id = ?";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER)) {
            statement.setInt(1, id);
            statement.execute();
            System.out.println("Удалось удалить пользователя:" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> users = new ArrayList<>();
        try (Connection connection = Config.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                UserDto user = new UserDto(id, name, lastName, age);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserDto getUserById(int id) {
        final String GET_USER = "SELECT * FROM users WHERE id = ?";
        UserDto userDto = null;
        try (Connection connection = Config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                 userDto = new UserDto(id, name, lastName, age);
            }
            return userDto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUserTable() {
        final String DELETE_ALL_USERS = "DELETE FROM users";
        try (Connection connection = Config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL_USERS)) {
            int rez = preparedStatement.executeUpdate();
            if (rez != 0) {
                System.out.println("Нам удалось удалить " + rez + " пользователей");
            } else {
                System.out.println("Таблица и так была пуста");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
