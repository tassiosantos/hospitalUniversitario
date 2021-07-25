package com.hospital.hospital_universitario.controllers;

import java.util.List;
import com.hospital.hospital_universitario.services.LaudoService;
import com.hospital.hospital_universitario.models.Laudo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/laudo" )
@CrossOrigin
public class LaudoController{

    private final LaudoService laudoService;

    @Autowired
    public LaudoController(LaudoService laudoService){
        this.laudoService = laudoService;
    }

    @GetMapping(path = "")
    public List<Laudo> getLaudos(){
        return this.laudoService.getLaudos();
    }

    @GetMapping(path = "/{laudoNumber}")
    public Laudo getLaudoByNumber(@PathVariable("laudoNumber") String laudoNumber){
        return this.laudoService.getLaudoByNumber(laudoNumber); 
    }

    // @GetMapping(path = "/medico/listaMedicos")
    // public List<Laudo> getLaudoByMedicoNumber(@PathVariable("medicoNumber") String medicoNumber){
    //     return this.laudoService.getLaudoByMedicoNumber(laudoNumber);
    // }

<<<<<<< HEAD
	@PutMapping(path = "/{laudoNumber}")
	public Laudo updateLaudo(@PathVariable("laudoNumber") String laudoNumber){
		Laudo laudo = this.laudoService.update(laudoNumber);
		return laudo;
	}
=======
	// @PutMapping(path = "/laudo/{laudoNumber}")
	// public Laudo updateLaudo(@PathVariable("laudoNumber") String laudoNumber){
	// 	//Laudo laudo = this.laudoService.update(laudoNumber);
	// 	//return laudo;
    //     return null;
	// }
>>>>>>> 9cb7fd5e503f66237a1c61d4b2659e21d9fae7bc

	@PostMapping(path = "/")
	public void addLaudo(@RequestBody Laudo newLaudo){
		this.laudoService.newLaudo(newLaudo);
     }

    //  @DeleteMapping(path = "/laudo")
    //  public void addAccount(@RequestBody Account newAccount){
    //      this.accountService.addAccount(newAccount);
    //   }

}
