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
public class Hero {
    
    public Hero (String name, String realname, String description, String moralAlignment){
        this.name = name;
        this.realname = realname;
        this.description = description;
        this.moralAlignment = moralAlignment;
        /*
        this.powers = new ArrayList<>();
        this.powers.add("UNK KNONE");
        this.orgs = new ArrayList<>();
        this.orgs.add("Unk Knone");
        this.sightings = new ArrayList<>();
        this.sightings.add("Unk Knone");
    */
    }
    
    public void setPowers(List<String> powers){
        this.powers = powers;
    }
    
    public void setSight(List<String> sightings){
        this.sightings = sightings;
    }
        
    public void setOrgs(List<String> orgs){
        this.orgs = orgs;
    }
    
    public void editName(String newname){
        this.name = newname;
    }
    
    public String getName(){
        return name;
    }
    
    public void editRealName(String newname){
        this.realname = newname;
    }
    
    public String getRealName(){
        return realname;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void editDescription(String newdesc){
        description = newdesc;
    }
    
    public String getMorality(){
        return moralAlignment;
    }
    
    public void editMorality(String newmorals){
        moralAlignment = newmorals;
    }

    public String getRealname() {
        return realname;
    }

    public String getMoralAlignment() {
        return moralAlignment;
    }

    public List<String> getPowers() {
        return powers;
    }

    public List<String> getOrgs() {
        return orgs;
    }

    public List<String> getSightings() {
        return sightings;
    }
    
    private String name;
    private String realname;
    private String description;
    private String moralAlignment;
    private List<String> powers;
    private List<String> orgs;
    private List<String> sightings;
    
}
