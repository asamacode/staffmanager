package com.asama.staffmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asama.staffmanager.model.Depart;
import com.asama.staffmanager.service.DepartService;

@Controller
@RequestMapping("/departs")
public class DepartController {
    
    @Autowired
    private DepartService departService;

    @GetMapping("/add")
    public String add(Model model) {
        Depart depart = new Depart();
        model.addAttribute("depart", depart);
        return "departs/addOrEdit";
    }
    
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(Model model,@ModelAttribute("depart") Depart depart) {
        departService.save(depart);
        return "departs/addOrEdit";
    }
    
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Optional<Depart> depart = departService.findById(id);
        if (depart.isPresent()) {
            model.addAttribute("depart", depart);
        } else {
            return list(model);
        }
        return "departs/addOrEdit";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Optional<Depart> depart = departService.findById(id);
        
        if (depart.isPresent()) {
            departService.deleteById(id);
        }
        return "departs/list";
    }
    
    @RequestMapping("/list")
    public String list(Model model) {
        List<Depart> departs = departService.findAll();
        model.addAttribute("departs", departs);
        return "departs/list";
    }
    
    @RequestMapping("/find")
    public String find() {
        return "departs/list";
    }
}
