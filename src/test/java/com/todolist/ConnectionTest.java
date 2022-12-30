package com.todolist;

import org.junit.jupiter.api.Test;

import com.todolist.util.ConnectionUtil;

public class ConnectionTest {

  @Test
  void testConnection() {
    ConnectionUtil.getConnection();
  }
}
