package br.com.construtora.model;

public class Apartamento extends Imovel{

	private int quantidadeVarandas;

	public int getQuantidadeVarandas() {
		return quantidadeVarandas;
	}

	public void setQuantidadeVarandas(int quantidadeVarandas) {
		this.quantidadeVarandas = quantidadeVarandas;
	}
	
	public void retornarNome () {
		System.out.println("oi");
	}
}
