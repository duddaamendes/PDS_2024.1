package controle.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import modelo.Endereco;

/**
 * DAO = Data access object objeto de acesso a dados
 * 
 * Serve para trocar dados com a tabela Endereco
 * 
 * @author Bruna
 *
 */
public class EnderecoDAO implements IEnderecoDAO {
	
	
	/*
	 * Váriavel para padrão Singleton
	 */
	private static EnderecoDAO instacia;
	
	/*
	 * Contrutor privado (padra Singleton)
	 */
	public EnderecoDAO() {};
	
	/*
	 * Método para instanciar (padrao Singleton)
	 */
	
	public static EnderecoDAO getInstancia() {
		if (instacia == null) {
			instacia = new EnderecoDAO();
		}
		return instacia;
	}
	
	// Aplicar singleton depois

	@Override
	public int inserirEndereco(Endereco end) {
		
		String SQL = "INSERT INTO endereco (cep, rua) VALUES (?,?)";
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Endereco> listarEnderecos() {
		
		//ArrayList para armazenar resultado do select
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		
		//Comando SQL a ser executado
		String SQL = "SELECT * FROM enderecos";
		
		//Cria a "ponta de conexao" com MYSQL
		Conexao con = Conexao.getInstacia();
		Connection conBD = con.conectar();
		
		try {
			PreparedStatement ps = conBD.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//Criar objeto
				Endereco end = new Endereco();
				
				//Pega os valores de cada coluna do registro
				String rua = rs.getString("rua");
				String cep = rs.getString("cep");
				
				Date dt = rs.getDate("data_nascimento"); // mysql = date ou datetime NÃO USAR
				
				//localdate ==> mais indicado para utilizar
				//LocalTime
				//LocalDateTime

				
				//Seta os valores no obj java
				end.setCep(cep);
				end.setRua(rua);
				
				//Adiciona obj no arraylist
				enderecos.add(end);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		
		// TODO Auto-generated method stub
		return enderecos;
	}

	@Override
	public boolean atualizarEndereco(Endereco end) {
		
		String SQL = "UPDATE endereco set cep = '?', rua = '?' WHERE id_usuarios = ?";
		
		
		//Cria a "ponta de conexao" com MYSQL
		Conexao con = Conexao.getInstacia();
		Connection conBD = con.conectar();
		
		try {
			Statement stmt = conBD.createStatement(); 
			
			int udateCount = stmt.executeUpdate(SQL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return (Boolean) null;
	}

	@Override
	public boolean removerEndereco(Endereco end) {
		String SQL = "DELETE FROM enderecos WHERE id_funcionario = ?";
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Endereco buscarEnderecoPorCep(int cep) {
		String SQL = "SELEC WHERE";
		
		//só vai retornar um endereco
		// TODO Auto-generated method stub
		return null;
	}

}
