package br.com.senaijandira.model;

public class Cargo {
	
	// Atributos da classe
	private int id;
	private String nome;
	
	// Métodos getters e setters
	public int getId() {
		return id;
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
	
	@Override
	public String toString() {
		return getNome();
	}
	
}
