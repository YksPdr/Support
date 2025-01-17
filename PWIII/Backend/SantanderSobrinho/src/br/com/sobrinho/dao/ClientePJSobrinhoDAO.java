package br.com.sobrinho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.sobrinho.model.ClientePJSobrinho;

public class ClientePJSobrinhoDAO {
	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public ClientePJSobrinhoDAO(Connection con) {
		setCon(con);
	}
	
	public String inserir(ClientePJSobrinho clientePJ) {
		String sql = "insert into ClientePJSobrinho(cnpj, nome, endereco, nomeAgencia, nomeGerente) values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, clientePJ.getCnpjSobrinho());
			ps.setString(2, clientePJ.getNomeSobrinho());
			ps.setString(3, clientePJ.getEnderecoSobrinho());
			ps.setString(4, clientePJ.getNomeAgenciaSobrinho());
			ps.setString(5, clientePJ.getNomeGerenteSobrinho());
			
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String deletar() {
		String sql = "delete from ClientePJSobrinho";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
					
			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso.";
			} else {
				return "Erro ao deletar.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String alterar(ClientePJSobrinho clientePJ) {
		String sql = "update clientePJ set cnpjSobrinho = (?), nomeSobrinho = (?), enderecoSobrinho = (?), , nomeGerenteSobrinho = (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			
			ps.setInt(1, clientePJ.getCnpjSobrinho());
			ps.setString(2, clientePJ.getNomeSobrinho());
			ps.setString(3, clientePJ.getEnderecoSobrinho());
			ps.setString(4, clientePJ.getNomeAgenciaSobrinho());
			ps.setString(5, clientePJ.getNomeGerenteSobrinho());
			
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<ClientePJSobrinho> retornarDadosCliente(){
		String sql = "select * from clientePF";
		ArrayList<ClientePJSobrinho> retornarDadosClientePJ = new ArrayList<ClientePJSobrinho>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					
					ClientePJSobrinho clientePJ = new ClientePJSobrinho();
					clientePJ.setCnpjSobrinho(rs.getInt(1));;
					clientePJ.setNomeSobrinho(rs.getString(2));
					clientePJ.setEnderecoSobrinho(rs.getString(3));;
					clientePJ.setNomeAgenciaSobrinho(rs.getString(4));
					clientePJ.setNomeGerenteSobrinho(rs.getString(5));
					
					retornarDadosClientePJ.add(clientePJ);
				} return retornarDadosClientePJ;
			} else {
				return null;
			}
		} catch(SQLException e) {
			return null;
		}
	}
}