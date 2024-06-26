package br.com.construtora.teste;

import br.com.construtora.model.Apartamento;

public class Teste {

	public static void main(String[] args) {
		
		Apartamento apartamentoNovinho = new Apartamento();
		
		apartamentoNovinho.setNome("Prédio das Oliveiras");
		apartamentoNovinho.setQuantidadeQuartos(2);
		apartamentoNovinho.setMetrosquadrados(80);
		apartamentoNovinho.setQuantidadeVarandas(3);
		
		System.out.println("Nome " + apartamentoNovinho.getNome() +
				"\nMetros quadrados " + apartamentoNovinho.getMetrosquadrados() + 
				"\nQuantidade de quartos " + apartamentoNovinho.getQuantidadeQuartos() +
				"\nQuantidade varandas " + apartamentoNovinho.getQuantidadeVarandas()
				
				);
		
		apartamentoNovinho.retornarNome();
	}
}
