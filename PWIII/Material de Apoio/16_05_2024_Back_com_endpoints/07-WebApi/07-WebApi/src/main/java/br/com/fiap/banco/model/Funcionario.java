package br.com.fiap.banco.model;

public class Funcionario extends Pessoa{
	
	private double salario;
	
	public Funcionario() {
		
	}

	public Funcionario(String nome, double salario) {
		super(nome);
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	

}
