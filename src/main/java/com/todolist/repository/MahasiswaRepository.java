package com.todolist.repository;

import java.util.List;

import com.todolist.entity.Mahasiswa;

public interface MahasiswaRepository {

  public List<Mahasiswa> findAll();

  public void save(Mahasiswa mahasiswa);

  public void deleteById(Integer id);

  public Mahasiswa findById(Integer id);

  public void update(Mahasiswa mahasiswa);

}
