package com.todolist.service;

import java.util.List;

import com.todolist.entity.Mahasiswa;

public interface MahasiswaService {

  public void addMahasiswa(Mahasiswa mahasiswa);

  public void deleteMahasiswa(Integer id);

  public Mahasiswa findMahasiswaById(Integer id);

  public List<Mahasiswa> findAllMahasiswa();

  public void updateMahasiswa(Integer id, String nama, Integer npm, String jurusan, Integer semester, Integer umur);
}
