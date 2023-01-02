package com.todolist;

import com.todolist.repository.MahasiswaRepository;
import com.todolist.repository.MahasiswaRepositoryImpl;
import com.todolist.service.MahasiswaService;
import com.todolist.service.MahasiswaServiceImpl;
import com.todolist.view.TodoListView;

public class App {
  private static MahasiswaRepository mahasiswaRepository = new MahasiswaRepositoryImpl();
  private static MahasiswaService mahasiswaService = new MahasiswaServiceImpl(mahasiswaRepository);
  private static TodoListView todoListView = new TodoListView(mahasiswaService);

  public static void main(String[] args) {
    todoListView.showTodoList();
  }
}
