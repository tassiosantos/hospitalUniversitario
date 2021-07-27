package com.hospital.hospital_universitario.models;

<<<<<<< HEAD
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
=======
public class Medico {
	
	private int Id;
	private String nome;
	private String cpf;
	//Por enquanto
	private String CRM;
>>>>>>> b1594b08c1be1a7549c22f88d02f758c922485bb
	private String titulacao;
	//Tem que criar um enum para a variável embaixo
	private String tipo;
	
<<<<<<< HEAD
	public Medico(){

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
=======
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
>>>>>>> b1594b08c1be1a7549c22f88d02f758c922485bb
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
<<<<<<< HEAD
	public void setCRM(String crm) {
		this.crm = crm;
	}
	public String getCRM() {
		return crm;
=======
	public void setCRM(String CRM) {
		this.CRM = CRM;
	}
	public String getCRM() {
		return CRM;
>>>>>>> b1594b08c1be1a7549c22f88d02f758c922485bb
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