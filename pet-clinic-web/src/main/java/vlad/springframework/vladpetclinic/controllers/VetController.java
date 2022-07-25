package vlad.springframework.vladpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vlad.springframework.vladpetclinic.model.Vet;
import vlad.springframework.vladpetclinic.services.VetService;

import java.util.Set;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }


    @RequestMapping({"/vets", "/vets.html", "vets/index", "vets/index.html"})
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
    @GetMapping("/api/vets")
    @ResponseBody
    public Set<Vet> getVetsJSON() {
        return vetService.findAll();
    }
}
