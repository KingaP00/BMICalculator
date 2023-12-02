package com.example.calcit.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

 @Entity
 @Table(name = "ppm")
 public class PPM implements Serializable{

    @Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	@Column(name="ppm_id")
 	private int ppmId;

 	@Column(name="ppm_value")
	private double value;

 	@Column
	private Timestamp timestamp;

    @Column(name="user_id")
 	private int userId;


 	public int getPpmId() {
 		return ppmId;
 	}

 	public void setPpmId(int ppmId) {
 		this.ppmId = ppmId;
 	}

 	public int getUserId() {
 		return userId;
 	}

 	public void setUserId(int userId) {
 		this.userId = userId;
 	}

 	public Timestamp getTimestamp() {
 		return timestamp;
 	}

     public void setTimestamp(Timestamp timestamp) {
 		this.timestamp = timestamp;
 	}

     public double getValue() {
 		return value;
 	}

     public void setValue(double value) {
 		this.value = value;
 	}
 }


