package com.hospital.hospital_universitario.models;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table
public class Laudo {
	
	@Id
    @SequenceGenerator(
        name = "laudo_sequence",
        sequenceName = "laudo_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "laudo_sequence"
    )

	private int id;
	private String descricao;
	private String conclusao;
	//Residente responsável pelo laudo
	
	private int residenteId;
	private int docenteId;
	private int pacienteId;

	private String status;


	
	public Laudo(){

	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getConclusao() {
		return conclusao;
	}
	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}
	public int getResidenteId() {
		return residenteId;
	}
	public void setResidenteId(int residenteId) {
		this.residenteId = residenteId;
	}


	public int getDocenteId() {
		return docenteId;
	}
	public void setDocenteId(int docenteId) {
		this.docenteId = docenteId;
	}



	public int getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}



	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
