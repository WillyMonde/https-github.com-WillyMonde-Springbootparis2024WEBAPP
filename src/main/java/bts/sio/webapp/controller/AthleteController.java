package bts.sio.webapp.controller;

import bts.sio.webapp.model.Athlete;
import bts.sio.webapp.model.Pays;
import bts.sio.webapp.model.Sport;
import bts.sio.webapp.repository.SportProxy;
import bts.sio.webapp.service.AthleteService;
import bts.sio.webapp.service.PaysService;
import bts.sio.webapp.service.SportService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Data
@Controller
public class AthleteController {

    @Autowired
    private AthleteService athleteservice;

    @Autowired
    private PaysService paysService;

    @Autowired
    private SportService sportService;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Athlete> listAthletes = athleteservice.getAthletes();
        model.addAttribute("athletes", listAthletes);
        return "home";
    }

    @GetMapping("/createAthlete")
    public String createAthlete(Model model) {
        Athlete a = new Athlete();
        model.addAttribute("athlete", a);

        Iterable<Pays> listPays = paysService.getLesPays();
        model.addAttribute("listPays", listPays);

        return "athlete/formNewAthlete";
    }

    @GetMapping("/updateAthlete/{id}")
    public String updateAthlete(@PathVariable("id") final int id, Model model) {
        Athlete a = athleteservice.getAthlete(id);
        model.addAttribute("athlete", a);

        Iterable<Pays> listPays = paysService.getLesPays();
        model.addAttribute("paysList", listPays);

        Iterable<Sport> listSport = sportService.getLesSports();
        model.addAttribute("sportList", listSport);

        return "athlete/formUpdateAthlete";
    }

    @GetMapping("/deleteAthlete/{id}")
    public ModelAndView deleteAthlete(@PathVariable("id") final int id) {
        athleteservice.deleteAthlete(id);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/saveAthlete")
    public ModelAndView saveAthlete(@ModelAttribute Athlete athlete) {
        if (athlete.getId() != null) {
            Athlete current = athleteservice.getAthlete(athlete.getId());
            current.setPrenom(athlete.getPrenom());
            current.setNom(athlete.getNom());
            current.setDatenaiss(athlete.getDatenaiss());
            current.setPays(athlete.getPays());
            current.setSport(athlete.getSport());
            athleteservice.saveAthlete(current);
        } else {
            athleteservice.saveAthlete(athlete);
        }
        return new ModelAndView("redirect:/");
    }
}
