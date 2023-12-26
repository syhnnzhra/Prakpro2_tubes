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
}
