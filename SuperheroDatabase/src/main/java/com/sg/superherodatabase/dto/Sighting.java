/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodatabase.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author fishb
 */
public class Sighting {
    
    private int index;

    public List<String> getHeroesAt() {
        return heroesAt;
    }

    public void setHeroesAt(List<String> heroesAt) {
        this.heroesAt = heroesAt;
    }
    private Date sightingDate;
    private String description;
    private List<String> heroesAt;
    
    public Sighting(int id, Date when, String description){
        this.sightingDate = when;
        this.description = description;
        this.index = id;
    }
    
    public Date getDate(){
        return sightingDate;
    }
    
    public void editDate(Date when){
        sightingDate = when;
    }
    
    public int getIndex(){
        return index;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void editDescription(String newdesc){
        description = newdesc;
    }
    
}
