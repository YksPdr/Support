package br.com.sobrinho.teste;

import javax.swing.JOptionPane;
import br.com.sobrinho.model.ClienteSobrinho;
import br.com.sobrinho.model.FuncionarioSobrinho;
import br.com.sobrinho.model.PessoaSobrinho;

public class TesteSobrinho {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PessoaSobrinho pessoaSobrinho = new PessoaSobrinho();
		pessoaSobrinho.setNomeSobrinho(JOptionPane.showInputDialog("Digite o nome:"));
		pessoaSobrinho.setIdadeSobrinho(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade:")));
		
		FuncionarioSobrinho funcionarioSobrinho = new FuncionarioSobrinho();
		funcionarioSobrinho.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Digite o salário:")));
		
		ClienteSobrinho clienteSobrinho = new ClienteSobrinho();
		clienteSobrinho.setValorCompraSobrinho(Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da compra:")));
		
		System.out.println("INFORMAÇÕES \n");
		System.out.println("Nome: " + pessoaSobrinho.getNomeSobrinho());
		System.out.println("Idade: " + pessoaSobrinho.getIdadeSobrinho());
		System.out.println("Salário: " + funcionarioSobrinho.getSalario());
		System.out.println("Valor da compra: " + clienteSobrinho.getValorCompraSobrinho());
	}
}