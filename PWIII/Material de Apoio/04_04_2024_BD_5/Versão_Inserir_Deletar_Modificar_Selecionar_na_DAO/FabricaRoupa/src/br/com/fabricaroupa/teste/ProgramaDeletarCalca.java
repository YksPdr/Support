package br.com.fabricaroupa.teste;

import java.sql.Connection;

import br.com.fabricaroupa.conexao.Conexao;
import br.com.fabricaroupa.dao.CalcaDAO;

public class ProgramaDeletarCalca {
	public static void main(String[] args) {
	
		Connection con = Conexao.abrirConexao();
	
	CalcaDAO calcadao = new CalcaDAO(con);
	
	
	calcadao.deletarSemWhereCalca();
	Conexao.fecharConexao(con);
	}
}
