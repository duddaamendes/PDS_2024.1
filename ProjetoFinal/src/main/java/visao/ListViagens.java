package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.aspose.pdf.Document;
import com.aspose.pdf.Image;
import com.aspose.pdf.TextFragment;

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
import java.io.FileInputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
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

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][grow][][][][][][][][]", "[][][][grow][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\acer aspire 5\\OneDrive\\Área de Trabalho\\IFSC materias\\PDS\\PDS_2024.1\\ProjetoFinal\\src\\main\\resources\\imgs\\Logo100.png"));
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
		btnSair.setIcon(new ImageIcon("C:\\Users\\acer aspire 5\\OneDrive\\Área de Trabalho\\IFSC materias\\PDS\\PDS_2024.1\\ProjetoFinal\\src\\main\\resources\\imgs\\Vector.png"));
		contentPane.add(btnSair, "cell 9 11 3 1");
		
		JButton btnPdf = new JButton("Gerar PDF");
		btnPdf.setForeground(new Color(255, 255, 245));
		btnPdf.setBackground(new Color(1, 50, 1));
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = table.getSelectedRow();
				InfoViagem viagemSelecionada = listaViagens.get(linha);
				if (linha>=0) {
					gerarPDF(viagemSelecionada);
				} else {
					JOptionPane.showMessageDialog(null, "Você deve selecionar uma viagem para realizar a edição");
					return ;
				}
			}
		});
		btnPdf.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(btnPdf, "cell 1 11 5 1");
		
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
				
				viagemDAO.removerViagens(viagemSelecionada);

				listaViagens.remove(linha);
				atualizarJTableModel();
				
			}
		});
		btnExcluir.setBackground(new Color(66, 142, 66));
		btnExcluir.setForeground(new Color(255, 255, 245));
		btnExcluir.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(btnExcluir, "cell 6 10,alignx right");

	}
	
	private void gerarPDF(InfoViagem vg) {
		//https://blog.aspose.com/pt/pdf/create-pdf-files-in-java/
		Document doc = new Document();
		
		com.aspose.pdf.Page pag = doc.getPages().add();
		
		String dataInicio = vg.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String dataTermino = vg.getDataTermino().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String orc = String.valueOf(vg.getOrcaomento());
		
        String caminhoImagem = "src\\main\\resources\\imgs\\LogoPdf.png"; 
        Image img = new Image();
        try (FileInputStream imageStream = new FileInputStream(caminhoImagem)) {
            img.setImageStream(imageStream);
        } catch (IOException e) {
            e.printStackTrace();
            return; 
        }
        
        pag.getParagraphs().add(img);
        pag.getParagraphs().add(new TextFragment (" "));
        pag.getParagraphs().add(new TextFragment (" "));
		pag.getParagraphs().add(new TextFragment ("Viagem: "));
		pag.getParagraphs().add(new TextFragment (" "));
		pag.getParagraphs().add(new TextFragment (" "));
		pag.getParagraphs().add(new TextFragment ("Nome: "+ vg.getNome()));
		pag.getParagraphs().add(new TextFragment (" "));
		pag.getParagraphs().add(new TextFragment ("Email: "+vg.getEmial()));
		pag.getParagraphs().add(new TextFragment (" "));
		pag.getParagraphs().add(new TextFragment ("Telefone: "+vg.getTelefone()));
		pag.getParagraphs().add(new TextFragment (" "));
		pag.getParagraphs().add(new TextFragment ("Destino: "+vg.getDestino()));
		pag.getParagraphs().add(new TextFragment (" "));
		pag.getParagraphs().add(new TextFragment ("Data de Inicio: "+ dataInicio));
		pag.getParagraphs().add(new TextFragment (" "));
		pag.getParagraphs().add(new TextFragment ("Data de Termino: "+ dataTermino));
		pag.getParagraphs().add(new TextFragment (" "));
		pag.getParagraphs().add(new TextFragment ("Atividades: "+vg.getAtividades()));
		pag.getParagraphs().add(new TextFragment (" "));
		pag.getParagraphs().add(new TextFragment ("Orçamento: "+orc));
		pag.getParagraphs().add(new TextFragment (" "));
		pag.getParagraphs().add(new TextFragment ("Documento: "+vg.getDoc()));
		pag.getParagraphs().add(new TextFragment (" "));
			
		doc.save("Viagem "+vg.getNome()+".pdf");
		
	}
	
	protected void atualizarJTableModel() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "Destino" });

		
		listaViagens = viagemDAO.listarViagens();

		for (int i = 0; i < listaViagens.size(); i++) {
			InfoViagem v = listaViagens.get(i);
			modelo.addRow(new Object[] { v.getId(), v.getNome(), v.getDestino() });
		}

		table.setModel(modelo);
		
	}
	
}
