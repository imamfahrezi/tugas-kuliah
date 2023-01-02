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
    // mahasiswaRepository.save(new Mahasiswa("Yazis", "202143580", "teknik
    // informatika", "4", "i"));
    mahasiswaRepository.save(new Mahasiswa("diah", "20214358012", "teknik informatika", "4", "22"));
    mahasiswaRepository.save(new Mahasiswa("imam", "20214358043", "teknik informatika", "2", "18"));
    mahasiswaRepository.save(new Mahasiswa("wahyu", "2021435212", "teknik informatika", "1", "19"));
    mahasiswaRepository.save(new Mahasiswa("tamam", "2021435806", "teknik informatika", "5", "21"));
    mahasiswaRepository.save(new Mahasiswa("ardi", "20214358015", "teknik informatika", "5", "20"));
  }

  @Test
  void testDeleteById() {
    mahasiswaRepository.deleteByNpm("202143580");
    mahasiswaRepository.deleteByNpm("2021435212");
    mahasiswaRepository.deleteByNpm("2021435806");
    mahasiswaRepository.deleteByNpm("20214358015");
  }

  @Test
  void testFindById() {
    Mahasiswa mahasiswa = mahasiswaRepository.findByNpm("7");
    System.out.println(mahasiswa);
  }

  @Test
  void testUpdate() {
    mahasiswaService.updateMahasiswa("20214358015", new Mahasiswa("imam", "teknik indurstri", "8", " 18"));

  }

}

// insert into mahasiswa(nama, npm, jurusan, semester, umur)
// values("imam", 202143514, "teknik informatik", 3, 21),
// ("syam", 202143515, "teknik informatik", 3, 20),
// ("diah", 202143516, "teknik informatik", 3, 19),
// ("wahyu", 202143517, "teknik informatik", 3, 22),
// ("danny", 202143518, "teknik informatik", 3, 23),
// ("rian", 202143519, "teknik informatik", 3, 21);
