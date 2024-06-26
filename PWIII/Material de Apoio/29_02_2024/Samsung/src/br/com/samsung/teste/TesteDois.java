package br.com.samsung.teste;

import javax.swing.JOptionPane;

import br.com.samsung.model.Celular;
import br.com.samsung.model.LinhaBranca;

public class TesteDois {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite "
				+ "1 para instanciar um objeto linha branca e 2 para"
				+ "um objeto celular"));
		
		if(opcao == 1) {
			
			LinhaBranca linhaBrancaDois = new LinhaBranca();

			linhaBrancaDois.setNome(JOptionPane.showInputDialog("Digite o nome do eletrodoméstico linha branca"));
			linhaBrancaDois.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Digite o peso")));
			linhaBrancaDois.setTipo(JOptionPane.showInputDialog("Digite o tipo"));
			
		}
		else {
			Celular celularNovinhoDois = new Celular();

			celularNovinhoDois.setNome(JOptionPane.showInputDialog("Digite o nome do celular"));
			celularNovinhoDois.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Digite o peso")));
			celularNovinhoDois.setLarguraTela(Double.parseDouble(JOptionPane.showInputDialog("Digite a largura")));
			celularNovinhoDois.setLarguraTela(Double.parseDouble(JOptionPane.showInputDialog("Digite a altura")));
		}
	}
}
