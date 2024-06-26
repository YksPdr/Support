package br.com.fiap.banco.model;

public class Pessoa {
	
	private String nome;
	
	//Construtor vazio
	Pessoa(){}
	
	//Construtor cheio
	public Pessoa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	} 
	

}
