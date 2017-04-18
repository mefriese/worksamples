/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherodatabase.service;

import com.sg.superherodatabase.dto.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fishb
 */
public interface SHService {
    
    public String addHero(String heroname, String heroreal, String herodesc, String heroalin, String heropwr, String heroorg);
    public String addLocation(String locname, String locaddr, String locdescmonster, String loclat, String loclong, String[] orgspresent);
    public String addOrganization(String orgname, String orghq, String orgmission, String orgclass, String[] orgheroesinput, String[] bases);
    public String addPower(String powername, String role, String description, int coolness, int usefulness, String[] whohaspower);
    public int addSighting(String sightdesc, String sightdate, String sightloc, String[] heroespresent);
    
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
    
    public List<Hero> retrieveHeros();
    public Hero retrieveHero(String selectedhero);
    public List<Location> retrieveLoc();
    public List<Organization> retrieveOrg();
    public Organization retrieveOrg(String selectedorg);
    public List<Power> retrievePower();
    public Power retrievePower(String selectedpower);
    public List<Sighting> retrieveSighting();

    public List<String> getHeroesWith(String powername);

    public List<Civilians> retrievecivs();

    public List<String> orgpower(String selectedorg);





    

    

    
}
