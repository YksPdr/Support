package teste;

import java.sql.Connection;
import java.util.ArrayList;
import conexao.Conexao;
import dao.PessoaDAO;
import model.Pessoa;

public class TestePessoa {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Pessoa pessoa = new Pessoa();
		PessoaDAO pessoadao = new PessoaDAO(con);

		pessoa.setCpf(35157);
		pessoa.setNome("Rafael");
		pessoa.setIdade(38);

		System.out.println(pessoadao.inserir(pessoa));

		

		// Selecionar

		ArrayList<Pessoa> lista = pessoadao.retornarDadosPessoa();

		if (lista != null) {
			for (Pessoa pessoaDois : lista) {

				System.out.println("Peso da calça: " + pessoaDois.getCpf());
				System.out.println("Tipo tecido da calça: " + pessoaDois.getNome() + "\n");
			}
		}
		Conexao.fecharConexao(con);
	}
}
