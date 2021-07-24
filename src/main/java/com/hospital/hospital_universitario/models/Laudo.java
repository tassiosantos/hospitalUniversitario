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
	private String residenteConectado;
	//Tem que criar um enum para a variável embaixo
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
	public String getResidenteConectado() {
		return residenteConectado;
	}
	public void setResidenteConectado(String residenteConectado) {
		this.residenteConectado = residenteConectado;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
