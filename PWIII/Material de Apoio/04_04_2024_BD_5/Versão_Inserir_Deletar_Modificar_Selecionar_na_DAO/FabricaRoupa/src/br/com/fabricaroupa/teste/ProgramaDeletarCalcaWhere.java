package br.com.fabricaroupa.teste;

import java.sql.Connection;

import br.com.fabricaroupa.conexao.Conexao;
import br.com.fabricaroupa.dao.CalcaDAO;
import br.com.fabricaroupa.model.Calca;

public class ProgramaDeletarCalcaWhere {
	public static void main(String[] args) {
	
		Connection con = Conexao.abrirConexao();
	
	CalcaDAO calcadao = new CalcaDAO(con);
	Calca calca = new Calca();
	
	calca.setTipoTecido("Jeans");
	
	calcadao.deletarComWhereCalca(calca);
	Conexao.fecharConexao(con);
	}
}
