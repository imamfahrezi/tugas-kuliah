package com.todolist.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.todolist.entity.Mahasiswa;
import com.todolist.util.ConnectionUtil;

public class MahasiswaRepositoryImpl implements MahasiswaRepository {

  @Override
  public List<Mahasiswa> findAll() {
    List<Mahasiswa> mList = new ArrayList<>();
    String sql = "SELECT * FROM mahasiswa";
    try (ResultSet result = ConnectionUtil.getConnection().createStatement().executeQuery(sql)) {
      while (result.next()) {
        mList.add(new Mahasiswa(
            result.getInt("id"),
            result.getString("nama"),
            result.getString("npm"),
            result.getString("jurusan"),
            result.getString("semester"),
            result.getString("umur")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return mList;
  }

  @Override
  public void save(Mahasiswa mahasiswa) {
    String sql = "INSERT INTO mahasiswa(nama,npm,jurusan,semester,umur)VALUES(?,?,?,?,?)";
    try (PreparedStatement prepareStatement = ConnectionUtil.getConnection().prepareStatement(sql)) {
      prepareStatement.setString(1, mahasiswa.getName());
      prepareStatement.setString(2, mahasiswa.getNpm());
      prepareStatement.setString(3, mahasiswa.getJurusan());
      prepareStatement.setString(4, mahasiswa.getSemester());
      prepareStatement.setString(5, mahasiswa.getUmur());
      prepareStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteByNpm(String npm) {

    String sql = "DELETE FROM mahasiswa WHERE npm=?";

    try (PreparedStatement prepareStatement = ConnectionUtil.getConnection().prepareStatement(sql)) {
      prepareStatement.setString(1, npm);
      prepareStatement.executeUpdate();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public Mahasiswa findByNpm(String npm) {
    String sql = "SELECT * FROM mahasiswa WHERE npm=?";
    try (PreparedStatement prepareStatement = ConnectionUtil.getConnection().prepareStatement(sql)) {
      prepareStatement.setString(1, npm);
      ResultSet resultSet = prepareStatement.executeQuery();
      if (resultSet.next()) {
        return new Mahasiswa(
            resultSet.getInt("id"),
            resultSet.getString("nama"),
            resultSet.getString("npm"),
            resultSet.getString("jurusan"),
            resultSet.getString("semester"),
            resultSet.getString("umur"));
      } else {
        return null;
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public void update(Mahasiswa mahasiswa) {
    String sql = "UPDATE mahasiswa SET nama=?,jurusan=?,semester=?,umur=? WHERE npm=?";
    System.out.println(mahasiswa.getId());
    try (PreparedStatement prepareStatement = ConnectionUtil.getConnection().prepareStatement(sql)) {
      prepareStatement.setString(1, mahasiswa.getName());
      prepareStatement.setString(2, mahasiswa.getJurusan());
      prepareStatement.setString(3, mahasiswa.getSemester());
      prepareStatement.setString(4, mahasiswa.getUmur());
      prepareStatement.setString(5, mahasiswa.getNpm());
      prepareStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
