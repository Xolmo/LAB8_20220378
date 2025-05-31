package com.example.lab8_20220378.Controller;

import com.example.lab8_20220378.Entity.CrewMembers;
import com.example.lab8_20220378.Entity.Expeditions;
import com.example.lab8_20220378.Entity.Planets;
import com.example.lab8_20220378.Repository.CrewMembersRepository;
import com.example.lab8_20220378.Repository.ExpeditionCrewRepository;
import com.example.lab8_20220378.Repository.ExpeditionsRepository;
import com.example.lab8_20220378.Repository.PlanetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    ExpeditionsRepository expeditionsRepository;
    @Autowired
    CrewMembersRepository crewMembersRepository;
    @Autowired
    PlanetsRepository planetsRepository;
    @Autowired
    ExpeditionCrewRepository expeditionCrewRepository;

    @GetMapping(value = {"","/"})
    private String mainPage(Model model) {
        List<Expeditions> listaExpediciones = expeditionsRepository.findAll();
        List<Planets> listaPlanetas = planetsRepository.findAll();

        model.addAttribute("listaExpediciones", listaExpediciones);
        model.addAttribute("listaPlanetas", listaPlanetas);
        return "index";
    }

    @GetMapping("/crew")
    private String crewList(Model model) {
        List<CrewMembers> listaCrewMembers = crewMembersRepository.findAll();

        model.addAttribute("listaCrewMembers", listaCrewMembers);
        return "crewlist";
    }

    @GetMapping("/crew/new")
    private String newCrewMember(Model model, @ModelAttribute("crewMember") CrewMembers crewMember) {
        return "crewnewfrm";
    }

    @GetMapping("/crew/edit")
    private String editCrewMember(Model model, @ModelAttribute("crewMember") CrewMembers crewMember, @RequestParam("id") Long id) {
        Optional<CrewMembers> optCrewMember = crewMembersRepository.findById(id);
        if (optCrewMember.isPresent()) {
            crewMember = optCrewMember.get();
            model.addAttribute("crewMembers", crewMember);
            return "crewnewfrm";
        }
        return "redirect:/crew";
    }

    @PostMapping("/crew/save")
    private String saveCrewMember(Model model, @ModelAttribute("crewMember") CrewMembers crewMember) {
        System.out.println("Nombre: " + crewMember.getNombreCompleto());
        crewMembersRepository.save(crewMember);
        return "redirect:/crew";
    }

    @PostMapping("/crew/delete")
    private String deleteCrewMember(Model model, @ModelAttribute("crewMember") CrewMembers crewMember, @RequestParam("id") Long id) {
        Optional<CrewMembers> optCrewMember = crewMembersRepository.findById(id);
        if (optCrewMember.isPresent()) {
            crewMember = optCrewMember.get();
            crewMembersRepository.delete(crewMember);
        }
        return "redirect:/crew";
    }
}
