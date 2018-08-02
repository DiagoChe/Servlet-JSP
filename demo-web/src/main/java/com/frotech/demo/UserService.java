package com.frotech.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void update(long id, String name) throws Exception {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "687198")) {
            PreparedStatement statement = connection.prepareStatement("update user set name = ? where id = ?");
            statement.setString(1, name);
            statement.setLong(2, id);

            int count = statement.executeUpdate();

            System.out.println("count = " + count);
        }
    }

    public User getUser(long id) throws Exception {
        //jdbc:mysql://@mysql.address@/${db-name}?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "687198")) {
            PreparedStatement statement = connection.prepareStatement("select * from user where id = ?");
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            List<User> users = new ArrayList<>();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                users.add(user);
            }

            rs.close();

            return users.get(0);
        }

    }
}
