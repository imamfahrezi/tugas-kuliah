package com.todolist.repository;

import java.util.List;

import com.todolist.entity.Mahasiswa;

public interface MahasiswaRepository {

  public List<Mahasiswa> findAll();

  public void save(Mahasiswa mahasiswa);

  public void deleteByNpm(String npm);

  public Mahasiswa findByNpm(String npm);

  public void update(Mahasiswa mahasiswa);

}
