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
@Table(name = "pral")
public class PRAL implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 	@Column(name="pral_id")
 	private int pralId;


    @Column(name = "pral_value")
    private double value;

    @Column
	private Timestamp timestamp;

    @Column(name="user_id")
 	private int userId;

    public int getPralId() {
        return pralId;
    }

    public void setPralId(int pralId) {
        this.pralId = pralId;
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
