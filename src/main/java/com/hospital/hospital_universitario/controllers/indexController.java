package com.hospital.hospital_universitario.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class indexController {
	
	@GetMapping("/")    
    public String index() {
        return "index";   
    }

    @RequestMapping(value="/cadastrarPaciente", method=RequestMethod.GET)
	public String form() {
		return "index";
	}

}
