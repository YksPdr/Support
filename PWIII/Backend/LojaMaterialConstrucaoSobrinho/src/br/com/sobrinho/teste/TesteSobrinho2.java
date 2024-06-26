package br.com.sobrinho.teste;

import javax.swing.JOptionPane;
import br.com.sobrinho.model.AtivoSobrinho;
import br.com.sobrinho.model.MaterialSobrinho;
import br.com.sobrinho.model.MaterialVendaSobrinho;

public class TesteSobrinho2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaterialSobrinho materialSobrinho = new MaterialSobrinho();
		materialSobrinho.setDescricaoSobrinho(JOptionPane.showInputDialog("Digite a descrição do material:"));
		materialSobrinho.setPesoSobrinho(Double.parseDouble(JOptionPane.showInputDialog("Digite o peso do material:")));
		
		AtivoSobrinho ativoSobrinho = new AtivoSobrinho();
		ativoSobrinho.setDataAquisicao(Integer.parseInt(JOptionPane.showInputDialog("Digite o dia de aquisição do material:")));
		
		MaterialVendaSobrinho materialVendaSobrinho = new MaterialVendaSobrinho();
		materialVendaSobrinho.setValorCompraSobrinho(Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de compra do material:")));
		materialVendaSobrinho.setValorVendaSobrinho(Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de venda do material:")));
		
		System.out.println("INFORMAÇÕES DO MATERIAL \n");
		System.out.println("Descrição: " + materialSobrinho.getDescricaoSobrinho());
		System.out.println("Peso: " + materialSobrinho.getPesoSobrinho() + " kg");
		System.out.println("Data de aquisição: " + ativoSobrinho.getDataAquisicaoSobrinho());
		System.out.println("Valor da compra: " + materialVendaSobrinho.getValorCompraSobrinho());
		System.out.println("Valor da venda: " + materialVendaSobrinho.getValorVendaSobrinho());
	}

}
