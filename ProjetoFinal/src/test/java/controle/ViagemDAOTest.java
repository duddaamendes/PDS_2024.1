package controle;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import modelo.InfoViagem;

public class ViagemDAOTest {
	
	@Test
	public void testInserir() {
		InfoViagem vg = new InfoViagem();
		ViagemDAO dao = new ViagemDAO();
		
		LocalDate di = LocalDate.parse("2023-10-14");
		LocalDate dt = LocalDate.parse("2023-10-24");
		
		vg.setId(11);
		vg.setNome("maria eduarda");
		vg.setEmial("maria@gmail.com");
		vg.setTelefone("(47) 98810-8919");
		vg.setDestino("brasil");
		vg.setDataInicio(di);
		vg.setDataTermino(dt);
		vg.setAtividades("jogar");
		vg.setOrcaomento(344d);
		vg.setDoc("091.719.689-97");
		
		int insert = dao.inserirViagem(vg);
		assertEquals(1, insert);
	}
	
	@Test
	public void testListar() {
		ViagemDAO dao = new ViagemDAO();
		ArrayList<InfoViagem> viagens = dao.listarViagens();
		assertNotNull(viagens);
		assertTrue(viagens.size()>0);
	}
	
	@Test
	public void testAtualizar() {
		ViagemDAO dao = new ViagemDAO();
		ArrayList<InfoViagem> viagens = dao.listarViagens();
		
		if (!viagens.isEmpty()) {
			//escolher uma viagem pra atualizar
			InfoViagem viagemA = viagens.get((int) (Math.random() * viagens.size()));
			
			//atualizar
			viagemA.setNome("Novo Nome");
			
			int update = dao.atualizarViagens(viagemA);
			assertEquals(1, update);
		}
		
	}
	
	@Test
	public void testExcluir() {
		ViagemDAO dao = new ViagemDAO();
		ArrayList<InfoViagem> viagens = dao.listarViagens();
		
		if (!viagens.isEmpty()) {
			//escolher uma viagem pra excluir
			InfoViagem viagemE = viagens.get((int) (Math.random() * viagens.size()));
			
			
			boolean delete = dao.removerViagens(viagemE);
			assertTrue(delete);
		}
		
	}

}
