package br.com.sobrinho.test2;

import java.sql.Connection;
import br.com.sobrinho.conexao.Conexao;
import br.com.sobrinho.dao.ClientePJSobrinhoDAO;
import br.com.sobrinho.model.ClientePJSobrinho;


public class TesteSobrinho {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = Conexao.abrirConexao();
		ClientePJSobrinhoDAO clientePJDAO = new ClientePJSobrinhoDAO(con);
		ClientePJSobrinho clientePJ = new ClientePJSobrinho();
		
		clientePJ.setCnpjSobrinho(1233333);
		clientePJ.setNomeSobrinho("Thomas");
		clientePJ.setEnderecoSobrinho("Rua Top");
		clientePJ.setNomeAgenciaSobrinho("Agência Robotics");
		clientePJ.setNomeGerenteSobrinho("Jorge");
		
		int recebeCNPJ = clientePJ.getCnpjSobrinho();
		String recebeNome = clientePJ.getNomeSobrinho();
		String recebeEndereco = clientePJ.getEnderecoSobrinho();
		String recebeNomeAgencia = clientePJ.getNomeAgenciaSobrinho();
		String recebeNomeGerente = clientePJ.getNomeGerenteSobrinho();
		
		System.out.println("Os dados do cliente são: \n" +
			recebeCNPJ + "\n" +	
			recebeNome + "\n" +
			recebeEndereco + "\n" +
			recebeNomeAgencia + "\n" +
			recebeNomeGerente + "\n"
				);
		
		System.out.println(clientePJDAO.inserir(clientePJ));
	}
}