package org.launchcode.Songs4Soldiers.controllers;

import org.launchcode.Songs4Soldiers.data.UserData;
import org.launchcode.Songs4Soldiers.data.UserRepository;
import org.launchcode.Songs4Soldiers.models.User;
import org.launchcode.Songs4Soldiers.models.Veteran;
import org.launchcode.Songs4Soldiers.models.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/S4S")
public class FormsController {

    //@Autowired
    private UserRepository userRepository;

    @GetMapping("/contact")
    public String displayForms(Model model) {
        model.addAttribute("title_vet", "Apply for Assistance");
        model.addAttribute(new Veteran());
        List<String> branchList = Arrays.asList("--Please select--", "US Army", "US Navy", "US Air Force", "US Marines", "US Coast Guard");
        model.addAttribute("branchList", branchList);
        model.addAttribute("title_vol", "Be a Volunteer");
        model.addAttribute(new Volunteer());
        return "S4S/contact";
    }

    @PostMapping("/contact")
    public String processVetAssistRequest(@Valid @ModelAttribute Veteran veteran,
                                          Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Contact Us");
            return "S4S/contact";
        }
        UserRepository.save(veteran);
        return "redirect:contact";
        //return "redirect:registered";
    }

    @PostMapping("/createVolunteer")
    public String createVolunteer(@Valid @ModelAttribute Volunteer volunteer,
                                  Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Contact Us");
            return "S4S/contact";
        }
        UserRepository.save(volunteer);
        return "redirect:contact";
        //return "redirect:registered";
    }
}

 /*   private static List<Veteran> veteran = new ArrayList<>();
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
