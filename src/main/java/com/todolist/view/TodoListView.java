package com.todolist.view;

import com.todolist.entity.Mahasiswa;
import java.util.List;

import com.todolist.repository.MahasiswaRepositoryImpl;
import com.todolist.service.MahasiswaService;
import com.todolist.service.MahasiswaServiceImpl;
import com.todolist.util.InputUtil;

public class TodoListView {

  private static MahasiswaService mahasiswaService = new MahasiswaServiceImpl(new MahasiswaRepositoryImpl());

  public static void showTodoList() {
    while (true) {
      TodoListView.todolist();

      System.out.println("MENU");
      System.out.println("1. Tambah");
      System.out.println("2. Hapus");
      System.out.println("3. update");
      System.out.println("x. Keluar");

      var input = InputUtil.input("pilih");
      if (input.equals("1")) {
        showAddTodo();
      } else if (input.equals("2")) {
        showDeleteTodo();
      } else if (input.equals("3")) {
        showUpdateTodo();
      } else if (input.equals("x")) {
        System.exit(1);
      } else {
        System.out.println("input not valid");
      }

    }
  }

  public static void showAddTodo() {
    System.out.println();
    System.out.println("MENAMBAH TODOLIST");
    System.out.println();
    System.out.println("1. NPM, SEMESTER dan UMUR harus angka");
    System.out.println("contoh:");
    System.out.println("NPM: 202143521" + " NPM MAX 9 ANGKA");
    System.out.println("SEMESTER: 2");
    System.out.println("UMUR: 202143521");

    var todo = InputUtil.inputMasiswa();

    if (todo.equals("x")) {
      // batal
    } else {
      mahasiswaService.addMahasiswa(todo);
    }
  }

  public static void showUpdateTodo() {
    System.out.println("UPDATE TODOLIST");

    var todo = InputUtil.inputMasiswa();

    if (todo.equals("x")) {
      // batal
    } else {
      mahasiswaService.updateMahasiswa(todo.getId(), todo.getName(), todo.getNpm(), todo.getJurusan(),
          todo.getSemester(), todo.getUmur());
    }
  }

  public static void showDeleteTodo() {
    System.out.println("MENGHAPUS TODOLIST");

    var number = InputUtil.input("Nomor yang Dihapus (x Jika Batal)");

    if (number.equals("x")) {
      // batal
    } else {
      mahasiswaService.deleteMahasiswa(Integer.valueOf(number));
    }
  }

  public static void todolist() {
    List<Mahasiswa> listMahasiswa = mahasiswaService.findAllMahasiswa();
    System.out.println("ID" + "\t" + "NAMA" + "\t\t\t" + "NPM");
    for (Mahasiswa mahasiswa : listMahasiswa) {
      System.out.print(
          mahasiswa.getId() + "\t" + mahasiswa.getName() + "\t\t\t" + mahasiswa.getNpm());
      System.out.println();
    }
  }

}
