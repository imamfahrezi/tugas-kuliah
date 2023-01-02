package com.todolist.service;

import java.util.List;

import com.todolist.entity.Mahasiswa;
import com.todolist.exception.BadRequestException;
import com.todolist.repository.MahasiswaRepository;

public class MahasiswaServiceImpl implements MahasiswaService {

  private MahasiswaRepository mahasiswaRepository;

  public MahasiswaServiceImpl(MahasiswaRepository mahasiswaRepository) {
    this.mahasiswaRepository = mahasiswaRepository;
  }

  @Override
  public void updateMahasiswa(String npm, Mahasiswa mahasiswa) {

    Mahasiswa mhs = mahasiswaRepository.findByNpm(npm);
    if (mhs == null) {
      throw new BadRequestException("npm.invalid");
    } else {
      mhs.setName(mahasiswa.getName());
      mhs.setJurusan(mahasiswa.getJurusan());
      mhs.setSemester(mahasiswa.getSemester());
      mhs.setUmur(mahasiswa.getUmur());
    }

    mahasiswaRepository.update(mhs);
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
  public void deleteMahasiswa(String npm) {
    mahasiswaRepository.deleteByNpm(npm);

  }

  @Override
  public Mahasiswa findMahasiswaByNpm(String npm) {
    Mahasiswa mahasiswa = mahasiswaRepository.findByNpm(npm);
    return mahasiswa;
  }

}
