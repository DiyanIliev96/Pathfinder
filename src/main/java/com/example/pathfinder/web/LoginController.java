package com.example.pathfinder.web;

import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class LoginController {


    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }


    @PostMapping("/login-success")
    public String loginSuccess() {
        return "redirect:/";
    }

    @GetMapping("/login-error")
    public String failureLogin(
            @ModelAttribute("username") String username, RedirectAttributes redirectAttributes
            ) {
        redirectAttributes.addFlashAttribute("username",username);
        redirectAttributes.addFlashAttribute("bad_credentials",true);
        return "redirect:/user/login";
    }
}
