package visao;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.ViagemDAO;
import modelo.InfoViagem;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class EdicaoViagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JFormattedTextField txtTelefone;
	private JTextField txtDestino;
	private JTextField txtDataInicio;
	private JTextField txtDataTermino;
	private JTextField txtAtividades;
	private JTextField txtOrcamento;
	private JTextField txtDoc;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public EdicaoViagem(final InfoViagem viagemSelecionada, final ListViagens janela) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][grow][grow][][][grow][grow][][grow][grow][grow][grow][grow][][][][][][][][][grow]", "[][][][][][][][][][][][][][][][][grow][][][][grow][][][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(EdicaoViagem.class.getResource("/imgs/Logo100.png")));
		contentPane.add(lblNewLabel_1, "flowx,cell 1 0 4 3,alignx right");
		
		JLabel lblNewLabel_2 = new JLabel("Nome do viajante:");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_2, "cell 4 4");
		
		txtNome = new JTextField();
		txtNome.setText(viagemSelecionada.getNome());
		contentPane.add(txtNome, "cell 5 4 12 1,growx");
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email do viajante:");
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_6, "cell 4 5");
		
		txtEmail = new JTextField();
		txtEmail.setText(viagemSelecionada.getEmial());
		txtEmail.setColumns(10);
		contentPane.add(txtEmail, "cell 5 5 12 1,growx");
		
		JLabel lblNewLabel_7 = new JLabel("Telefone de contato:");
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_7, "cell 4 6");
		
		try {
            MaskFormatter mask = new MaskFormatter("(##) #####-####");
            txtTelefone = new JFormattedTextField(mask);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		txtTelefone.setText(String.valueOf(viagemSelecionada.getTelefone()));
		contentPane.add(txtTelefone, "cell 5 6 5 1,growx");
		txtTelefone.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Destino da viagem:");
		lblNewLabel_8.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_8, "cell 10 6");
		
		txtDestino = new JTextField();
		txtDestino.setText(viagemSelecionada.getDestino());
		contentPane.add(txtDestino, "cell 11 6 6 1,growx");
		txtDestino.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Data de início:");
		contentPane.add(lblNewLabel_9, "cell 4 7");
		
		txtDataInicio = new JTextField();
		txtDataInicio.setText(String.valueOf(viagemSelecionada.getDataInicio()));
		contentPane.add(txtDataInicio, "cell 5 7 5 1,growx");
		txtDataInicio.setColumns(10);
		
		JLabel lblNewLabel_9_1 = new JLabel("Data de termino:");
		lblNewLabel_9_1.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_9_1, "cell 10 7");
		

		txtDataTermino = new JTextField();
		txtDataTermino.setText(String.valueOf(viagemSelecionada.getDataTermino()));
		contentPane.add(txtDataTermino, "cell 11 7 6 1,growx");
		txtDataTermino.setColumns(10);
		
		JLabel lblNewLabel_9_2_2 = new JLabel("Orçamento da viagem:");
		lblNewLabel_9_2_2.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_9_2_2, "cell 4 9,alignx left");
		
		txtOrcamento = new JTextField();
		txtOrcamento.setText(String.valueOf(viagemSelecionada.getOrcaomento()));
		txtOrcamento.setColumns(10);
		contentPane.add(txtOrcamento, "cell 5 9 5 1,growx");
		
		JLabel lblNewLabel_10_1 = new JLabel("CPF do viajante:");
		lblNewLabel_10_1.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_10_1, "cell 10 9");
		
		try {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            txtDoc = new JFormattedTextField(mask);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		txtDoc.setColumns(10);
		txtDoc.setText(String.valueOf(viagemSelecionada.getDoc()));
		contentPane.add(txtDoc, "cell 11 9 6 1,growx");
		
		JLabel lblNewLabel_9_2_1 = new JLabel("Atividades planejadas:");
		lblNewLabel_9_2_1.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_9_2_1, "cell 4 10");
		
		txtAtividades = new JTextField();
		txtAtividades.setText(viagemSelecionada.getAtividades());
		contentPane.add(txtAtividades, "cell 5 10 12 1,growx");
		txtAtividades.setColumns(10);
		
		Color borderColor = new Color(1, 50, 1); 
		int smallerRadius = 3;
		RoundedBorder roundedBorder = new RoundedBorder(smallerRadius, borderColor);

        
        txtNome.setBorder(roundedBorder);
        txtEmail.setBorder(roundedBorder);
        txtTelefone.setBorder(roundedBorder);
        txtDestino.setBorder(roundedBorder);
        txtDataInicio.setBorder(roundedBorder);
        txtDataTermino.setBorder(roundedBorder);
        txtAtividades.setBorder(roundedBorder);
        txtOrcamento.setBorder(roundedBorder);
        txtDoc.setBorder(roundedBorder);
        
		
		JButton btnLimpar = new JButton("Limpar campos");
		btnLimpar.setBorder(roundedBorder);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtTelefone.setText("");
				txtEmail.setText("");
				txtDestino.setText("");
				txtDataInicio.setText("");
				txtDataTermino.setText("");
				txtOrcamento.setText("");
				txtDoc.setText("");
				txtAtividades.setText("");

			}
		});
		btnLimpar.setForeground(new Color(255, 255, 245));
		btnLimpar.setBackground(new Color(1, 50, 1));
		btnLimpar.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(btnLimpar, "cell 4 12 6 1,alignx right");
		
		JButton btnEditarViagem = new JButton("Editar viagem");
		btnEditarViagem.setBorder(roundedBorder);
		btnEditarViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				if(nome.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Nome do viajante obrigatório!");
					return ;
				}
				viagemSelecionada.setNome(nome);

				String telefone = txtTelefone.getText();
				if(telefone.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Telefone de contato obrigatório!");
					return ;
				}
				viagemSelecionada.setTelefone(telefone);
				
				String email = txtEmail.getText();
				if(email.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Email do viajante obrigatório!");
					return ;

				}
				viagemSelecionada.setEmial(email);
				
				String destino = txtDestino.getText();
				if(destino.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Destino da viagem obrigatório!");
					return ;

				}
				viagemSelecionada.setDestino(destino);
				
				String dataInicio = txtDataInicio.getText();
				LocalDate dInicio = LocalDate.parse(dataInicio);
				if(dInicio.isBefore(dInicio)) {
					JOptionPane.showMessageDialog(null, "Data de inicio inválida!");
					return ;
				}
				viagemSelecionada.setDataInicio(dInicio);
				
				String dataTermino = txtDataTermino.getText();
				LocalDate dTermino = LocalDate.parse(dataTermino);
				if(dTermino.isBefore(dInicio)) {
					JOptionPane.showMessageDialog(null, "Data de termino inválida!");
					return ;

				}
				viagemSelecionada.setDataInicio(dTermino);
				
				String atividades = txtAtividades.getText();
				if(atividades.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Atividades planejadas obrigatório!");
					return ;

				}
				viagemSelecionada.setAtividades(atividades);
				
				String orcamento = txtOrcamento.getText();
				Double orcamentoDouble= 00.00;
				try {
					orcamentoDouble = Double.parseDouble(orcamento);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Orçamento invÃ¡lido. Digite apenas números!");
					return ;
					
				}
				viagemSelecionada.setOrcaomento(orcamentoDouble);
				
				String doc = txtDoc.getText();
				if(doc.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Documento do viajante obrigatório!");
					return ;

				}
				viagemSelecionada.setDoc(doc);
				
				ViagemDAO viagemDAO = ViagemDAO.getInstancia();
				
				int retorno = viagemDAO.atualizarViagens(viagemSelecionada);
				
				if (retorno == 0) {
					// mensagem erro
				} else {
					janela.atualizarDadosViagem(viagemSelecionada); // atualiza o dado da tabela
				}
				
				dispose();
			}
		});
		btnEditarViagem.setBackground(new Color(66, 142, 66));
		btnEditarViagem.setForeground(new Color(255, 255, 245));
		btnEditarViagem.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(btnEditarViagem, "cell 10 12");
		
		JLabel lblNewLabel = new JLabel("Caro funcionário");
		lblNewLabel.setForeground(new Color(1, 50, 1));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 40));
		contentPane.add(lblNewLabel, "cell 5 0 7 1");
		
		JLabel lblNewLabel_4 = new JLabel("Insira as informações da viagem:");
		lblNewLabel_4.setForeground(new Color(1, 50, 1));
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_4, "cell 5 1 10 1");
		
		JButton btnSair = new JButton("Cancelar edição");
		btnSair.setBorder(roundedBorder);
		btnSair.setForeground(new Color(255, 255, 245));
		btnSair.setBackground(new Color(1, 50, 1));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setFont(new Font("Calibri", Font.BOLD, 15));
		btnSair.setIcon(new ImageIcon(EdicaoViagem.class.getResource("/imgs/Vector.png")));
		contentPane.add(btnSair, "cell 11 13 6 1");
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
