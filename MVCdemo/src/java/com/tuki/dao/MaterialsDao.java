/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuki.dao;

import com.tuki.core.Materials;
import com.tuki.dbconnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pro
 */
public class MaterialsDao {
    private Connection conn;
    public Connection getConnection() throws SQLException {
		return DBConnection.getDbCon().getConn();
	}
	public MaterialsDao(){
		
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
        
        public boolean deleteMaterialsById(long id) throws SQLException{
            String query = "delete from bs_materials where id =?";
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setLong(1, id);
            int n= stmt.executeUpdate();
            if(n!=0){
                System.out.println(n+"rows deleted");
                
            }
            return false;
        }
        
        public boolean modifyMaterials(Materials materials) throws SQLException{
            String query = "update bs_materials set name='" + materials.getName() +"', price='" + materials.getPrice()
                    +"', category_id='" + materials.getCategory().getId() + "' where id="+ materials.getId();
            Statement stmt = getConnection().createStatement();
            int n= stmt.executeUpdate(query);
            if(n!=0){
                return true;
            }
            return false;
        }
        
        public Materials findMaterialsById(long id) throws SQLException{
            String query = "select * from bs_materials where id='"+id+"'";
            Statement stmt = getConnection().createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            if(resultSet.next()){
                Materials materials = new Materials(resultSet);
                return materials;
            }
            else return null;
        }
        
        public ArrayList<Materials> findMaterials() throws SQLException {
		String query = "SELECT * FROM bs_materials";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		ArrayList<Materials> materialList = new ArrayList<Materials>();

		while (resultSet.next()) {
			Materials materials = new Materials(resultSet);
			materialList.add(materials);
		}
		return materialList;
	}
        
        public boolean addNewMaterials(Materials materials) throws SQLException{
            String query = "insert into bs_materials(id,name,price,category_id,sold_number) values (" + materials.getId() + ",'" + materials.getName()
				+ "'," + materials.getPrice() + "," + materials.getCategory().getId()+ "," + materials.getSoldNumber() + ")";
		Statement stmt = getConnection().createStatement();
		int n = stmt.executeUpdate(query);
		if (n != 0)
			return true;
		return false;
        }
        
        
        
        
        
        public long generateId() throws SQLException {
		String query = "select max(id) as maxId from bs_materials";
		Statement stmt = getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery(query);
		if (resultSet.next()) {
			return resultSet.getLong("maxId") + 1;
		} else {
			return 0;

		}
	}
}
