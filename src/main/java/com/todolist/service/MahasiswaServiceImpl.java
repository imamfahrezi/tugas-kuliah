package com.todolist.service;

import java.util.List;

import com.todolist.entity.Mahasiswa;
import com.todolist.repository.MahasiswaRepository;

public class MahasiswaServiceImpl implements MahasiswaService {

  private MahasiswaRepository mahasiswaRepository;

  public MahasiswaServiceImpl(MahasiswaRepository mahasiswaRepository) {
    this.mahasiswaRepository = mahasiswaRepository;
  }

  @Override
  public void updateMahasiswa(Integer id, String nama, Integer npm, String jurusan, Integer semester, Integer umur) {

    Mahasiswa mahasiswa = mahasiswaRepository.findById(id);
    mahasiswa.setName(nama);
    mahasiswa.setNpm(npm);
    mahasiswa.setJurusan(jurusan);
    mahasiswa.setSemester(semester);
    mahasiswa.setUmur(umur);

    mahasiswaRepository.update(mahasiswa);
  }

  @Override
  public List<Mahasiswa> findAllMahasiswa() {
    return mahasiswaRepository.findAll();
  }

  @Override
  public void addMahasiswa(Mahasiswa mahasiswa) {
    mahasiswaRepository.save(mahasiswa);

  }

  @Override
  public void deleteMahasiswa(Integer id) {
    mahasiswaRepository.deleteById(id);

  }

  @Override
  public Mahasiswa findMahasiswaById(Integer id) {
    Mahasiswa mahasiswa = mahasiswaRepository.findById(id);
    return mahasiswa;
  }

}
