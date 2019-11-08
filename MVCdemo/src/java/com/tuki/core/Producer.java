/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuki.core;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author Pro
 */
public class Producer {
    private long id;
    private String name;
    private Date dob;
    private long soldNumber;
    private double revenue;
    
    public Producer(ResultSet resultSet) throws SQLException{
            this.setId(resultSet.getLong("id"));
        this.setName(resultSet.getString("name"));
        this.setDob(resultSet.getDate("dob"));
    }
    
    public Producer(long id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

    public Producer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String getDobString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(dob);
	}

	public void setDobString(String dob) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");	
		try {
			this.dob = (Date) sdf.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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
        return "Producer{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", soldNumber=" + soldNumber + ", revenue=" + revenue + '}';
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(revenue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (soldNumber ^ (soldNumber >>> 32));
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
        final Producer other = (Producer) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.soldNumber != other.soldNumber) {
            return false;
        }
        if (Double.doubleToLongBits(this.revenue) != Double.doubleToLongBits(other.revenue)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.dob, other.dob)) {
            return false;
        }
        return true;
    }
    
    
    public static Comparator<Producer> compare = new Comparator<Producer>() {
                @Override
		public int compare(Producer a1, Producer a2) {
			return (int) -(a1.getRevenue() - a2.getRevenue());
		}
	};

    
    
    
}
