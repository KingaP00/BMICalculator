package com.example.calcit.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ymca")
public class YMCA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ymca_id")
    private int ymcaId;

    @Column(name = "ymca_value")
    private double value;

    @Column
    private Timestamp timestamp;

    @Column(name = "user_id")
    private int userId;

    public int getYmcaId() {
        return ymcaId;
    }

    public void setYmcaId(int ymcaId) {
        this.ymcaId = ymcaId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}