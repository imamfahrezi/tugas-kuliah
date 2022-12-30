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
            result.getInt("npm"),
            result.getString("jurusan"),
            result.getInt("semester"),
            result.getInt("umur")));
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
      prepareStatement.setInt(2, mahasiswa.getNpm());
      prepareStatement.setString(3, mahasiswa.getJurusan());
      prepareStatement.setInt(4, mahasiswa.getSemester());
      prepareStatement.setInt(5, mahasiswa.getUmur());
      prepareStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteById(Integer id) {

    String sql = "DELETE FROM mahasiswa WHERE id=?";

    try (PreparedStatement prepareStatement = ConnectionUtil.getConnection().prepareStatement(sql)) {
      prepareStatement.setInt(1, id);
      prepareStatement.executeUpdate();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public Mahasiswa findById(Integer id) {
    String sql = "SELECT * FROM mahasiswa WHERE id=?";
    try (PreparedStatement prepareStatement = ConnectionUtil.getConnection().prepareStatement(sql)) {
      prepareStatement.setInt(1, id);
      ResultSet resultSet = prepareStatement.executeQuery();
      if (resultSet.next()) {
        return new Mahasiswa(
            resultSet.getInt("id"),
            resultSet.getString("nama"),
            resultSet.getInt("npm"),
            resultSet.getString("jurusan"),
            resultSet.getInt("semester"),
            resultSet.getInt("umur"));
      } else {
        return null;
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public void update(Mahasiswa mahasiswa) {
    String sql = "UPDATE mahasiswa SET nama=?,npm=?,jurusan=?,semester=?,umur=? WHERE id=?";
    System.out.println(mahasiswa.getId());
    try (PreparedStatement prepareStatement = ConnectionUtil.getConnection().prepareStatement(sql)) {
      prepareStatement.setString(1, mahasiswa.getName());
      prepareStatement.setInt(2, mahasiswa.getNpm());
      prepareStatement.setString(3, mahasiswa.getJurusan());
      prepareStatement.setInt(4, mahasiswa.getSemester());
      prepareStatement.setInt(5, mahasiswa.getUmur());
      prepareStatement.setInt(6, mahasiswa.getId());
      prepareStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
