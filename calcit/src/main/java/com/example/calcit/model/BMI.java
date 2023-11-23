package com.example.calcit.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

 @Entity
 @Table(name = "bmi")
 public class BMI implements Serializable{

    @Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
 	@Column(name="bmi_id")
 	private int bmiId;

 	@Column(name="bmi_value")
	private double value;

 	@Column
	private String timestamp;

    @Column(name="user_id")
 	private int userId;


 	public int getBmiId() {
 		return bmiId;
 	}

 	public void setBmiId(int bmiId) {
 		this.bmiId = bmiId;
 	}

 	public int getUserId() {
 		return userId;
 	}

 	public void setUserId(int userId) {
 		this.userId = userId;
 	}

 	public String getTimestamp() {
 		return timestamp;
 	}

     public void setTimestamp(String timestamp) {
 		this.timestamp = timestamp;
 	}

     public double getValue() {
 		return value;
 	}

     public void setValue(double value) {
 		this.value = value;
 	}
 }


