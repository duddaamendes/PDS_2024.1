package controle;

import java.util.ArrayList;

import modelo.InfoViagem;

public interface IViagemDAO {

	public int inserirViagem(InfoViagem via);

	public ArrayList<InfoViagem> listarViagens();

	public boolean atualizarViagens(InfoViagem via);

	public boolean removerViagens(InfoViagem via);


}
