package bts.sio.webapp.controller;

import bts.sio.webapp.model.Sport;
import bts.sio.webapp.service.SiteService;
import bts.sio.webapp.service.SportService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@Controller

public class SportController {


    @Autowired
    private SportService sportservice;

    @Autowired
    private SiteService siteService;

    @GetMapping("/sports")
    public String home(Model model) {
        Iterable<Sport> listSports = sportservice.getLesSports();
        model.addAttribute("sports", listSports);
        return "/sport/listerSport";
    }

}
