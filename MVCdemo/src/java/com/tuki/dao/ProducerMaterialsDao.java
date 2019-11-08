/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuki.dao;

import com.tuki.core.Materials;
import com.tuki.core.Producer;
import com.tuki.dbconnection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pro
 */
public class ProducerMaterialsDao {
    private Connection conn;
	private static ProducerDao producerDao = new ProducerDao();

	public Connection getConnection() throws SQLException {
		return DBConnection.getDbCon().getConn();
	}

	public void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
        
        public boolean addNewMaterialsProducer(Producer producer, Materials materials,double revenueShareDouble) throws SQLException {

		String query = "insert into bs_producer_materials(id,materials_id,producer_id,revenue_share) values (" + generateId() + ",'" + materials.getId()
				+ "','" + producer.getId() + "',"+revenueShareDouble+")";
		Statement stmt = getConnection().createStatement();
		int n = stmt.executeUpdate(query);
		// return (n!=0);
		if (n != 0)
			return true;
		return false;
	}
        
        public boolean deleteProducerMaterialsByMaterials(long materials_id) throws SQLException {
		String query = "delete from bs_producer_materials where materials_id = ?";
		java.sql.PreparedStatement stmt = getConnection().prepareStatement(query);
		stmt.setLong(1, materials_id);
		int n = stmt.executeUpdate();
		// return (n!=0);
		if (n != 0) {
			System.out.println(n + " rows deleted");
		}
		return false;
	}
        
      
        public long generateId() throws SQLException {
		String query = "select max(id) as maxId from bs_producer_materials ";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		if (resultSet.next()) {
			return resultSet.getLong("maxId") + 1;
		} else {
			return 0;
		}
	}
}
