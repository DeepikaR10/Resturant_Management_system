package com.rest.models;

public class Table {
     
    public enum Availability{
        FREE,
        OCCUPY
    }
    private int id;
    private int capacity;
    private Availability status;

    public Table(int id,int capacity){
        this.id=id;
        this.capacity=capacity;
        this.status=Availability.FREE;
    }
    public int getId(){
        return id;
    }
    public int getCapacity(){
        return capacity;
    }
    public Availability getStatus(){
        return status;
    }
    public void freeTable(){
        this.status=Availability.FREE;
    }
    public void occupyTable(){
        this.status=Availability.OCCUPY;
    }
    @Override
    public String toString(){
        return "Table ID: "+ id +", Capacity: "+ capacity+", Status: "+status;
    }
}
