package com.hospital.hospital_universitario.controllers;

import com.hospital.hospital_universitario.services.MedicoService;
import com.hospital.hospital_universitario.models.Medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping(path = "/medico" )
@CrossOrigin
public class MedicoController{

    private final MedicoService medicoService;

    @Autowired
    public MedicoController(MedicoService medicoService){
        this.medicoService = medicoService;
    }

        // @GetMapping("")
        // public ModelAndView getMedico() {
        //     ModelAndView mv = new ModelAndView("./medico/Listar_Medico");
        //     Iterable<Medico> medicos = this.medicoService.getMedicos();
        //     mv.addObject("medicos", medicos);
        //     return mv;
        // }

    @GetMapping(path = "/{medicoId}")
    public ModelAndView getMedicos(@PathVariable int medicoId) {
        ModelAndView mv = new ModelAndView("./medico/Listar_Medico");
        Medico medico = this.medicoService.getMedicoById(medicoId);
        Iterable<Medico> medicos = this.medicoService.getMedicos();
        mv.addObject("medicos", medicos);
        mv.addObject("medicoReg", medico);
        return mv;
    }

    @GetMapping(path = "/cadastrar/{medicoId}")
    public ModelAndView viewCadastar(@PathVariable int medicoId) {
        ModelAndView mv = new ModelAndView();
        Medico medico = this.medicoService.getMedicoById(medicoId);
        mv.setViewName("./medico/Cadastrar_Medico");
        mv.addObject("medicoReg", medico);
        return mv;
    }


	@GetMapping(path = "/{id}")
	public ModelAndView getMedicoById(@PathVariable int id){        
        ModelAndView mv = new ModelAndView();
        // Medico medico = medicoService.getMedicoById(medicoId);
        Medico medicoEscolhido = this.medicoService.getMedicoById(id);
        mv.setViewName("./medico/Detalhar_Medico");
        // mv.addObject("medicoReg", medico);
        mv.addObject("medico", medicoEscolhido);
        return mv;
	}
		
    @PostMapping(path = "/logar")
    public ModelAndView loginMedico(@RequestBody String login)
    {   
        
        String login2[] = login.split("&");
        String crm = login2[0].split("=")[1];
        String senha = login2[1].split("=")[1];
        System.out.println("crm: " + crm + " senha: " + senha);
        Medico medicoLogado = this.medicoService.getMedicoByCrmSenha(crm, senha);
        ModelAndView mv = this.getMedicoById(medicoLogado.getId());
        // ModelAndView mv = new ModelAndView();
        // mv.addObject("medico", medicoLogado.getId());
        return mv;
    }

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

    // @GetMapping(path = "/delete/{medicoId}")
	// public ModelAndView deleteMedico(
    //     @PathVariable("medicoId") int medicoId, RedirectAttributes attributes){
    //     Medico medico = this.medicoService.getMedicoById(medicoId);
	// 	this.medicoService.delete(medico);
    //     attributes.addFlashAttribute("mensagem", "Removido com sucesso!");     
    //     ModelAndView mv = new ModelAndView("./medico/Listar_Medico");
    //     Iterable<Medico> medicos = this.medicoService.getMedicos();
    //     mv.addObject("medicos", medicos);
    //     return mv;
	// }

    // @GetMapping(path = "/delete/{medicoId}/{id}")
	// public String deleteMedico(
    //     @PathVariable("medicoId") int medicoId, @PathVariable int id, RedirectAttributes attributes){
    //     Medico medico = this.medicoService.getMedicoById(medicoId);
    //     Medico medicoEscolhido = this.medicoService.getMedicoById(id);
	// 	this.medicoService.delete(medicoEscolhido);
    //     attributes.addFlashAttribute("mensagem", "Removido com sucesso!");      
    //     return "redirect:/medico/" + medico.getId();
	// }

}
