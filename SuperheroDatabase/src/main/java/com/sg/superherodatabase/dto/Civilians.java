/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodatabase.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fishb
 */
public class Civilians {
    
    private String name;
    private String description;
    private List<String> orgs;
    
    public Civilians(String name,String description){
        this.name = name;
        this.description = description;
    }
    
    public String getName(){
        return name;
    }
    
    public void editName(String name){
        this.name = name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void editDescription(String newdesc){
        description = newdesc;
    }

    public void setOrgs(List<String> civorgs) {
        this.orgs = civorgs;
    }
    
    public List<String> getOrgs(){
        return this.orgs;
    }
}
