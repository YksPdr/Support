package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Endereco;


public class EnderecoDAO {

	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public EnderecoDAO(Connection con) {
		setCon(con);
	}

	public String inserir(Endereco endereco, int cpf) {
		String sql = "insert into endereco(cpf, cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cpf);
			ps.setString(2, endereco.getCep());
			ps.setString(3, endereco.getLogradouro());
			ps.setString(4,  endereco.getComplemento());
			ps.setString(5, endereco.getBairro());
			ps.setString(6, endereco.getLocalidade());
			ps.setString(7,  endereco.getUf());
			ps.setString(8, endereco.getIbge());
			ps.setString(9, endereco.getGia());
			ps.setString(10,  endereco.getDdd());
			ps.setString(11, endereco.getSiafi());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

}