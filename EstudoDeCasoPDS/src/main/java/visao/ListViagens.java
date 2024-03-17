package visao;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.ViagemDAO;
import modelo.InfoViagem;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ListViagens extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	ViagemDAO viagemDAO = ViagemDAO.getInstancia();
	
	ArrayList <InfoViagem> listaViagens = viagemDAO.listarViagens();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                ListViagens frame = new ListViagens();
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
	/**
	 * Create the frame.
	 */
	public ListViagens() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		Color borderColorB = new Color(1, 50, 1); 
		int smallerRadiusB = 5;
		RoundedBorder roundedBorderButtons= new RoundedBorder(smallerRadiusB, borderColorB);

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][grow][][][][][][][][]", "[][][][grow][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon());
		contentPane.add(lblNewLabel, "flowx,cell 0 0 5 3,alignx right");
		
		JLabel label = new JLabel("Viagens cadastradas:");
		label.setForeground(new Color(1, 50, 1));
		label.setFont(new Font("Calibri", Font.BOLD, 40));
		contentPane.add(label, "cell 5 1 4 2");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 3 12 7,grow");
		
		table = new JTable();
		atualizarJTableModel();
		final ListViagens estaJanela = this;
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = table.getSelectedRow();
				InfoViagem viagemSelecionada = listaViagens.get(linha);
				
				InfoViajante janelaAlterar = new InfoViajante (viagemSelecionada,estaJanela);
				janelaAlterar.setVisible(true);
				
			}
		});
		scrollPane.setViewportView(table);
		
		Color borderColor = new Color(1, 50, 1); 
		int smallerRadius = 3;
		RoundedBorder roundedBorder = new RoundedBorder(smallerRadius, borderColor);
		final ListViagens janela = this;
		
		
		
		JButton btnSair = new JButton("Sair da tela");
		btnSair.setForeground(new Color(255, 255, 245));
		btnSair.setBackground(new Color(1, 50, 1));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setFont(new Font("Calibri", Font.BOLD, 15));
		btnSair.setIcon(new ImageIcon(EdicaoViagem.class.getResource("/imgs/Vector.png")));
		contentPane.add(btnSair, "cell 9 11 3 1");
		
		JButton btnEditar = new JButton("Editar viagem");
		final ListViagens estaJanela1 = this;
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = table.getSelectedRow();
				if (linha<0) {
					JOptionPane.showMessageDialog(null, "Você deve selecionar uma viagem para realizar a edição");
					return ;
				}
				
				InfoViagem viagemSelecionada = listaViagens.get(linha);
				EdicaoViagem janelaAlterar = new EdicaoViagem(viagemSelecionada, estaJanela1);
				janelaAlterar.setVisible(true);
				atualizarJTableModel();
			}		
		});
		btnEditar.setBackground(new Color(66, 142, 66));
		btnEditar.setForeground(new Color(255, 255, 245));
		btnEditar.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(btnEditar, "cell 8 10");
		
		JButton btnCadastrar = new JButton("Cadastrar uma nova viagem");
		btnCadastrar.setBorder(roundedBorderButtons);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroViagem janelaCadastrar = new CadastroViagem(janela);
				janelaCadastrar.setVisible(true);
			}
		});
		btnCadastrar.setForeground(new Color(255, 255, 245));
		btnCadastrar.setBackground(new Color(1, 50, 1));
		btnCadastrar.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(btnCadastrar, "cell 7 10");
		
		JButton btnExcluir = new JButton("Excluir viagem");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = table.getSelectedRow();
				if(linha < 0) {
					JOptionPane.showMessageDialog(null, "Selecione a pessoa para excluir!");
					return;
				}
				
				InfoViagem viagemSelecionada = listaViagens.get(linha);
				
				ViagemDAO dao = ViagemDAO.getInstancia();
				boolean foi = dao.removerViagens(viagemSelecionada);
				
				if (foi) {
					listaViagens.remove(linha);
					atualizarJTableModel();
				} else {
					//não foi
				}
				
			}
		});
		btnExcluir.setBackground(new Color(66, 142, 66));
		btnExcluir.setForeground(new Color(255, 255, 245));
		btnExcluir.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(btnExcluir, "cell 6 10,alignx right");

	}
	
	protected void atualizarJTableModel() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "Destino" });

		ViagemDAO viaDAO = ViagemDAO.getInstancia();
		listaViagens = viaDAO.listarViagens();

		for (int i = 0; i < listaViagens.size(); i++) {
			InfoViagem v = listaViagens.get(i);
			modelo.addRow(new Object[] { v.getId(), v.getNome(), v.getDestino() });
		}

		table.setModel(modelo);
		
	}
	
	static class RoundedBorder extends AbstractBorder {
		private final int radius;
	    private final Color color;

	    public RoundedBorder(int radius, Color color) {
	        this.radius = radius;
	        this.color = color;
	    }

	    @Override
	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        Color oldColor = g.getColor();
	        g.setColor(color);
	        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
	        g.setColor(oldColor);
	    }

	    @Override
	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
	    }

	    @Override
	    public boolean isBorderOpaque() {
	        return true;
	    }
    }
}
