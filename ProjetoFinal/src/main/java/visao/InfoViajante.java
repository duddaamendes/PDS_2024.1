package visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import modelo.InfoViagem;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class InfoViajante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtDestino;
	private JTextField txtDataInicio;
	private JTextField txtDataTermino;
	private JTextField txtOrcamento;
	private JFormattedTextField txtDoc;
	private JTextField txtAtividade;


	public InfoViajante(InfoViagem viagemSelecionada, ListViagens janela) {
		setTitle("Informaçõeso da viagem selecionada");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 374);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	    setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][grow][][grow][grow][grow][grow][][][][grow][][grow][][][grow][grow][grow][][grow][grow][][][][][]", "[][][][][][][][][]"));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(InfoViajante.class.getResource("/imgs/Logo100.png")));
		contentPane.add(lblNewLabel_3, "cell 0 0 3 2");
		
		JLabel lblNewLabel_4 = new JLabel("Informações da viagem selecionada:");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 25));
		contentPane.add(lblNewLabel_4, "cell 3 1 13 1");
		
		JLabel lblNewLabel_2 = new JLabel("Nome do viajante:");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_2, "cell 2 2,alignx left");
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Calibri", Font.ITALIC, 11));
		txtNome.setEditable(false);
		contentPane.add(txtNome, "cell 3 2 23 1,growx");
		txtNome.setColumns(10);
		txtNome.setText(viagemSelecionada.getNome());
		
		JLabel lblNewLabel_1_1 = new JLabel("Email do viajante:");
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1_1, "cell 2 3");
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Calibri", Font.ITALIC, 11));
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		contentPane.add(txtEmail, "cell 3 3 23 1,growx");
		txtEmail.setText(viagemSelecionada.getEmial());
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Telefone de contato:");
		lblNewLabel_1_1_1.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1_1_1, "cell 2 4");
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Calibri", Font.ITALIC, 11));
		txtTelefone.setEditable(false);
		txtTelefone.setColumns(10);
		contentPane.add(txtTelefone, "cell 3 4 9 1,growx");
		txtTelefone.setText(String.valueOf(viagemSelecionada.getTelefone()));
		
		JLabel lblDestinoDaViagem = new JLabel("Destino da viagem:");
		lblDestinoDaViagem.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblDestinoDaViagem, "cell 12 4");
		
		txtDestino = new JTextField();
		txtDestino.setFont(new Font("Calibri", Font.ITALIC, 11));
		txtDestino.setEditable(false);
		txtDestino.setColumns(10);
		contentPane.add(txtDestino, "cell 13 4 13 1,growx");
		txtDestino.setText(viagemSelecionada.getDestino());
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Data de inicio:");
		lblNewLabel_1_1_1_1.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1_1_1_1, "cell 2 5");
		
		txtDataInicio = new JTextField();
		txtDataInicio.setFont(new Font("Calibri", Font.ITALIC, 11));
		txtDataInicio.setEditable(false);
		txtDataInicio.setColumns(10);
		txtDataInicio.setText(viagemSelecionada.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		contentPane.add(txtDataInicio, "cell 3 5 9 1,growx");
		
		JLabel lblDataDeTermino = new JLabel("Data de termino:");
		lblDataDeTermino.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblDataDeTermino, "cell 12 5");
		
		txtDataTermino = new JTextField();
		txtDataTermino.setFont(new Font("Calibri", Font.ITALIC, 11));
		txtDataTermino.setEditable(false);
		txtDataTermino.setColumns(10);
		txtDataTermino.setText(viagemSelecionada.getDataTermino().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		contentPane.add(txtDataTermino, "cell 13 5 13 1,growx");
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Orçamento de viagem:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1_1_1_1_1_1, "cell 2 6");
		
		txtOrcamento = new JTextField();
		txtOrcamento.setFont(new Font("Calibri", Font.ITALIC, 11));
		txtOrcamento.setEditable(false);
		txtOrcamento.setColumns(10);
		txtOrcamento.setText(String.valueOf(viagemSelecionada.getOrcaomento()));
		contentPane.add(txtOrcamento, "cell 3 6 9 1,growx");
		
		double orcamento = viagemSelecionada.getOrcaomento();
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String orcamentoFormatado = formatoMoeda.format(orcamento);
        txtOrcamento.setText(orcamentoFormatado);
		
		JLabel lblDocumentoDoViajante = new JLabel("CPF do viajante:");
		lblDocumentoDoViajante.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblDocumentoDoViajante, "cell 12 6");
		
		txtDoc = new JFormattedTextField();
		txtDoc.setFont(new Font("Calibri", Font.ITALIC, 11));
		txtDoc.setEditable(false);
		txtDoc.setColumns(10);
		txtDoc.setText(String.valueOf(viagemSelecionada.getDoc()));
		contentPane.add(txtDoc, "cell 13 6 13 1,growx");
	
		
		JLabel lblNewLabel_2_1 = new JLabel("Atividades planejadas:");
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_2_1, "cell 2 7");
		
		txtAtividade = new JTextField();
		txtAtividade.setFont(new Font("Calibri", Font.ITALIC, 11));
		txtAtividade.setEditable(false);
		txtAtividade.setColumns(10);
		txtAtividade.setText(viagemSelecionada.getAtividades());
		contentPane.add(txtAtividade, "cell 3 7 23 1,growx");
		
		JButton btnNewButton = new JButton("Voltar para listagem de viagens");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 245));
		btnNewButton.setBackground(new Color(1, 50, 1));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnNewButton, "cell 0 8 29 1,alignx center,aligny center");
		
		Color borderColor = new Color(1, 50, 1); 
		int smallerRadius = 3;
		RoundedBorder roundedBorder = new RoundedBorder(smallerRadius, borderColor);
		
		txtNome.setBorder(roundedBorder);
        txtEmail.setBorder(roundedBorder);
        txtTelefone.setBorder(roundedBorder);
        txtDestino.setBorder(roundedBorder);
        txtDataInicio.setBorder(roundedBorder);
        txtDataTermino.setBorder(roundedBorder);
        txtAtividade.setBorder(roundedBorder);
        txtOrcamento.setBorder(roundedBorder);
        txtDoc.setBorder(roundedBorder);
	}
	
	static class RoundedBorder extends AbstractBorder {
        private final int radius;
        private final Color color;

        public RoundedBorder(int radius, Color color) {
            this.radius = radius;
            this.color = color;
        }

        @Override
        public void paintBorder(
                java.awt.Component c,
                Graphics g,
                int x, int y, int width, int height
        ) {
            super.paintBorder(c, g, x, y, width, height);
            Color oldColor = g.getColor();
            g.setColor(color);
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            g.setColor(oldColor);
        }

        @Override
        public Insets getBorderInsets(java.awt.Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        @Override
        public Insets getBorderInsets(java.awt.Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = this.radius + 1;
            return insets;
        }
    }

}
