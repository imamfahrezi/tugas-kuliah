package com.todolist;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.todolist.entity.Mahasiswa;
import com.todolist.repository.MahasiswaRepository;
import com.todolist.repository.MahasiswaRepositoryImpl;
import com.todolist.service.MahasiswaService;
import com.todolist.service.MahasiswaServiceImpl;

public class RepositoryTest {

  private MahasiswaRepository mahasiswaRepository;
  private MahasiswaService mahasiswaService;

  @BeforeEach
  void setUp() {
    mahasiswaRepository = new MahasiswaRepositoryImpl();
    mahasiswaService = new MahasiswaServiceImpl(mahasiswaRepository);
  }

  @Test
  void testFindAll() {
    List<Mahasiswa> mhsList = mahasiswaRepository.findAll();

    System.out.println(mhsList);
  }

  @Test
  void testInsert() {
    mahasiswaRepository.save(new Mahasiswa("Yazis", 202143580, "teknik informatika", 4, 22));
  }

  @Test
  void testDeleteById() {
    mahasiswaRepository.deleteById(7);
  }

  @Test
  void testFindById() {
    Mahasiswa mahasiswa = mahasiswaRepository.findById(7);
    System.out.println(mahasiswa);
  }

  @Test
  void testUpdate() {
    mahasiswaService.updateMahasiswa(1, "ardi", 202142212, "teknik indurstri", 8, 18);

  }

}

// insert into mahasiswa(nama, npm, jurusan, semester, umur)
// values("imam", 202143514, "teknik informatik", 3, 21),
// ("syam", 202143515, "teknik informatik", 3, 20),
// ("diah", 202143516, "teknik informatik", 3, 19),
// ("wahyu", 202143517, "teknik informatik", 3, 22),
// ("danny", 202143518, "teknik informatik", 3, 23),
// ("rian", 202143519, "teknik informatik", 3, 21);
