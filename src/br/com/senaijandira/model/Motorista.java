package br.com.senaijandira.model;

import java.util.Date;

public class Motorista {
	private int idMotorista;
	private int idVeiculo;
	private String nome;
	private String cpf;
	private String habilitacao;
	private String categoria;
	private Date validade;
	private int status;
	public int getIdMotorista() {
		return idMotorista;
	}
	public void setIdMotorista(int idMotorista) {
		this.idMotorista = idMotorista;
	}
	public int getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
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
	public String getHabilitacao() {
		return habilitacao;
	}
	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
