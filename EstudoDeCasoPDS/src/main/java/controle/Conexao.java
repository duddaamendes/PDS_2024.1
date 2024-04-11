package controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	private static final String USERNAME = "root";
	private static final String SENHA = "Mendes123-Duda";
	private static final String BD = "BDV";
	private Connection con; //jdbc
	private static Conexao instancia; // singleton
	
	private Conexao () {} //construtor privado
	
	/**
	 * Metodo Singleton
	 * 
	 * @return
	 */
	public static Conexao getInstacia() {
		if (instancia == null) {
			instancia = new Conexao();
		}
		
		return instancia;
	}
	
	/**
	 *  Abre a conexao com o MySQL
	 *  
	 * @return
	 */
	
	public Connection conectar() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/"+ BD + "?serverTimezone=UTC", USERNAME, SENHA);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	/**
	 * Fecha a conexao com o MySQL
	 * 
	 * @return
	 */
	public boolean fecharConexao() {
		try {
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}

