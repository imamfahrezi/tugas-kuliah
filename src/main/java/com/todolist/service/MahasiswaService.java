package com.todolist.service;

import java.util.List;

import com.todolist.entity.Mahasiswa;

public interface MahasiswaService {

  public void addMahasiswa(Mahasiswa mahasiswa);

  public void deleteMahasiswa(String npm);

  public Mahasiswa findMahasiswaByNpm(String npm);

  public List<Mahasiswa> findAllMahasiswa();

  public void updateMahasiswa(String npm, Mahasiswa mahasiswa);
}
