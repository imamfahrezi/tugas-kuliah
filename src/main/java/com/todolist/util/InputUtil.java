package com.todolist.util;

import java.util.Scanner;

import com.todolist.entity.Mahasiswa;

public class InputUtil {
  private static Scanner scanner = new Scanner(System.in);

  public static String input(String info) {
    System.out.print(info + " : ");
    String data = scanner.nextLine();
    return data;
  }

  public static Mahasiswa inputMasiswa() {
    System.out.println("masukan data mahasiswa tidak boleh kosong");

    System.out.print("nama\t : ");
    String nama = scanner.nextLine();

    System.out.print("npm\t : ");
    String npm = scanner.nextLine();

    System.out.print("jurusan\t : ");
    String jurusan = scanner.nextLine();

    System.out.print("semester : ");
    String semester = scanner.nextLine();

    System.out.print("umur\t : ");
    String umur = scanner.nextLine();

    return new Mahasiswa(nama, Integer.valueOf(npm), jurusan, Integer.valueOf(semester), Integer.valueOf(umur));
  }

  public static void main(String[] args) {
    InputUtil.inputMasiswa();

  }
}
