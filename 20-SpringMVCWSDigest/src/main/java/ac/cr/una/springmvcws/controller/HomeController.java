package ac.cr.una.springmvcws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("greeting", "Welcome to Universidad Nacional de Costa Rica!");
        model.addAttribute("tagline", "Curso EIF509 - Desarrollo Web");

        return "index";
    }

}

