package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;

import modelo.InfoViagem;
import controle.Conexao;

public class ViagemDAO implements IViagemDAO {
	
	
	private static ViagemDAO instacia;
	
	public ViagemDAO() {};
	
	public static ViagemDAO getInstancia() {
		if (instacia == null) {
			instacia = new ViagemDAO();
		}
		return instacia;
	}
	
	// Aplicar singleton depois

	public int inserirViagem(InfoViagem via) {
		
		String SQL = "INSERT INTO viagens (nome, email, telefone, destino, dataInicio, dataTermino, atividades, orcamento, doc) VALUES (?,?,?,?,?,?,?,?,?)";

		Conexao con = Conexao.getInstacia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			LocalDate dataInicio = via.getDataInicio();
			java.sql.Date sqlDataI = java.sql.Date.valueOf(dataInicio);
			
			LocalDate dataTermino = via.getDataInicio();
			java.sql.Date sqlDataT = java.sql.Date.valueOf(dataTermino);
			
			double orcamentoD = via.getOrcaomento();
			int orcamentoI = (int) orcamentoD;
			
			ps.setString(1, via.getNome());
			ps.setString(2, via.getEmial());
			ps.setString(3, via.getTelefone());
			ps.setString(4, via.getDestino());
			ps.setDate(5, sqlDataI);
			ps.setDate(6, sqlDataT);
			ps.setString(7, via.getAtividades());
			ps.setInt(8, orcamentoI);
			ps.setString(9, via.getDoc());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return 0;
	}
	
	@Override
	public ArrayList<InfoViagem> listarViagens() {
		//ArrayList para armazenar resultado do select
				ArrayList<InfoViagem> viagens = new ArrayList<InfoViagem>();
				
				//Comando SQL a ser executado
				String SQL = "SELECT * FROM viagens";
				
				//Cria a "ponta de conexao" com MYSQL
				Conexao con = Conexao.getInstacia();
				Connection conBD = con.conectar();
				
				try {
					PreparedStatement ps = conBD.prepareStatement(SQL);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						//Criar objeto
						InfoViagem end = new InfoViagem();
						
						//Pega os valores de cada coluna do registro
						String nome = rs.getString("nome");
						String email = rs.getString("email");
						String telefone = rs.getString("telefone");
						String destino = rs.getString("destino");
						LocalDate dataInicio = rs.getDate("dataInicio").toLocalDate(); // mysql = date ou datetime NÃƒO USAR
						LocalDate dataTermino = rs.getDate("dataTermino").toLocalDate();
						String atividades = rs.getString("atividades");
						Double orcamento = rs.getDouble("orcamento");
						String doc = rs.getString("doc");
						
						//localdate ==> mais indicado para utilizar
						//LocalTime
						//LocalDateTime

						
						//Seta os valores no obj java
						end.setNome(nome);
						end.setEmial(email);
						end.setTelefone(telefone);
						end.setDestino(destino);
						end.setDataInicio(dataInicio);
						end.setDataTermino(dataTermino);
						end.setAtividades(atividades);
						end.setOrcaomento(orcamento);
						end.setDoc(doc);
						
						//Adiciona obj no arraylist
						viagens.add(end);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					con.fecharConexao();
				}
				
				// TODO Auto-generated method stub
				return viagens;
	}

	@Override
	public boolean atualizarViagens(InfoViagem via) {
		String SQL = "UPDATE viagens SET nome=?, email=?, telefone=?, destino=?, dataInicio=?, dataTermino=?, atividades=?, orcamento=?, doc=?";

		Conexao con = Conexao.getInstacia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			LocalDate dataInicio = via.getDataInicio();
			java.sql.Date sqlDataI = java.sql.Date.valueOf(dataInicio);
			
			LocalDate dataTermino = via.getDataInicio();
			java.sql.Date sqlDataT = java.sql.Date.valueOf(dataTermino);
			
			double orcamentoD = via.getOrcaomento();
			int orcamentoI = (int) orcamentoD;
			
			ps.setString(1, via.getNome());
			ps.setString(2, via.getEmial());
			ps.setString(3, via.getTelefone());
			ps.setString(4, via.getDestino());
			ps.setDate(5, sqlDataI);
			ps.setDate(6, sqlDataT);
			ps.setString(7, via.getAtividades());
			ps.setInt(8, orcamentoI);
			ps.setString(9, via.getDoc());
			
			int rowUpdate = ps.executeUpdate();
			
			if (rowUpdate > 0) {
				return true;
			} else {
				return false;
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		return false;
	}

	@Override
	public boolean removerViagens(InfoViagem via) {
		String SQL = "SELECT * FROM viagens WHERE id_viagem = ?";
		
		Conexao con = Conexao.getInstacia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			
			ps.setInt(1, via.getId());
			
			int rowsAffected = ps.executeUpdate();
			
			if (rowsAffected > 0) {
				con.fecharConexao();
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return false;
	}

}
