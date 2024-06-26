package br.com.projetofinalbd.teste;

import java.sql.Connection;

import br.com.projetofinalbd.conexao.Conexao;
import br.com.projetofinalbd.dao.PessoaDAO;
import br.com.projetofinalbd.model.Pessoa;

public class TesteDeletar {

	public static void main(String[] args) {

Connection con = Conexao.abrirConexao();
		
		Pessoa pessoa = new Pessoa();
		PessoaDAO pessoadao = new PessoaDAO(con);
		
		pessoa.setNome("Rafael");	
		
		System.out.println(pessoadao.deletar(pessoa));
		
		Conexao.fecharConexao(con);

	}

}
