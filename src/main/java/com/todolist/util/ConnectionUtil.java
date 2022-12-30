package com.todolist.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ConnectionUtil {
  private static Connection connection;

  static {
    try {
      Driver driver = new com.mysql.cj.jdbc.Driver();
      DriverManager.registerDriver(driver);
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    return connection;
  }

}
