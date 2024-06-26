package br.com.fabricaroupa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fabricaroupa.model.Calca;


public class CalcaDAO {
	
	private Connection con;

	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public CalcaDAO() {
	}
	public CalcaDAO(Connection con) {
		setCon(con);
	}
	
	
	public String inserirCalca(Calca calca) {
		String sql = "insert into calca(peso, tipotecido, tipo) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			
			ps.setDouble(1, calca.getPeso());
			ps.setString(2,  calca.getTipoTecido());
			ps.setString(3, calca.getTipo());
			
			if (ps.executeUpdate() > 0) {
				return "Calca iserida com sucesso.";
			} else {
				return "Erro ao inserir  calca.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	
	public String deletarSemWhereCalca() {
		String sql = "delete from calca";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
					
			if (ps.executeUpdate() > 0) {
				return "Calca deletado com sucesso.";
			} else {
				return "Erro ao deletar a calca.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String deletarComWhereCalca(Calca calca) {
		String sql = "delete from calca where tipotecido like (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			
			ps.setString(1, calca.getTipoTecido());
			
			if (ps.executeUpdate() > 0) {
				return "Calca deletado com sucesso.";
			} else {
				return "Erro ao deletar a calca.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	
	public String alterarTipoTecido(Calca calca) {
		String sql = "update calca set tipotecido = (?) where tipo = (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			
			ps.setString(1, calca.getTipoTecido());
			ps.setString(2, calca.getTipo());
			
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	
	//Método selecionar
			public ArrayList<Calca> retornarDadosCalca(){
				String sql = "select * from calca";
				ArrayList<Calca> retornarDadosCalca = new ArrayList<Calca>();
				try {
					PreparedStatement ps = getCon().prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					if(rs != null) {
						while(rs.next()) {
							Calca calca = new Calca();
							calca.setPeso(rs.getDouble(1));
							calca.setTipoTecido(rs.getString(2));
							calca.setTipo(rs.getString(3));
							
							retornarDadosCalca.add(calca);
						} return retornarDadosCalca;
					} else {
						return null;
					}
				} catch(SQLException e) {
					return null;
				}
			}
}
