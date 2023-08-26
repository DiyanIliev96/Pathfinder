package com.example.pathfinder.web;

import com.example.pathfinder.model.entity.Route;
import com.example.pathfinder.service.RouteService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final RouteService routeService;

    public HomeController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        Route route = routeService.mostCommented();
        model.addAttribute("mostCommented",route);
        return "index";
    }

//    @GetMapping("/register")
//    public String register() {
//
//        return "register";
//    }

    @GetMapping("/route-details")
    public String learnMore(Model model) {
        Route route = routeService.mostCommented();
        model.addAttribute("route",route);

        return "route-details";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
