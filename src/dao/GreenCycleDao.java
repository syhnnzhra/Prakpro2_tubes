/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import GreenCycle.Sampah;

/**
 *
 * @author syhnn
 */
public class GreenCycleDao {
    public List<Sampah> findAll() {
        List<Sampah> list = new ArrayList<>();

        try (
                Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();) {

            try (ResultSet resultSet = statement.executeQuery("select * from sampah")) {
                while (resultSet.next()) {
                    Sampah sampah = new Sampah();

                    sampah.setId(resultSet.getString("id_sampah")); 
                    sampah.setNama(resultSet.getString("nama_sampah")); 
                    sampah.setJenis(resultSet.getString("jenis_sampah")); 
                    sampah.setTotal(resultSet.getInt("total_sampah")); 
                    
                    list.add(sampah);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Sampah select(String column, String value) {
        Sampah sampah = new Sampah();

        try (
                Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();
            ) {
            try (ResultSet resultSet = statement.executeQuery("select * from sampah where " + column+ " = '" + value + "'");) {
                while (resultSet.next()) {
                    sampah.setId(resultSet.getString("id_sampah")); 
                    sampah.setNama(resultSet.getString("nama_sampah")); 
                    sampah.setJenis(resultSet.getString("jenis_sampah")); 
                    sampah.setTotal(resultSet.getInt("total_sampah")); 
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sampah;
    }
    
    
    public int insert(Sampah sampah) {
        // Variable result untuk menyimpan nilai dari eksekusi query apakah berhasil atau tidak
        int result = -1;

        // Try with resources untuk membuat koneksi ke database
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // Membuat PreparedStatement untuk memasukkan data ke database
            PreparedStatement statement = connection.prepareStatement(
                    "Insert into sampah(id_sampah, nama_sampah, jenis_sampah, total_sampah) values (?, ?, ?, ?, ?)");

            // Set nilai dari parameter yang ada di query
            statement.setString(1, sampah.getid_sampah()); // id
            statement.setString(2, sampah.getnama_sampah()); // nama
            statement.setString(3, sampah.getjenis_sampah()); // no_telepon
            statement.setString(4, sampah.gettotal_sampah()); // jenis_kelamin
            
            // Eksekusi query
            result = statement.executeUpdate();

            // Print data yang dimasukkan ke database
            System.out.println("Insert data: " + sampah.getid_sampah() + " " + sampah.getnama_sampah() + " "
                    + sampah.getjenis_sampah() + " " + sampah.gettotal_sampah());
        } catch (SQLException e) {
            // Print error jika terjadi error
            e.printStackTrace();
        }

        // Kembalikan nilai result
        return result;
    }

    
}
