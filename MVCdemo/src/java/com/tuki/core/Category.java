/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuki.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author Pro
 */
public class Category {
    private long id;
    private String name;
    private long soldNumber;
    private double revenue;

    public Category(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    
    public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(ResultSet resultSet) throws SQLException{
		this.setId(resultSet.getLong("id"));
		this.setName(resultSet.getString("name"));
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

    public long getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(long soldNumber) {
        this.soldNumber = soldNumber;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result +id);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
       
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    public static Comparator<Category> compare = new Comparator<Category>() {
                @Override
		public int compare(Category c1, Category c2) {
			return (int) -(c1.getRevenue() - c2.getRevenue());
		}
	};

    
    
    
    
    
    
}
