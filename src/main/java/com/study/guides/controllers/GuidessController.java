package com.study.guides.controllers;

import com.study.guides.models.Guide;
import com.study.guides.repositories.GuideRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller

public class GuidessController {

    @Autowired
    private GuideRepository guideRepository;

    @GetMapping("/guides")
    public String getAllGuides(Model model) {
        Iterable<Guide> guides = guideRepository.findAll();
        model.addAttribute("guide", guides);
        return "guides";
    }

    @GetMapping("/guides/add")
    public String addAllGuides(Model model) {
        Iterable<Guide> guides = guideRepository.findAll();
        model.addAttribute("guide", guides);
        return "guides-add";
    }

    @PostMapping("/guides/add")
    public String addSomeGuides(@RequestParam String tittle,@RequestParam String author,@RequestParam String content, Model model) {
        Guide post = new Guide(tittle,author,content);
        guideRepository.save(post);
        return "redirect:/guides";
    }
    @GetMapping("/guides/add/{id}")
    public String DetailAllGuides(@PathVariable(value = "id") long id, Model model) {
       Optional<Guide> guide = guideRepository.findById(id);
       ArrayList<Guide> guides = new ArrayList<>();
       guide.ifPresent(guides::add);
        model.addAttribute("guide", guides);
        return "guides-detail";
    }

    @PostMapping("/guides/add/{id}/delete")
    public String DeleteGuides(@PathVariable(value = "id") Long id, Model model) {
        Guide Guide = guideRepository.findById(id).orElseThrow();
        guideRepository.delete(Guide);
        return "redirect:/guides";

    }

}