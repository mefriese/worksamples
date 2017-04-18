/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodatabase.dto;

import java.util.List;

/**
 *
 * @author fishb
 */
public class Power {
    
    private String name;
    private String description;
    private String role;
    private int coolnessRating;
    private int usefulnessRating;
    private List<String> heroesWith;
    
    public Power(String name, String description, String role, int coolness, int usefulness){
        this.name = name;
        this.description = description;
        this.role = role;
        coolnessRating = coolness;
        usefulnessRating = usefulness;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getHeroesWith() {
        return heroesWith;
    }

    public void setHeroesWith(List<String> heroesWith) {
        this.heroesWith = heroesWith;
    }

    public int getCoolnessRating() {
        return coolnessRating;
    }

    public int getUsefulnessRating() {
        return usefulnessRating;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDesc(){
        return description;
    }
    
    public String getRole(){
        return role;
    }
    
}
