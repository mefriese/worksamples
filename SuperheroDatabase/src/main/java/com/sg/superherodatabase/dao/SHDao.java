/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodatabase.dao;

import com.sg.superherodatabase.dto.Civilians;
import com.sg.superherodatabase.dto.Hero;
import com.sg.superherodatabase.dto.Location;
import com.sg.superherodatabase.dto.Organization;
import com.sg.superherodatabase.dto.Power;
import com.sg.superherodatabase.dto.Sighting;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fishb
 */
public interface SHDao {
    
    //Requests to add an item to the database
    
    //The requests for full information of a DTO
    public List<Hero> retrieveHeros();
    public List<Location> retrieveLoc();
    public List<Organization> retrieveOrg();
    public List<Power> retrievePower();
    public List<Sighting> retrieveSighting();

    //Requests for names only of items
    public List<String> getHeroes();
    public List<String> getLocations();
    public List<String> getPowers();
    public List<String> getSightings();
    public List<String> getOrgs();
    public List<String> getHeroes(int x);
    public List<String> getLocations(int x);
    public List<String> getPowers(int x);
    public List<String> getSightings(int x);
    public List<String> getOrgs(int x);
    
    //Requests for items associated with a specific hero
    public List<String> getPowersOfH(String heroname);
    public List<String> getSightingsOfH(String heroname);
    public List<String> getOrgsOfH(String heroname);
    
    //Requests for items associated with a specific power
    public List<String> getHeroesWith(String powername);

    public void addHero(String heroname, String heroreal, String herodesc, String heroalin);
    public void addPowerHero(String heroname, String heropwr);
    public void addOrgHero(String heroname, String heroorg);
    public void addLocation(String locname, String locaddr, String locdescmonster, String loclat, String loclong);
    
    public void addPower(String powername, String role, String description, int coolness, int usefulness);

    public void addOrganization(String orgname, String orghq, String orgmission, String orgclass);

    public void addOrgBase(String i, String orgname);

    public int addSighting(String sightdesc, String sightdate, String sightloc);

    public List<Hero> retrieveHero(String selectedhero);

    public List<Power> retrievePower(String selectedpower);

    public List<Civilians> retrievecivs();

    public List<Organization> retrieveOrg(String selectedorg);

    public List<String> orgpower(String selectedorg);


    
}
