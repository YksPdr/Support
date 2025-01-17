package br.com.sobrinho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.sobrinho.model.ClientePFSobrinho;

public class ClientePFSobrinhoDAO {
	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public ClientePFSobrinhoDAO(Connection con) {
		setCon(con);
	}
	
	public String inserir(ClientePFSobrinho clientePF) {
		String sql = "insert into ClientePFSobrinho(cpf, nome, endereco, nomeAgencia, nomeGerente) values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, clientePF.getCpfSobrinho());
			ps.setString(2, clientePF.getNomeSobrinho());
			ps.setString(3, clientePF.getEnderecoSobrinho());
			ps.setString(4, clientePF.getNomeAgenciaSobrinho());
			ps.setString(5, clientePF.getNomeGerenteSobrinho());
			
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
		String sql = "delete from ClientePFSobrinho";
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
	
	public String alterar(ClientePFSobrinho clientePFSobrinho) {
		String sql = "update clientePF set cpfSobrinho = (?), nomeSobrinho = (?), enderecoSobrinho = (?), , nomeGerenteSobrinho = (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			
			ps.setInt(1, clientePFSobrinho.getCpfSobrinho());
			ps.setString(2, clientePFSobrinho.getNomeSobrinho());
			ps.setString(3, clientePFSobrinho.getEnderecoSobrinho());
			ps.setString(4, clientePFSobrinho.getNomeAgenciaSobrinho());
			ps.setString(5, clientePFSobrinho.getNomeGerenteSobrinho());
			
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<ClientePFSobrinho> retornarDadosCliente(){
		String sql = "select * from clientePF";
		ArrayList<ClientePFSobrinho> retornarDadosClientePF = new ArrayList<ClientePFSobrinho>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					
					ClientePFSobrinho clientePFSobrinho = new ClientePFSobrinho();
					clientePFSobrinho.setCpfSobrinho(rs.getInt(1));;
					clientePFSobrinho.setNomeSobrinho(rs.getString(2));
					clientePFSobrinho.setEnderecoSobrinho(rs.getString(3));;
					clientePFSobrinho.setNomeAgenciaSobrinho(rs.getString(4));
					clientePFSobrinho.setNomeGerenteSobrinho(rs.getString(5));
					
					retornarDadosClientePF.add(clientePFSobrinho);
				} return retornarDadosClientePF;
			} else {
				return null;
			}
		} catch(SQLException e) {
			return null;
		}
	}
}