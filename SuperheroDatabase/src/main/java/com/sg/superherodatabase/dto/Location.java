/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodatabase.dto;

/**
 *
 * @author fishb
 */
public class Location {
    
    private String name;
    private String address;
    private String description;
    private double longitude;
    private double latitude;
    
    public Location(String name, String address, String desc, double longitude, double latitude){
        this.name = name;
        this.address = address;
        this.description = desc;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    
    public String getName(){
        return name;
    }
    
    public void editName(String newname){
        name = newname;
    }
    
    public String getDesc(){
        return description;
    }
    
    public void editDesc(String newdesc){
        description = newdesc;
    }
    
    public double getLongitude(){
        return longitude;
    }
    
    public void editLongitude(double newLong){
        longitude = newLong;
    }
    
    public double getLatitude(){
        return latitude;
    }
    
    public void editLatitude(double newLat){
        latitude = newLat;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void editAddress(String newAdd){
        address = newAdd;
    }
}
