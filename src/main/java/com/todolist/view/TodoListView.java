package com.todolist.view;

import com.todolist.entity.Mahasiswa;
import java.util.List;

import com.todolist.service.MahasiswaService;
import com.todolist.util.InputUtil;

public class TodoListView {

  private MahasiswaService mahasiswaService;

  public TodoListView(MahasiswaService mahasiswaService) {
    this.mahasiswaService = mahasiswaService;
  }

  public void showTodoList() {
    while (true) {
      todolist();

      System.out.println("======MENU=====");
      System.out.println("1. Tambah");
      System.out.println("2. Hapus");
      System.out.println("3. update");
      System.out.println("4. lihat detail mahasiswa");
      System.out.println("x. Keluar");

      var input = InputUtil.input("pilih");
      System.out.println();

      if (input.equals("1")) {
        showAddTodo();
      } else if (input.equals("2")) {
        showDeleteTodo();
      } else if (input.equals("3")) {
        showUpdateTodo();
      } else if (input.equals("4")) {
        showDetailMahasiswa();
      } else if (input.equals("x")) {
        System.exit(1);
      } else {
        System.out.println("input not valid");
      }
    }
  }

  public void showAddTodo() {
    System.out.println("======MENAMBAH TODOLIST======");

    var todo = InputUtil.inputMasiswa();
    var input = InputUtil.input("masukan x jika batal y untuk lanjut ");

    if (input.equals("x")) {
      // batal
    } else if (input.equals("y")) {
      mahasiswaService.addMahasiswa(todo);
    }
    System.out.println();

  }

  public void showUpdateTodo() {
    System.out.println("======UPDATE TODOLIST======");

    var inputNpm = InputUtil.input("masukan npm yang ingin di update (x jika batal)");

    if (inputNpm.equals("x")) {
      // batal
    } else {
      var todo = InputUtil.inputMasiswa();
      mahasiswaService.updateMahasiswa(inputNpm, todo);
    }
    System.out.println();
  }

  public void showDeleteTodo() {
    System.out.println("======MENGHAPUS TODOLIST======");

    var input = InputUtil.input("masukan npm yang ingin dihapus (x Jika Batal)");

    if (input.equals("x")) {
      // batal
    } else {
      mahasiswaService.deleteMahasiswa(input);
    }
    System.out.println();
  }

  public void todolist() {
    System.out.println("======LIST MAHASISWA======");
    List<Mahasiswa> listMahasiswa = mahasiswaService.findAllMahasiswa();
    System.out.println("NO" + "\t" + "NAMA" + "\t\t\t" + "NPM");
    // for (Mahasiswa mahasiswa : listMahasiswa) {
    // System.out.println(
    // mahasiswa.getId() + "\t" + mahasiswa.getName() + "\t\t\t" +
    // mahasiswa.getNpm());
    // }
    int idx = 0;
    for (int i = 0; i < listMahasiswa.size(); i++) {
      idx = i + 1;
      System.out.println(idx + "\t" + listMahasiswa.get(i).getName() + "\t\t\t" + listMahasiswa.get(i).getNpm());
    }
    System.out.println();
  }

  void showDetailMahasiswa() {
    System.out.println();
    System.out.println("======DETAIL MAHASISWA======");
    String input = InputUtil.input("masukan npm (x jika batal)");
    if (input.equals("x")) {
      // batal
    } else {
      Mahasiswa mahasiswa = mahasiswaService.findMahasiswaByNpm(input);
      System.out.println(
          "ID" + "\t" + "NAMA" + "\t\t\t" + "NPM" + "\t\t\t" + "JURUSAN" + "\t\t\t" + "SEMESTER" + "\t" + "UMUR");
      System.out.println(
          mahasiswa.getId() + "\t" + mahasiswa.getName() + "\t\t\t" +
              mahasiswa.getNpm() + "\t\t" + mahasiswa.getJurusan() + "\t\t" + mahasiswa.getSemester() + "\t\t"
              + mahasiswa.getUmur());
      System.out.println();
    }
  }

}