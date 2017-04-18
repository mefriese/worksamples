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
public class Organization {
    
    public Organization(String name, String desc, String mission, String hq){
        this.name = name;
        this.description = desc;
        this.missionStatement = mission;
        this.headquarters = hq;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void editHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public String getDescription() {
        return description;
    }

    public void editDescription(String description) {
        this.description = description;
    }

    public String getMissionStatement() {
        return missionStatement;
    }

    public void editMissionStatement(String missionStatement) {
        this.missionStatement = missionStatement;
    }
    
    private String name;
    private String description;
    private String missionStatement;
    private String headquarters;
    
    private List<String> heroesIn;
    private List<String> civsIn;
    private List<String> bases;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHeroesIn() {
        return heroesIn;
    }

    public void setHeroesIn(List<String> heroesIn) {
        this.heroesIn = heroesIn;
    }

    public List<String> getCivsIn() {
        return civsIn;
    }

    public void setCivsIn(List<String> civsIn) {
        this.civsIn = civsIn;
    }

    public List<String> getBases() {
        return bases;
    }

    public void setBases(List<String> bases) {
        this.bases = bases;
    }
    
}
