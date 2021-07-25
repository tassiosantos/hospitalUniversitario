package com.hospital.hospital_universitario.models;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table
public class Medico {
	
	@Id
    @SequenceGenerator(
        name = "medico_sequence",
        sequenceName = "medico_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "medico_sequence"
    )
	
	private int id;
	private String nome;
	private String cpf;
	//Por enquanto
	private String crm;
	private String titulacao;
	//Tem que criar um enum para a variável embaixo
	private String tipo;
	
	public Medico(){

	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setCRM(String crm) {
		this.crm = crm;
	}
	public String getCRM() {
		return crm;
	}
	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	public String getTitulacao() {
		return titulacao;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return tipo;
	}
	
}