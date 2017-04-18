package com.sg.superherodatabase.controller;

import com.sg.superherodatabase.dto.Hero;
import com.sg.superherodatabase.dto.Organization;
import com.sg.superherodatabase.dto.Power;
import com.sg.superherodatabase.dto.Sighting;
import com.sg.superherodatabase.service.SHService;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerMavenImpl implements SHDController {

    private final SHService service;

    @Inject
    public ControllerMavenImpl(SHService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayHomePage(Model model) {
        model.addAttribute("herolist", service.getHeroes(10));
        model.addAttribute("loclist", service.getLocations(10));
        model.addAttribute("powerlist", service.getPowers(10));
        model.addAttribute("orglist", service.getOrgs(10));
        model.addAttribute("sightlist", service.getSightings(10));
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String redirHomePage(Model model) {
        return displayHomePage(model);
    }

    @RequestMapping(value = "/heroes", method = RequestMethod.GET)
    public String displayHeroesPage(Model model) {
        model.addAttribute("herolist", service.retrieveHeros());
        model.addAttribute("civillist", service.retrievecivs());
        return "heroes";
    }

    @RequestMapping(value = "/powers", method = RequestMethod.GET)
    public String displayPowersPage(Model model) {
        model.addAttribute("powerlist", service.retrievePower());
        return "powers";
    }

    @RequestMapping(value = "/orgs", method = RequestMethod.GET)
    public String displayOrgsPage(Model model) {
        model.addAttribute("orglist", service.retrieveOrg());
        model.addAttribute("loclist", service.retrieveLoc());
        return "orgs";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String displaySearchPage(Model model) {

        return "search";
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.GET)
    public String displayAddPage(Model model) {
        model.addAttribute("pwroptions", service.getPowers());
        model.addAttribute("orgoptions", service.getOrgs());
        model.addAttribute("herooptions", service.getHeroes());
        model.addAttribute("locationoptions", service.getLocations());

        return "addnew";
    }

    @RequestMapping(value = "/newhero", method = RequestMethod.POST)
    public String heroAdded(HttpServletRequest request, Model model) {

        String heroname = request.getParameter("heronameinput");
        String heroreal = request.getParameter("herorealinput");
        if (heroreal.equals("")) {
            heroreal = "Unknown";
        }
        String herodesc = request.getParameter("herodescinput");
        if (herodesc.equals("")) {
            herodesc = "No data";
        }
        String heroalin = request.getParameter("heroalininput");
        if (heroalin.equals("")) {
            heroalin = "Unknown";
        }
        String heropwr = request.getParameter("heropowerinput");
        String heroorg = request.getParameter("heroorginput");

        String addStatus = service.addHero(heroname, heroreal, herodesc, heroalin, heropwr, heroorg);

        model.addAttribute("status", addStatus);
        return displayAddPage(model);
    }

    @RequestMapping(value = "/newpower", method = RequestMethod.POST)
    public String powerAdded(HttpServletRequest request, Model model) {

        String powername = request.getParameter("powernameinput");
        String role = request.getParameter("powerroleinput");
        String description = request.getParameter("powerdescinput");
        String rawcoolness = request.getParameter("coolnessinput");
        int coolness = Integer.parseInt(rawcoolness);
        String rawusefulness = request.getParameter("usefulnessinput");
        int usefulness = Integer.parseInt(rawusefulness);

        String[] whohaspower = request.getParameterValues("herowithpower");
        for (String i : whohaspower) {
        }

        String addStatus = service.addPower(powername, role, description, coolness, usefulness, whohaspower);

        model.addAttribute("status", addStatus);
        return displayAddPage(model);
    }

    @RequestMapping(value = "/neworg", method = RequestMethod.POST)
    public String orgAdded(HttpServletRequest request, Model model) {

        String orgname = request.getParameter("orgnameinput");
        String orghq = request.getParameter("orghqinput");
        String orgmission = request.getParameter("orgmissioninput");
        String orgclass = request.getParameter("orgclassinput");
        String[] orgheroesinput = request.getParameterValues("orgheroesin");
        String[] bases = request.getParameterValues("orglocations");

        String addStatus = service.addOrganization(orgname, orghq, orgmission, orgclass, orgheroesinput, bases);

        model.addAttribute("status", addStatus);
        return displayAddPage(model);
    }

    @RequestMapping(value = "/newloc", method = RequestMethod.POST)
    public String locAdded(HttpServletRequest request, Model model) {

        String locname = request.getParameter("locnameinput");
        String locaddr = request.getParameter("locaddrinput");
        String locdescmonster = request.getParameter("locdescinput");
        String loclat = request.getParameter("loclatinput");
        String loclong = request.getParameter("loclonginput");
        String[] orgspresent = request.getParameterValues("locorglocations");

        String addStatus = service.addLocation(locname, locaddr, locdescmonster, loclat, loclong, orgspresent);

        model.addAttribute("status", addStatus);
        return displayAddPage(model);
    }

    @RequestMapping(value = "/newsight", method = RequestMethod.POST)
    public String sightAdded(HttpServletRequest request, Model model) {

        String addStatus = "Successfully added new sighting!";
        String sightdesc = request.getParameter("sightdescinput");
        String[] heroespresent = request.getParameterValues("heroesatsighting");
        String sightloc = request.getParameter("sightingloc");
        String sightdate = ""+request.getParameter("datemonth")+"/"+request.getParameter("dateday")+"/"+request.getParameter("datecentury")+request.getParameter("datedecade")+request.getParameter("dateyear");
        
        int resultingsightingid = service.addSighting(sightdesc, sightdate, sightloc, heroespresent);
        addStatus += " The new sighting's ID is "+resultingsightingid;
        
        if(resultingsightingid==0){addStatus = "Failed to add sighting - date parsing error!";}
        
        model.addAttribute("status", addStatus);
        return displayAddPage(model);
    }
    
    @RequestMapping(value = "/hero", method = RequestMethod.GET)
    public String heroDetail(HttpServletRequest request, Model model){
        
        String selectedhero = request.getParameter("selected");
        Hero theOne = service.retrieveHero(selectedhero);
        model.addAttribute("selected", theOne);
        
        
        return "hero";
    }
    
    @RequestMapping(value = "/power", method = RequestMethod.GET)
    public String powerDetail(HttpServletRequest request, Model model){
        
        String selectedpower = request.getParameter("selected");
        Power iHaveThe = service.retrievePower(selectedpower);
        model.addAttribute("selected", iHaveThe);
        
        
        return "power";
    }
    
    @RequestMapping(value = "/sightings", method = RequestMethod.GET)
    public String viewSightings(HttpServletRequest request, Model model){ //that seems redundant.
        
        List<Sighting> sightlist = service.retrieveSighting();
        model.addAttribute("allsightings", sightlist);
        
        return "sightings";
    }
    
    @RequestMapping(value = "/org", method = RequestMethod.GET)
    public String orgDetail(HttpServletRequest request, Model model){ //that seems redundant.
        
        String selectedorg = request.getParameter("selected");
        Organization orgGet = service.retrieveOrg(selectedorg);
        model.addAttribute("selected", orgGet);
        List<String> powerjoin = service.orgpower(selectedorg);
        model.addAttribute("powerlibrary", powerjoin);
        
        return "org";
    }

}
