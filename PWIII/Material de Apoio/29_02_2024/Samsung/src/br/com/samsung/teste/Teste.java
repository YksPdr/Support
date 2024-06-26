package br.com.samsung.teste;

import javax.swing.JOptionPane;

import br.com.samsung.model.Celular;
import br.com.samsung.model.LinhaBranca;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		LinhaBranca linhaBranca = new LinhaBranca();
		// LinhaBranca teste = new LinhaBranca();

		linhaBranca.setNome("Geladeira industrial");
		linhaBranca.setPeso(230);
		linhaBranca.setTipo("geladeira");
*/
		// Abaixo instanciar o objeto celular

		Celular celularNovinho = new Celular();

		celularNovinho.setNome("Samsung 24");
		celularNovinho.setPeso(177);
		celularNovinho.setLarguraTela(7);
		celularNovinho.setLarguraTela(14.7);

			
		// Teste
		double numero = Double.parseDouble("7");
		System.out.println(numero);

		LinhaBranca linhaBrancaDois = new LinhaBranca();
		// linhaBrancaDois teste = new linhaBrancaDois();

		linhaBrancaDois.setNome(JOptionPane.showInputDialog("Digite o nome"));
		linhaBrancaDois.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Digite o peso")));
		linhaBrancaDois.setTipo(JOptionPane.showInputDialog("Digite o tipo"));

		Celular celularNovinhoDois = new Celular();

		celularNovinhoDois.setNome(JOptionPane.showInputDialog("Digite o nome"));
		celularNovinhoDois.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Digite o peso")));
		celularNovinhoDois.setLarguraTela(Double.parseDouble(JOptionPane.showInputDialog("Digite a largura")));
		celularNovinhoDois.setLarguraTela(Double.parseDouble(JOptionPane.showInputDialog("Digite a altura")));
	}

}
