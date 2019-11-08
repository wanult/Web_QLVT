/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuki.dao;

import com.tuki.core.Producer;
import com.tuki.dbconnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Pro
 */
public class ProducerDao {

    private Connection conn;

    public Connection getConnection() {
        return DBConnection.getDbCon().getConn();
    }

    public double calculateRevenueOfProducer(long producerId) throws SQLException {
        long revenueSum = 0;
        String query = "select ba.id as id ,ba.name as name,ifnull(sum(bab.revenue_share*bb.price*bb.sold_number) ,0) as Revenue "
                + " from bs_producer ba left join bs_producer_materials bab on ba.id = bab.producer_id left join bs_materials bb on bab.materials_id = bb.id where ba.id=" + producerId
                + " group by ba.id "
                + " order by Revenue "
                + " Desc";
        Statement stmt = getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        while (resultSet.next()) {
            return resultSet.getDouble("Revenue");

        }
        return revenueSum;

    }

   

    public boolean addNewProducer(Producer producer) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String query = "insert into bs_producer(id,name,dob) values (" + producer.getId() + ",'" + producer.getName() + "','"
                + sdf.format(producer.getDob()) + "')";
        Statement stmt = getConnection().createStatement();
        int n = stmt.executeUpdate(query);
        if (n != 0) {
            return true;
        }
        return false;
    }

    public boolean modifyProducer(Producer producer) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String query = "update bs_producer set name='" + producer.getName() + "',dob='" + sdf.format(producer.getDob())
                + "' where id =" + producer.getId();
        Statement stmt = getConnection().createStatement();
        int n = stmt.executeUpdate(query);
        if (n != 0) {
            return true;
        }
        return false;
    }

    public ArrayList<Producer> findAllProducer() throws SQLException {
        String query = "select * from bs_producer";
        Statement stmt = getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        ArrayList<Producer> authorList = new ArrayList<Producer>();
        while (resultSet.next()) {
            Producer producer = new Producer(resultSet);
            double revenue = calculateRevenueOfProducer(resultSet.getLong("id"));
            producer.setRevenue(revenue);
            authorList.add(producer);
        }
        return authorList;
    }

    public Producer findProducerById(long id) throws SQLException {
        String query = "select * from bs_producer where id='" + id + "'";
        Statement stmt = getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        if (resultSet.next()) {
            Producer producer = new Producer(resultSet);
            return producer;
        } else {
            return null;
        }

    }

    public ArrayList<Producer> findProducerOfMaterials(long materialsId) throws SQLException {
        String query = "select bs_producer.id, bs_producer.NAME, bs_producer.dob from bs_materials, bs_producer, bs_producer_materials"
                + " where "
                + materialsId + "= bs_producer_materials.materials_id and bs_producer.id = bs_producer_materials.producer_id";
        Statement stmt = getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        ArrayList<Producer> producerList = new ArrayList<Producer>();

        if (resultSet.next()) {
            Producer producer = new Producer(resultSet);
            producerList.add(producer);
        }
        return producerList;
    }

    

    public boolean deleteProducerById(long id) throws SQLException {
        String query = "delete from bs_producer where id = ?";
        java.sql.PreparedStatement stmt = getConnection().prepareStatement(query);
        stmt.setLong(1, id);
        int n = stmt.executeUpdate();
        // return (n!=0);
        if (n != 0) {
            System.out.println(n + " rows deleted");
        }
        return false;
    }

    public long generateId() throws SQLException {
        String query = "select max(id) as maxId from bs_producer ";
        Statement stmt = getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        if (resultSet.next()) {
            return resultSet.getLong("maxId") + 1;
        } else {
            return 0;
        }
    }

}
