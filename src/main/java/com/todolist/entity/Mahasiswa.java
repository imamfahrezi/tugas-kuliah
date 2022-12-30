package com.todolist.entity;

/**
 * Hello world!
 *
 */
public class Mahasiswa {

  private Integer id;
  private String name;
  private Integer npm;
  private String jurusan;
  private Integer semester;
  private Integer umur;

  public Mahasiswa() {
  }

  public Mahasiswa(String name, Integer npm, String jurusan, Integer semester, Integer umur) {
    this.name = name;
    this.npm = npm;
    this.jurusan = jurusan;
    this.semester = semester;
    this.umur = umur;
  }

  public Mahasiswa(Integer id, String name, Integer npm, String jurusan, Integer semester, Integer umur) {
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

  public Integer getNpm() {
    return npm;
  }

  public void setNpm(Integer npm) {
    this.npm = npm;
  }

  public String getJurusan() {
    return jurusan;
  }

  public void setJurusan(String jurusan) {
    this.jurusan = jurusan;
  }

  public Integer getSemester() {
    return semester;
  }

  public void setSemester(Integer semester) {
    this.semester = semester;
  }

  public Integer getUmur() {
    return umur;
  }

  public void setUmur(Integer umur) {
    this.umur = umur;
  }

  @Override
  public String toString() {
    return "Mahasiswa [id=" + id + ", name=" + name + ", npm=" + npm + ", jurusan=" + jurusan + ", semester=" + semester
        + ", umur=" + umur + "]";
  }

}
