package com.hospital.hospital_universitario.models;

public class Laudo {
	
	private int Id;
	private String descricao;
	private String conclusao;
	//Residente responsável pelo laudo
	private String residenteConectado;
	//Tem que criar um enum para a variável embaixo
	private String status;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
