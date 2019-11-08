/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuki.core;

import com.tuki.dao.CategoryDao;
import com.tuki.dao.ProducerDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pro
 */
public class Materials {
    private long id;
    private String name;
    private double price;
    private long soldNumber;
    private ArrayList<Producer> producer;
    private Category category;  
    private static ProducerDao producerDAO = new ProducerDao();
    private static CategoryDao categoryDAO = new CategoryDao();
    
    public Materials(){
        
    }
    
    public Materials(long id, String name, Double priceDouble, Category selectedCategory) {
		super();
		this.id = id;
		this.name = name;
		this.price = priceDouble;
		this.category = selectedCategory;
	}
    public Materials(long id, String name, long price, long soldNumber, ArrayList<Producer> producer, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.soldNumber = soldNumber;
		this.producer = producer;
		this.category = category;
	}
    public Materials(long id, String name, double priceDouble, long soldNumberDouble, Category selectedCategory) {
		super();
		this.id = id;
		this.name = name;
		this.price = priceDouble;
		this.soldNumber = soldNumberDouble;
		this.category = selectedCategory;
    }

    public Materials (ResultSet resultSet) throws SQLException{
        this.setId(resultSet.getLong("id"));
        this.setName(resultSet.getString("name"));
        this.setPrice(resultSet.getDouble("price"));
        this.setSoldNumber(resultSet.getLong("sold_number"));
        this.setCategory(categoryDAO.findCategoryOfMaterials(resultSet.getLong("category_id")));
        ArrayList<Producer> producersList = producerDAO.findProducerOfMaterials(resultSet.getLong("id"));
        this.setProducer(producersList);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(long soldNumber) {
        this.soldNumber = soldNumber;
    }

    public ArrayList<Producer> getProducer() {
        return producer;
    }

    public void setProducer(ArrayList<Producer> producer) {
        this.producer = producer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    // 2 doi tuong trung nhau => co hash code= nhau
    // 2 doi tuong co hashcode = => chua chac da trung nhau
    //2 doi tuong co hashcode = => equal nhau
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materials other = (Materials) obj;
		if (id != other.id)
			return false;
		return true;
	}

    @Override
    public String toString() {
        return "Materials{" + "id=" + id + ", name=" + name + ", price=" + price + ", soldNumber=" + soldNumber + ", producer=" + producer + ", category=" + category + '}';
    }
    
    
}
