package com.hospital.hospital_universitario.controllers;

import com.hospital.hospital_universitario.models.Medico;
import com.hospital.hospital_universitario.repositories.MedicoRepository;
import com.hospital.hospital_universitario.services.MedicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/login" )
@CrossOrigin
public class LoginController {
 
    private final MedicoService medicoService;

    @Autowired
    public LoginController(MedicoService medicoService){
        this.medicoService = medicoService;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("./Login_Cadastrar_Medico");
        return mv;
    }
}
