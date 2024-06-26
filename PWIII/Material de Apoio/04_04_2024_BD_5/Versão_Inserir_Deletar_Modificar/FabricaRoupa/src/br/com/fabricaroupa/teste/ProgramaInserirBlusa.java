package br.com.fabricaroupa.teste;

import java.sql.Connection;

import br.com.fabricaroupa.conexao.Conexao;
import br.com.fabricaroupa.dao.BlusaDAO;
import br.com.fabricaroupa.model.Blusa;

public class ProgramaInserirBlusa {

public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Blusa blusa = new Blusa();
		BlusaDAO blusadao = new BlusaDAO(con);
		
		blusa.setPeso(400);
		blusa.setTipoTecido("Jeans");
		blusa.setTouca("Sim");

	
		blusadao.inserirBlusa(blusa);
		Conexao.fecharConexao(con);
	}
}
