package org.launchcode.Songs4Soldiers.controllers;

import org.launchcode.Songs4Soldiers.data.UserData;
import org.launchcode.Songs4Soldiers.models.User;
import org.launchcode.Songs4Soldiers.models.Veteran;
import org.launchcode.Songs4Soldiers.models.Volunteer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/S4S")
public class FormsController  {

    private static List<Veteran> veteran = new ArrayList<>();
    private static List<Volunteer> volunteer = new ArrayList<>();

    @GetMapping
    public String displayForms(Model model){
        //Veteran veteran = new Veteran();
        model.addAttribute("veteran", veteran);
        return "S4S/contact";
    }

    @PostMapping
    public String processVetAssistForm(@ModelAttribute @Valid Veteran newVeteran,
                                       Errors errors, Model model){
        if(errors.hasErrors()) {
            model.addAttribute("title", "Request Assistance");
            model.addAttribute("errorMsg", "Bad data!");
            return "events/create";
        }
        UserData.add(newVeteran);
        return "redirect";
    }
/*
    @GetMapping
    public String createVolunteer(Model model){
        return "S4S/contact/createVolunteer";
    }

    @PostMapping
    public String createVolunteer(@ModelAttribute Volunteer volunteer){
        UserData.add(volunteer);
        return "redirect";
    }

    <table class="table table-striped">
   <thead>
      <tr>
         <th>ID</th>
         <th>Name</th>
         <th>Description</th>
         <th>Contact Email</th>
      </tr>
   </thead>
   <tr th:each="veteran : ${veteran}">
      <td th:text="${veteran.id}"></td>
      <td th:text="${veteran.name}"></td>
      <td th:text="${veteran.email}"></td>
      <td th:text="${veteran.help}"></td>
   </tr>
</table>

*/


    // public String @ResponseBody
}