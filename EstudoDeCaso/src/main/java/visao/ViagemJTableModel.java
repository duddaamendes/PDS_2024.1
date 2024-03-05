package visao;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.InfoViagem;

public class ViagemJTableModel extends AbstractTableModel{
	
	private ArrayList<InfoViagem> lista;
	private String[] colunas ={"Nome", "Destino"};

	public ViagemJTableModel(ArrayList<InfoViagem> lista) {
		this.lista=lista;
	}
	
	@Override
	public int getRowCount() {
		return this.lista.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	    InfoViagem v = lista.get(rowIndex);
	    switch (columnIndex) {
	        case 0:
	        	return v.getNome();
	        case 1:
	            return v.getDestino();
	        default:
	            return null;
	    }
	}
	
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

}
