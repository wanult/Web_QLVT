/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuki.core;

/**
 *
 * @author Pro
 */
public class ProducerMaterials {
    private Producer producer;
	private Materials materials;
	private double revenueShare;

    public ProducerMaterials(Producer producer, Materials materials, double revenueShare) {
        super();
        this.producer = producer;
        this.materials = materials;
        this.revenueShare = revenueShare;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Materials getMaterials() {
        return materials;
    }

    public void setMaterials(Materials materials) {
        this.materials = materials;
    }

    public double getRevenueShare() {
        return revenueShare;
    }

    public void setRevenueShare(double revenueShare) {
        this.revenueShare = revenueShare;
    }
    
        
        
       
}
