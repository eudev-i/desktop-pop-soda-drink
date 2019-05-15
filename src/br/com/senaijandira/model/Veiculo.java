package br.com.senaijandira.model;

public class Veiculo {
	
	// Atributos da classe
	private int id;
	private String modelo;
	private String placa;
	private double capac_peso;
	private double capc_volume;
	
	// Métodos getters e setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public double getCapac_peso() {
		return capac_peso;
	}
	public void setCapac_peso(double capac_peso) {
		this.capac_peso = capac_peso;
	}
	public double getCapc_volume() {
		return capc_volume;
	}
	public void setCapc_volume(double capc_volume) {
		this.capc_volume = capc_volume;
	}

}
