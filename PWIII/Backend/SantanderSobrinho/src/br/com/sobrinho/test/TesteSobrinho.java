package br.com.sobrinho.test;

import java.sql.Connection;
import br.com.sobrinho.conexao.Conexao;
import br.com.sobrinho.dao.ClientePFSobrinhoDAO;
import br.com.sobrinho.model.ClientePFSobrinho;


public class TesteSobrinho {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = Conexao.abrirConexao();
		ClientePFSobrinhoDAO clientePFDAO = new ClientePFSobrinhoDAO(con);
		ClientePFSobrinho clientePF = new ClientePFSobrinho();
		
		clientePF.setCpfSobrinho(12335533);
		clientePF.setNomeSobrinho("Rafael");
		clientePF.setEnderecoSobrinho("Rua Mal");
		clientePF.setNomeAgenciaSobrinho("Agência Future");
		clientePF.setNomeGerenteSobrinho("Carlos");
		
		int recebeCPF = clientePF.getCpfSobrinho();
		String recebeNome = clientePF.getNomeSobrinho();
		String recebeEndereco = clientePF.getEnderecoSobrinho();
		String recebeNomeAgencia = clientePF.getNomeAgenciaSobrinho();
		String recebeNomeGerente = clientePF.getNomeGerenteSobrinho();
		
		System.out.println("Os dados do cliente são: \n" +
			recebeCPF + "\n" +	
			recebeNome + "\n" +
			recebeEndereco + "\n" +
			recebeNomeAgencia + "\n" +
			recebeNomeGerente + "\n"
				);
		
		System.out.println(clientePFDAO.inserir(clientePF));
	}
}