package org.launchcode.Songs4Soldiers.controllers;

import org.launchcode.Songs4Soldiers.data.RegUserRepository;
import org.launchcode.Songs4Soldiers.data.UserRepository;
import org.launchcode.Songs4Soldiers.models.DTO.LoginFormDTO;
import org.launchcode.Songs4Soldiers.models.DTO.RegisterFormDTO;
import org.launchcode.Songs4Soldiers.models.RegisteredUser;
import org.launchcode.Songs4Soldiers.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

/*
 * Code provided by LaunchCode
 */

@Controller
@RequestMapping("/S4S")
public class AuthenticationController {

    @Autowired
    RegUserRepository regUserRepository;

    private static final String userSessionKey = "user";

    public RegisteredUser getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<RegisteredUser> r_user = regUserRepository.findById(userId);

        if (r_user.isEmpty()) {
            return null;
        }

        return r_user.get();
    }

    private static void setUserInSession(HttpSession session, RegisteredUser r_user) {
        session.setAttribute(userSessionKey, r_user.getUserID());
    }

    @GetMapping("/register")
    public String displayRegistrationForm(Model model) {
        model.addAttribute(new RegisterFormDTO());
        model.addAttribute("title", "Register");
        return "S4S/register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return "S4S/register";
        }

        RegisteredUser existingUser = regUserRepository.findByUsername(registerFormDTO.getUsername());

        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            model.addAttribute("title", "Register");
            return "S4S/register";
        }

        String password = registerFormDTO.getPassword();
        String verifyPassword = registerFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Register");
            return "S4S/register";
        }

        RegisteredUser newUser = new RegisteredUser(registerFormDTO.getUsername(), registerFormDTO.getPassword());
        regUserRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:";
    }

    @GetMapping("/login")
    public String displayLoginForm(Model model) {
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Log In");
        return "S4S/login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                   Errors errors, HttpServletRequest request,
                                   Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            return "S4S/login";
        }

        RegisteredUser theUser = regUserRepository.findByUsername(loginFormDTO.getUsername());

        if (theUser == null) {
            errors.rejectValue("username", "user.invalid", "The given username does not exist");
            model.addAttribute("title", "Log In");
            return "S4S/login";
        }

        String password = loginFormDTO.getPassword();

        if (!theUser.isMatchingPassword(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            model.addAttribute("title", "Log In");
            return "S4S/login";
        }

        setUserInSession(request.getSession(), theUser);

        return "redirect:";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/S4S/login";
    }

}
