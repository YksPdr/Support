package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Funcionario;

public class FuncionarioDao {

	private Connection conn;

	public FuncionarioDao(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(Funcionario funcionario) throws ClassNotFoundException, SQLException {

		// Criar o objeto com o comando SQL configuravel
		PreparedStatement stm = conn.prepareStatement("INSERT INTO funcionario (nome, salario) values (?, ?)");

		// Setar os valores no comando SQL
		stm.setString(1, funcionario.getNome());
		stm.setDouble(2, funcionario.getSalario());

		// Executar o comando SQL
		stm.executeUpdate();
	}

	public List<Funcionario> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from funcionario");

		ResultSet result = stm.executeQuery();
		List<Funcionario> lista = new ArrayList<Funcionario>();

		while (result.next()) {
			Funcionario funcionario = parse(result);
			lista.add(funcionario);
		}

		return lista;
	}

	private Funcionario parse(ResultSet result) throws SQLException {

		String nome = result.getString("nome");
		double salario = result.getDouble("salario");

		Funcionario funcionario = new Funcionario(nome, salario);

		return funcionario;
	}
	
	
	public void remover(String nome) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("delete from funcionario where nome = ?");
		// Setar os parametros na Query
		stm.setString(1, nome);
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Nome não encontrado para remoção");
	}

	public void atualizar(Funcionario funcionario) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("update funcionario set salario = ? where nome = ?");
		// Setar os parametros na Query
		stm.setDouble(1, funcionario.getSalario());
		//stm.setDouble(1, 700);
		stm.setString(2, funcionario.getNome());
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Nome não encontrado para atualizar");
	}

	

}