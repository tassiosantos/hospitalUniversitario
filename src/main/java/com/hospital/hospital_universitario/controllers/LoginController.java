package com.hospital.hospital_universitario.controllers;

import com.hospital.hospital_universitario.models.Medico;
import com.hospital.hospital_universitario.services.MedicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/login" )
@CrossOrigin
public class LoginController {
 
    private final MedicoService medicoService;
    private final IndexController indexController;

    @Autowired
    public LoginController(MedicoService medicoService, IndexController indexController){
        this.medicoService = medicoService;
        this.indexController = indexController;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrarNovo(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("./Login_Cadastrar_Medico");
        return mv;
    }

    @PostMapping(path = "/cadastrar")
    public ModelAndView cadastrar(Medico newMedico){
        this.medicoService.newMedico(newMedico);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        
        return mv;
    }
}
