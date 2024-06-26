package br.com.fabricaroupa.teste;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.fabricaroupa.conexao.Conexao;
import br.com.fabricaroupa.dao.CalcaDAO;
import br.com.fabricaroupa.model.Calca;

public class ProgramaSelecionarCalca {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		CalcaDAO calcadao = new CalcaDAO(con);
		//Calca calca = new Calca();

		ArrayList<Calca> lista = calcadao.retornarDadosCalca();

		if (lista != null) {
			for (Calca calca : lista) {
				
				System.out.println("Peso da calça: " + calca.getPeso());
				System.out.println("Tipo tecido da calça: " + calca.getTipoTecido());
				System.out.println("Tipo da calca: " + calca.getTipo() + 
						"\n"
				
						);
				
			}
		}
		Conexao.fecharConexao(con);
	}
}