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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fishb
 */
public class SHDaoSQLImpl implements SHDao {

    private static final String SQL_INSERT_HERO
            = "INSERT INTO Hero (HeroName, NameReal, Description, MoralAlignment) "
            + "VALUES (?, ?, ?, ?)";
    private static final String SQL_INSERT_HEROPWR
            = "INSERT INTO HeroPower (HeroName, PowerName) "
            + "VALUES (?, ?);";
    private static final String SQL_INSERT_HEROORG
            = "INSERT INTO HeroOrganization (HeroName, OrgName) "
            + "VALUES (?, ?);";
    
    private static final String SQL_INSERT_POWER
            = "INSERT INTO Power (powername, PowerRoleType, description, CoolnessRating, UtilityViability)"
            + "VALUES (?, ?, ?, ?, ?)";
    
     private static final String SQL_INSERT_ORG
            = "INSERT INTO Organization (orgname, headquarters, missionstatement, classification) "
            + "VALUES (?, ?, ?, ?)";
    private static final String SQL_INSERT_LOC_ORG
            = "INSERT INTO bases (locationname, orgname, basetype)"
            + "VALUES (?, ?, 'Base')";
    
    private static final String SQL_INSERT_LOC
            = "INSERT INTO location (locationname, address, description, latitude, longitude) "
            + "VALUES (?, ?, ?, ?, ?)";
    
    private static final String SQL_INSERT_SIGHTING
            = "INSERT INTO sighting (description, dateof, locationname) "
            + "VALUES (?, ?, ?)";
    
    private static final String SQL_DELETE_HERO
            = "DELETE FROM Hero WHERE HeroName = ?";
    private static final String SQL_SELECT_HERO
            = "SELECT * FROM Hero WHERE HeroName = ?";
    private static final String SQL_UPDATE_HERO
            = "UPDATE Hero SET "
            + "HeroName = ?, NameReal = ?, Description = ?, MoralAlignment = ?"
            + "WHERE HeroName = ?";
    
    private static final String SQL_SELECT_POWER
            = "SELECT * FROM Power "
            + "WHERE powername = ?";
    
    private static final String SQL_SELECT_ORG
            = "SELECT * FROM organization "
            + "WHERE orgname = ?";
    
    private static final String SQL_SELECT_ALL_HEROES
            = "SELECT * FROM Hero "
            + "ORDER BY Heroname";
    private static final String SQL_SELECT_ALL_CIVILIANS
            = "SELECT * from Civilian";
    
    private static final String SQL_SELECT_CIVILIAN_ORGS
            = "SELECT orgname "
            + "FROM CivilianOrganization "
            + "WHERE civilianname = ?";

    private static final String SQL_SELECT_ALL_POWERS
            = "SELECT * FROM Power";
    private static final String SQL_SELECT_ALL_ORGS
            = "SELECT * FROM Organization";
    private static final String SQL_SELECT_ALL_LOCS
            = "SELECT * FROM Location";
    private static final String SQL_SELECT_ALL_SIGHTINGS
            = "SELECT * "
            + "FROM sighting";
    private static final String SQL_SELECT_HEROES_AT_SIGHTING
            = "SELECT heroname "
            + "FROM herosighting "
            + "WHERE sightingid = ?";

    private static final String SQL_SELECT_ALL_HEROES_NAME
            = "SELECT heroname "
            + "FROM hero ";
    private static final String SQL_SELECT_ALL_LOCATIONS_NAME
            = "SELECT locationname "
            + "FROM location";
    private static final String SQL_SELECT_ALL_POWERS_NAME
            = "SELECT powername "
            + "FROM power ";
        private static final String SQL_SELECT_ALL_SIGHTINGS_NAME
            = "SELECT * "
            + "FROM sighting "
            + "ORDER BY sightingid DESC";
            private static final String SQL_SELECT_ALL_ORGS_NAME
            = "SELECT OrgName "
            + "FROM organization ";
    
    private static final String SQL_SELECT_X_HEROES_NAME
            = "SELECT heroname "
            + "FROM hero "
            + "LIMIT ?";
    private static final String SQL_SELECT_X_LOCATIONS_NAME
            = "SELECT locationname "
            + "FROM location "
            + "LIMIT ?";
    private static final String SQL_SELECT_X_POWERS_NAME
            = "SELECT powername "
            + "FROM power "
            + "LIMIT ?";
    private static final String SQL_SELECT_X_SIGHTINGS_NAME
            = "SELECT description, sightingID "
            + "FROM sighting "
            + "LIMIT ?";
    private static final String SQL_SELECT_X_ORGS_NAME
            = "SELECT OrgName "
            + "FROM organization "
            + "LIMIT ?";

    private static final String SQL_SELECT_POWERS_OF_NAME
            = "SELECT powername "
            + "FROM heropower "
            + "WHERE heroname = ?";
    private static final String SQL_SELECT_SIGHTINGS_OF_NAME
            = "SELECT sightingid "
            + "FROM herosighting "
            + "WHERE heroname = ?";
    private static final String SQL_SELECT_ORGS_OF_NAME
            = "SELECT OrgName "
            + "FROM heroorganization "
            + "WHERE heroname = ?";
    
    private static final String SQL_SELECT_HEROES_W_POWER
            = "SELECT HeroName "
            + "FROM heropower "
            + "WHERE powername = ?";
            
    private static final String SQL_SELECT_BASES_OF
            = "SELECT LocationName "
            + "FROM Bases "
            + "WHERE OrgName = ?";
    private static final String SQL_SELECT_HEROES_IN_ORG
            = "SELECT HeroName "
            + "FROM HeroOrganization "
            + "WHERE OrgName = ?";
    private static final String SQL_SELECT_CIVS_IN_ORG
            = "SELECT CivilianName "
            + "FROM CivilianOrganization "
            + "WHERE OrgName = ?";
    
    private static final String SQL_SELECT_LAST_SIGHTING
            = "SELECT sightingid "
            + "FROM sighting "
            + "WHERE sightingid = LAST_INSERT_ID()";
    
    private static final String SQL_POWERS_OF_ORG
            = "SELECT DISTINCT powername "
            + "FROM organization "
            + "INNER JOIN heroorganization ON heroorganization.orgname = organization.orgname "
            + "INNER JOIN heropower ON heroorganization.heroname = heropower.heroname "
            + "WHERE organization.orgname = ?";
            
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hero> retrieveHeros() {
        List<Hero> herolist = jdbcTemplate.query(SQL_SELECT_ALL_HEROES, new HeroMapper());
        for (Hero i : herolist) {
            i.setPowers(getPowersOfH(i.getName()));
            i.setOrgs(getOrgsOfH(i.getName()));
            i.setSight(getSightingsOfH(i.getName()));
        }
        return herolist;
    }
    
    @Override
    public List<Location> retrieveLoc() {
        ArrayList<Location> loclist = new ArrayList<>();
        for (Location i : jdbcTemplate.query(SQL_SELECT_ALL_LOCS, new LocMapper())) {
            loclist.add(i);
        }
        return loclist;
    }

    @Override
    public List<Organization> retrieveOrg() {
        List<Organization> orglist = jdbcTemplate.query(SQL_SELECT_ALL_ORGS, new OrgMapper());
        for(Organization i: orglist){
            i.setBases(getBasesOfOrg(i.getName()));
            i.setHeroesIn(getHeroesInOrg(i.getName()));
            i.setCivsIn(getCivsIn(i.getName()));
        }
        return orglist;
    }
    
    public List<String> getBasesOfOrg (String orgname){
        return jdbcTemplate.query(SQL_SELECT_BASES_OF, new LocNameMapper(), orgname);
    }
    
    public List<String> getHeroesInOrg (String orgname){
        return jdbcTemplate.query(SQL_SELECT_HEROES_IN_ORG, new HeroNameMapper(), orgname);
    }
    
    public List<String> getCivsIn (String orgname){
        return jdbcTemplate.query(SQL_SELECT_CIVS_IN_ORG, new CivNameMapper(), orgname);
    }

    @Override
    public List<Power> retrievePower() {
        List<Power> powerlist = jdbcTemplate.query(SQL_SELECT_ALL_POWERS, new PowerMapper());
        for (Power i : powerlist) {
            i.setHeroesWith(getHeroesWith(i.getName()));
        }
        return powerlist;
    }

    @Override
    public List<Sighting> retrieveSighting() {
        List<Sighting> sightlist = jdbcTemplate.query(SQL_SELECT_ALL_SIGHTINGS, new SightingMapper());
        for (Sighting i : sightlist) {
            i.setHeroesAt(getHeroesAt(i.getIndex()));
        }
        return sightlist;
    }
    
    private List<String> getHeroesAt(int index){
        return jdbcTemplate.query(SQL_SELECT_HEROES_AT_SIGHTING, new HeroNameMapper(), index);
    }

    @Override
    public List<String> getHeroes() {
        return jdbcTemplate.query(SQL_SELECT_ALL_HEROES_NAME, new HeroNameMapper());
    }

    @Override
    public List<String> getLocations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_LOCATIONS_NAME, new LocNameMapper());
    }

    @Override
    public List<String> getPowers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_POWERS_NAME, new PowerNameMapper());
    }

    @Override
    public List<String> getHeroes(int x) {
        return jdbcTemplate.query(SQL_SELECT_X_HEROES_NAME, new HeroNameMapper(), x);
    }

    @Override
    public List<String> getLocations(int x) {
        return jdbcTemplate.query(SQL_SELECT_X_LOCATIONS_NAME, new LocNameMapper(), x);
    }

    @Override
    public List<String> getPowers(int x) {
        return jdbcTemplate.query(SQL_SELECT_X_POWERS_NAME, new PowerNameMapper(), x);
    }

    @Override
    public List<String> getSightings() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SIGHTINGS_NAME, new SightNameMapper());
    }

    @Override
    public List<String> getOrgs() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ORGS_NAME, new OrgNameMapper());
    }

    @Override
    public List<String> getSightings(int x) {
        return jdbcTemplate.query(SQL_SELECT_X_SIGHTINGS_NAME, new SightNameMapper(), x);
    }

    @Override
    public List<String> getOrgs(int x) {
        return jdbcTemplate.query(SQL_SELECT_X_ORGS_NAME, new OrgNameMapper(), x);
    }

    @Override
    public List<String> getPowersOfH(String heroname) {
        return jdbcTemplate.query(SQL_SELECT_POWERS_OF_NAME, new PowerNameMapper(), heroname);
    }
    
    @Override
    public List<String> getHeroesWith(String powername) {
        return jdbcTemplate.query(SQL_SELECT_HEROES_W_POWER, new HeroNameMapper(), powername);
    }

    @Override
    public List<String> getSightingsOfH(String heroname) {
        return jdbcTemplate.query(SQL_SELECT_SIGHTINGS_OF_NAME, new SightIDMapper(), heroname);
    }

    @Override
    public List<String> getOrgsOfH(String heroname) {
        return jdbcTemplate.query(SQL_SELECT_ORGS_OF_NAME, new OrgNameMapper(), heroname);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addHero(String heroname, String heroreal, String herodesc, String heroalin) {
        jdbcTemplate.update(SQL_INSERT_HERO, heroname, heroreal, herodesc, heroalin);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addPowerHero(String heroname, String heropwr) {
        jdbcTemplate.update(SQL_INSERT_HEROPWR, heroname, heropwr);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addOrgHero(String heroname, String heroorg) {
        jdbcTemplate.update(SQL_INSERT_HEROORG, heroname, heroorg);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addPower(String powername, String role, String description, int coolness, int usefulness) {
        jdbcTemplate.update(SQL_INSERT_POWER, powername, role, description, coolness, usefulness);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addOrganization(String orgname, String orghq, String orgmission, String orgclass) {
        jdbcTemplate.update(SQL_INSERT_ORG, orgname, orghq, orgmission, orgclass);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addOrgBase(String i, String orgname) {
        jdbcTemplate.update(SQL_INSERT_LOC_ORG, i, orgname);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addLocation(String locname, String locaddr, String locdescmonster, String loclat, String loclong) {
        jdbcTemplate.update(SQL_INSERT_LOC, locname, locaddr, locdescmonster, loclat, loclong);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public int addSighting(String sightdesc, String sightdatestring, String sightloc) {
        
        SimpleDateFormat mydateformatter = new SimpleDateFormat("mm/dd/yyyy");
        Date sightdate;
        try {
            sightdate = mydateformatter.parse(sightdatestring);
            jdbcTemplate.update(SQL_INSERT_SIGHTING, sightdesc, sightdate, sightloc);
            return Integer.parseInt(jdbcTemplate.query(SQL_SELECT_LAST_SIGHTING, new SightIDMapper()).get(0));
        } catch (ParseException ex) {
            return 0;
        }
    }

    @Override
    public List<Hero> retrieveHero(String selectedhero) {
        List<Hero> herolist = jdbcTemplate.query(SQL_SELECT_HERO, new HeroMapper(), selectedhero);
        for (Hero i : herolist) {
            i.setPowers(getPowersOfH(i.getName()));
            i.setOrgs(getOrgsOfH(i.getName()));
            i.setSight(getSightingsOfH(i.getName()));
        }
        return herolist;
    }

    @Override
    public List<Power> retrievePower(String selectedpower) {
        List<Power> powerlist = jdbcTemplate.query(SQL_SELECT_POWER, new PowerMapper(), selectedpower);
        for (Power i : powerlist) {
            i.setHeroesWith(getHeroesWith(i.getName()));
        }
        return powerlist;
    }

    @Override
    public List<Civilians> retrievecivs() {
            List<Civilians> civlist = jdbcTemplate.query(SQL_SELECT_ALL_CIVILIANS, new CivilianMapper());
            for (Civilians i: civlist){
                i.setOrgs(civorgs(i.getName()));
            }
            return civlist;
    }
    
    private List<String> civorgs (String civname){
        return jdbcTemplate.query(SQL_SELECT_CIVILIAN_ORGS, new OrgNameMapper(), civname);
    }

    @Override
    public List<Organization> retrieveOrg(String selectedorg) {
        List<Organization> orglist = jdbcTemplate.query(SQL_SELECT_ORG, new OrgMapper(), selectedorg);
        for(Organization i: orglist){
            i.setBases(getBasesOfOrg(i.getName()));
            i.setHeroesIn(getHeroesInOrg(i.getName()));
            i.setCivsIn(getCivsIn(i.getName()));
        }
        return orglist;
    }

    @Override
    public List<String> orgpower(String selectedorg) {
        return jdbcTemplate.query(SQL_POWERS_OF_ORG, new PowerNameMapper(), selectedorg);
    }

    // ---------------
    // BEGIN SQL PULL CLASSES HERE
    // ---------------
    private static final class PowerNameMapper implements RowMapper<String> {

        @Override
        public String mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getString("Powername");
        }
    }

    private static final class HeroMapper implements RowMapper<Hero> {

        @Override
        public Hero mapRow(ResultSet rs, int rowNum) throws SQLException {
            String heroname = rs.getString("HeroName");
            String realname = rs.getString("NameReal");
            String description = rs.getString("Description");
            String morality = rs.getString("MoralAlignment");
            Hero hero = new Hero(heroname, realname, description, morality);
            return hero;
        }
    }

    private static final class HeroNameMapper implements RowMapper<String> {

        @Override
        public String mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getString("HeroName");
        }
    }

    private static final class LocNameMapper implements RowMapper<String> {

        @Override
        public String mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getString("LocationName");
        }
    }
    
    private static final class SightNameMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet rs, int i) throws SQLException {
            String result = "#"+rs.getString("SightingID")+":  ";
            String descpull = rs.getString("Description");
            if(descpull.length() > 30){
                descpull = descpull.substring(0,27)+"...";
            }
            result += descpull;
            return result;
        }
    }
    
    private static final class SightIDMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getString("sightingid");
        }
    }
    
    private static final class OrgNameMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getString("OrgName");
        }
    }
    
    private static final class CivNameMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getString("CivilianName");
        }
    }

    private static final class LocMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
            String locname = rs.getString("LocationName");
            String address = rs.getString("Address");
            String description = rs.getString("Description");
            double longitude = rs.getDouble("Longitude");
            double latitude = rs.getDouble("Latitude");
            Location locat = new Location(locname, address, description, longitude, latitude);
            return locat;
        }
    }

    private static final class PowerMapper implements RowMapper<Power> {

        @Override
        public Power mapRow(ResultSet rs, int rowNum) throws SQLException {
            String powername = rs.getString("PowerName");
            String desc = rs.getString("Description");
            String roletype = rs.getString("PowerRoleType");
            int ruleofcool = rs.getInt("CoolnessRating");
            int actuallyuseful = rs.getInt("UtilityViability");
            Power power = new Power(powername, desc, roletype, ruleofcool, actuallyuseful);
            return power;
        }
    }

    private static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int rowNum) throws SQLException {
            int sightingID = rs.getInt("SightingID");
            String dateOfString = rs.getString("DateOf");
            SimpleDateFormat mydateformatter = new SimpleDateFormat("yyyy-mm-dd");
            String desc = rs.getString("Description");
            Date dateOf;
            try {
                dateOf = mydateformatter.parse(dateOfString);
            } catch (ParseException ex) {
                dateOf = new Date();
                desc += "/n Note: Date Parsing Error!";
            }
            Sighting newsighting = new Sighting(sightingID, dateOf, desc);
            return newsighting;
        }
    }

    private static final class OrgMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
            String orgName = rs.getString("OrgName");
            String missionStatement = rs.getString("MissionStatement");
            String classification = rs.getString("Classification");
            String headquarters = rs.getString("Headquarters");
            Organization neworg = new Organization(orgName, missionStatement, classification, headquarters);
            return neworg;
        }
    }

    private static final class CivilianMapper implements RowMapper<Civilians> {

        @Override
        public Civilians mapRow(ResultSet rs, int rowNum) throws SQLException {
            String name = rs.getString("CivilianName");
            String desc = rs.getString("Description");
            Civilians newCiv = new Civilians(name, desc);
            return newCiv;
        }
    }

}
