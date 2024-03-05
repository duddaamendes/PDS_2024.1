package controle.endereco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String USERNAME = "root";
	private static final String SENHA = "Mendes123-Duda";
	private static final String BD = "SGT";
	private Connection con; //jdbc
	private static Conexao instancia; // singleton
	
	private Conexao () {} //construtor privado
	
	/**
	 * Método Singleton
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
