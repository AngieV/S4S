package org.launchcode.Songs4Soldiers.controllers;

import org.launchcode.Songs4Soldiers.models.Veteran;
import org.launchcode.Songs4Soldiers.models.Volunteer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/S4S")
public class FormsController {

    private static List<Veteran> veteran = new ArrayList<>();
    private static List<Volunteer> volunteer = new ArrayList<>();

    @GetMapping
    public String displayForms(Model model){
        model.addAttribute("title_vet", "Apply for Assistance");
        model.addAttribute("title_vol", "Volunteer");
        return "S4S/contact";
    }

    @PostMapping
    public String processVetAssistForm(@ModelAttribute Veteran veteran){
        //UserData.add(veteran);
        return "redirect";
    }


    // public String @ResponseBody
}