package com.hospital.hospital_universitario.controllers;

import java.util.List;

import com.hospital.hospital_universitario.models.Paciente;
import com.hospital.hospital_universitario.repositories.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    //@Autowired
    //private PacienteRepository pr;

    //@RequestMapping("/paciente") 
    //public ModelAndView getPacientes() {
    //    Paciente paciente = new Paciente();
    //    Iterable <Paciente> pacientes = pr.findPacientes(paciente);
    //    ModelAndView mv = new ModelAndView("paciente/Listar_Paciente");
    //    mv.addObject("pacientes", pacientes);
    //    return mv;
    //}

    @PostMapping(path = "/home")    
    public String home() {
        return "home";   
    }

}
