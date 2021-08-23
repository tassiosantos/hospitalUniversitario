package com.hospital.hospital_universitario.controllers;

import java.util.List;
import com.hospital.hospital_universitario.services.MedicoService;
import com.hospital.hospital_universitario.models.Medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(path = "/medico" )
@CrossOrigin
public class MedicoController{

    private final MedicoService medicoService;

    @Autowired
    public MedicoController(MedicoService medicoService){
        this.medicoService = medicoService;
    }

    @GetMapping("")
    public ModelAndView getMedico() {
        ModelAndView mv = new ModelAndView("./medico/Listar_Medico");
        Iterable<Medico> medicos = this.medicoService.getMedicos();
        mv.addObject("medicos", medicos);
        return mv;
    }

    @GetMapping(path = "/cadastrar")
    public ModelAndView viewCadastar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("./medico/Cadastrar_Medico");
        return mv;
    }


	@GetMapping(path = "/{medicoId}")
	public ModelAndView getMedicoById(@PathVariable("medicoId") int medicoId){
        ModelAndView mv = new ModelAndView();
        Medico medico = medicoService.getMedicoById(medicoId);
        mv.setViewName("./medico/Detalhar_medico");
        mv.addObject("medicos", medico);
        return mv;
	}
		
    // @PutMapping(path = "/{medicoId}")
	// public Medico updateMedico(
    //     @RequestBody Medico changedMedico){
	// 	Medico medico = this.medicoService.update(changedMedico);
	// 	return medico;
	// }

    @PostMapping("")
    public ModelAndView saveMedico(Medico newMedico){
        ModelAndView mv = new ModelAndView("./medico/Cadastrar_Medico");
        Medico medico = this.medicoService.newMedico(newMedico);
        mv.addObject("medicos", medico);
        return mv;
    }
	
    @PostMapping(path = "/{medicoId}")
    public ModelAndView updateMedico(@PathVariable("medicoId") int medicoId, @RequestBody Medico newMedico){
        ModelAndView mv = new ModelAndView("./medico/Detalhar_Medico");
        Medico medico = new Medico();
        newMedico.setId(medicoId);
        medico = this.medicoService.update(newMedico);
        mv.addObject("medicos", medico);
        return mv;

    }

    @GetMapping(path = "/delete/{medicoId}")
	public String deleteMedico(
        @PathVariable("medicoId") int medicoId){
        Medico medico = this.medicoService.getMedicoById(medicoId);
		this.medicoService.delete(medico);
        return "redirect:/medico";

	}

}
