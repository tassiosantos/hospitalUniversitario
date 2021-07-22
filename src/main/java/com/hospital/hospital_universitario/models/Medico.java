package com.hospital.hospital_universitario.models;

public class Medico {
	
	private int Id;
	private String nome;
	private String cpf;
	//Por enquanto
	private String CRM;
	private String titulacao;
	//Tem que criar um enum para a variável embaixo
	private String tipo;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public void setCRM(String CRM) {
		this.CRM = CRM;
	}
	public String getCRM() {
		return CRM;
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
