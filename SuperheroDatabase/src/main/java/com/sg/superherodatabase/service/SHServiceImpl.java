/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodatabase.service;

import com.sg.superherodatabase.dao.SHDao;
import com.sg.superherodatabase.dto.Civilians;
import com.sg.superherodatabase.dto.Hero;
import com.sg.superherodatabase.dto.Location;
import com.sg.superherodatabase.dto.Organization;
import com.sg.superherodatabase.dto.Power;
import com.sg.superherodatabase.dto.Sighting;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fishb
 */
public class SHServiceImpl implements SHService {

    private final SHDao dao;

    public SHServiceImpl(SHDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Hero> retrieveHeros() {
        return dao.retrieveHeros();
    }

    @Override
    public List<Location> retrieveLoc() {
        return dao.retrieveLoc();
    }

    @Override
    public List<Organization> retrieveOrg() {
        List<Organization> orglist = dao.retrieveOrg();
        return orglist;
    }

    @Override
    public List<Power> retrievePower() {
        return dao.retrievePower();
    }

    @Override
    public List<Sighting> retrieveSighting() {
        return dao.retrieveSighting();
    }

    @Override
    public List<String> getHeroes() {
        return dao.getHeroes();
    }

    @Override
    public List<String> getLocations() {
        return dao.getLocations();
    }

    @Override
    public List<String> getPowers() {
        return dao.getPowers();
    }

    @Override
    public List<String> getHeroes(int x) {
        return dao.getHeroes(x);
    }

    @Override
    public List<String> getLocations(int x) {
        return dao.getLocations(x);
    }

    @Override
    public List<String> getPowers(int x) {
        return dao.getPowers(x);
    }

    @Override
    public List<String> getSightings() {
        return dao.getSightings();
    }

    @Override
    public List<String> getOrgs() {
        return dao.getOrgs();
    }

    @Override
    public List<String> getSightings(int x) {
        return dao.getSightings(x);
    }

    @Override
    public List<String> getOrgs(int x) {
        return dao.getOrgs(x);
    }

    @Override
    public List<String> getHeroesWith(String powername) {
        return dao.getHeroesWith(powername);
    }

    @Override
    public String addHero(String heroname, String heroreal, String herodesc, String heroalin, String heropwr, String heroorg) {
        boolean exists = dao.getHeroes().contains(heroname);
        if (exists) {
            return "Data not added - hero entry with that name already exists in database!";
        } else {
            dao.addHero(heroname, heroreal, herodesc, heroalin);
            if (!heropwr.equals("Unknown")) {
                dao.addPowerHero(heroname, heropwr);
            }
            if (!heroorg.equals("Unknown")) {
                dao.addOrgHero(heroname, heroorg);
            }
            return "Hero data added successfully.";
        }
    }

    @Override
    public String addPower(String powername, String role, String description, int coolness, int usefulness, String[] whohaspower) {
        List<String> existingpowers = dao.getPowers();
        if(existingpowers.contains(powername)){
            return "Power not added - an entry of that name already exists!";
        }
        else{
            System.out.println("Attempting to add power (Service Layer)");
            dao.addPower(powername, role, description, coolness, usefulness);
            for(String i: whohaspower){
                dao.addPowerHero(i, powername);
            }
            return "Power added successfully.";
        }
    }

    @Override
    public String addOrganization(String orgname, String orghq, String orgmission, String orgclass, String[] orgheroesinput, String[] bases) {
        List<String> existingorgs = dao.getOrgs();
        if(existingorgs.contains(orgname)){
            return "Organization not added - an entry of that name already exists!";
        }
        else{
            dao.addOrganization(orgname, orghq, orgmission, orgclass);
            for(String i: orgheroesinput){
                dao.addOrgHero(i, orgname);
            }
            for(String i: bases){
                dao.addOrgBase(i, orgname);
            }
            return "Organization added successfully.";
        }
    }

    @Override
    public String addLocation(String locname, String locaddr, String locdescmonster, String loclat, String loclong, String[] orgspresent) {
        List<String> existinglocs = dao.getLocations();
        if(existinglocs.contains(locname)){
            return "Location not added - an entry of that name already exists!";
        }
        else{
            dao.addLocation(locname, locaddr, locdescmonster, loclat, loclong);
            for(String i: orgspresent){
                dao.addOrgBase(locname, i);
            }
            return "Location added successfully.";
        }
    }

    @Override
    public int addSighting(String sightdesc, String sightdate, String sightloc, String[] heroespresent) {
        int sightnumber = dao.addSighting(sightdesc, sightdate, sightloc);
        return sightnumber;
    }

    @Override
    public Hero retrieveHero(String selectedhero) {
        List<Hero> retrieve = dao.retrieveHero(selectedhero);
        if(retrieve.isEmpty()){
            return new Hero(selectedhero,"The Elusive One", "How the f*** did you get to this page?", "Completely Bonkers");
        }
        else{
            return retrieve.get(0);
        }
        
    }

    @Override
    public Power retrievePower(String selectedpower) {
        List<Power> retrieve = dao.retrievePower(selectedpower);
        if(retrieve.isEmpty()){
            return new Power(selectedpower, "Nonexistent Power - Ask Batman for it.", "None", -2, -2);
        }
        else{
            return retrieve.get(0);
        }
    }

    @Override
    public List<Civilians> retrievecivs() {
        return dao.retrievecivs();
    }

    @Override
    public Organization retrieveOrg(String selectedorg) {
        List<Organization> retrieve = dao.retrieveOrg(selectedorg);
        if(retrieve.isEmpty()){
            return new Organization(selectedorg, "This organization does not exist in the database - please try again.", "Its only goal is to wreck your database.","None"); //String name, String desc, String mission, String hq
        }
        else{
            return retrieve.get(0);
        }
    }

    @Override
    public List<String> orgpower(String selectedorg) {
        return dao.orgpower(selectedorg);
    }
}
