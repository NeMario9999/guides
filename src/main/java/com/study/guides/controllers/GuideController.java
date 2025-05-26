package com.study.guides.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

 @Controller
 public class GuideController {
    @GetMapping
    public String getAllGuides(Model model) {
        return "home";
    }

    @GetMapping("/{id}")
    public String getGuideById(@PathVariable Long id, Model model) {
     return "guides";
    }
}