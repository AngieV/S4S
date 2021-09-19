package org.launchcode.Songs4Soldiers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormsController {

    @GetMapping
    public String displayVetAssistForm(Model model){
        model.addAttribute("title_vet", "Apply for Assistance");
        return "S4S/contact";
    }
    // public String @ResponseBody
}
