package com.csharp.bikerental.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EScooter extends Scooter implements Rechargeable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String twoWheelType;

    public EScooter(String twoWheelType) {
        this.twoWheelType  = twoWheelType;
    }

    public EScooter(){}

    //region Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public void ExpectedKilometers() {

    }

    @Override
    public void BatteryLevel() {

    }

    @Override
    public void Watt() {

    }

    @Override
    public void Capacity() {

    }

    @Override
    public String getTwoWheelType() {
        return twoWheelType;
    }

    @Override
    public void setTwoWheelType(String twoWheelType) {
        this.twoWheelType = twoWheelType;
    }

    @Override
    public void select() {
        System.out.println("EScoter");
    }
}
