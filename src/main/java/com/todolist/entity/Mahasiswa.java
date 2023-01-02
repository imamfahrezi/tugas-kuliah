package com.todolist.entity;

/**
 * Hello world!
 *
 */
public class Mahasiswa {

  private Integer id;
  private String name;
  private String npm;
  private String jurusan;
  private String semester;
  private String umur;

  public Mahasiswa() {
  }

  public Mahasiswa(String name, String npm, String jurusan, String semester, String umur) {
    this.name = name;
    this.npm = npm;
    this.jurusan = jurusan;
    this.semester = semester;
    this.umur = umur;
  }

  public Mahasiswa(String name, String jurusan, String semester, String umur) {
    this.name = name;
    this.jurusan = jurusan;
    this.semester = semester;
    this.umur = umur;
  }

  public Mahasiswa(Integer id, String name, String npm, String jurusan, String semester, String umur) {
    this.id = id;
    this.name = name;
    this.npm = npm;
    this.jurusan = jurusan;
    this.semester = semester;
    this.umur = umur;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNpm() {
    return npm;
  }

  public void setNpm(String npm) {
    this.npm = npm;
  }

  public String getJurusan() {
    return jurusan;
  }

  public void setJurusan(String jurusan) {
    this.jurusan = jurusan;
  }

  public String getSemester() {
    return semester;
  }

  public void setSemester(String semester) {
    this.semester = semester;
  }

  public String getUmur() {
    return umur;
  }

  public void setUmur(String umur) {
    this.umur = umur;
  }

  @Override
  public String toString() {
    return "Mahasiswa [id=" + id + ", name=" + name + ", npm=" + npm + ", jurusan=" + jurusan + ", semester=" + semester
        + ", umur=" + umur + "]";
  }

}
