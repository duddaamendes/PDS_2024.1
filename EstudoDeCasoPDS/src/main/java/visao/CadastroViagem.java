package visao;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;


import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.time.LocalDate;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import controle.ViagemDAO;
import modelo.InfoViagem;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.text.ParseException;

public class CadastroViagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JFormattedTextField txtTelefone;
	private JTextField txtDestino;
	private JFormattedTextField txtDataInicio;
	private JFormattedTextField txtDataTermino;
	private JTextField txtAtividades;
	private JTextField txtOrcamento;
	private JTextField txtDoc;

	public CadastroViagem(final ListViagens list) {
		setBackground(new Color(255, 255, 245));
		setTitle("Cadastro de viagem");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 635, 408);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][grow][grow][][][grow][grow][][grow][grow][grow][grow][grow][grow][][][][][][][][][grow]", "[][][][][][][][][][][][][][][][][grow][][][][grow][][][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CadastroViagem.class.getResource("/imgs/Logo100.png")));
		contentPane.add(lblNewLabel_1, "flowx,cell 1 0 4 3,alignx right");
		
		
		JLabel lblNewLabel_2 = new JLabel("Nome do viajante:");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_2, "cell 4 4");
		
		txtNome = new JTextField();
		contentPane.add(txtNome, "cell 5 4 17 1,growx");
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email do viajante:");
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_6, "cell 4 5");
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		contentPane.add(txtEmail, "cell 5 5 17 1,growx");
		
		JLabel lblNewLabel_7 = new JLabel("Telefone de contato:");
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_7, "cell 4 6");
		
		try {
            MaskFormatter mask = new MaskFormatter("(##) #####-####");
            txtTelefone = new JFormattedTextField(mask);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		contentPane.add(txtTelefone, "cell 5 6 5 1,growx");
		txtTelefone.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Destino da viagem:");
		lblNewLabel_8.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_8, "cell 10 6");
		
		txtDestino = new JTextField();
		contentPane.add(txtDestino, "cell 11 6 11 1,growx");
		txtDestino.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Data de início:");
		lblNewLabel_9.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_9, "cell 4 7");
		
		try {
            MaskFormatter mask = new MaskFormatter("####-##-##");
            txtDataInicio = new JFormattedTextField(mask);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		contentPane.add(txtDataInicio, "cell 5 7 5 1,growx");
		txtDataInicio.setColumns(10);
		
		JLabel lblNewLabel_9_1 = new JLabel("Data de termino:");
		lblNewLabel_9_1.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_9_1, "cell 10 7");
		
		try {
            MaskFormatter mask = new MaskFormatter("####-##-##");
            txtDataTermino = new JFormattedTextField(mask);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		contentPane.add(txtDataTermino, "cell 11 7 11 1,growx");
		txtDataTermino.setColumns(10);

		
		JLabel lblNewLabel_7_1 = new JLabel("Orçamento da viagem:");
		lblNewLabel_7_1.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_7_1, "cell 4 9,alignx left");
		
		txtOrcamento = new JTextField();
		txtOrcamento.setColumns(10);
		contentPane.add(txtOrcamento, "cell 5 9 5 1,growx");
		
		JLabel lblNewLabel_8_1 = new JLabel("CPF do viajante:");
		lblNewLabel_8_1.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_8_1, "cell 10 9");
		
		try {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            txtDoc = new JFormattedTextField(mask);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		txtDoc.setColumns(10);
		contentPane.add(txtDoc, "cell 11 9 11 1,growx");
		
		JLabel lblNewLabel_9_2_1 = new JLabel("Atividades planejadas:");
		lblNewLabel_9_2_1.setFont(new Font("Calibri", Font.BOLD, 12));
		contentPane.add(lblNewLabel_9_2_1, "cell 4 10");
		
		txtAtividades = new JTextField();
		contentPane.add(txtAtividades, "cell 5 10 17 1,growx");
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
		btnLimpar.setForeground(new Color(255, 255, 245));
		btnLimpar.setBackground(new Color(1, 50, 1));
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
		btnLimpar.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(btnLimpar, "cell 4 12 6 1,alignx right");
		
		JButton btnCadastrarViagem = new JButton("Cadastrar viagem");
		btnCadastrarViagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				if(nome.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Nome do viajante obrigatório!");
					return ;

				}
				
				String telefone = txtTelefone.getText();
				if(telefone.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Telefone de contato obrigatório!");
					return ;

				}
				
				String email = txtEmail.getText();
				if(email.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Email do viajante obrigatório!");
					return ;

				}
				
				String destino = txtDestino.getText();
				if(destino.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Destino da viagem obrigatório!");
					return ;

				}
				
				String dataInicio = txtDataInicio.getText();
				LocalDate dInicio;
				try {
					dInicio = LocalDate.parse(dataInicio);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Data de inicio inválida!");
					return ;
					
				}
				if (dInicio==null) {
					JOptionPane.showMessageDialog(null, "Data de inicio inválida!");
					return ;
				}
				
				
				String dataTermino = txtDataTermino.getText();
				LocalDate dTermino;
				try {
					dTermino = LocalDate.parse(dataTermino);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Data de termino inválida!");
					return ;
					
				}
				if (dTermino==null) {
					JOptionPane.showMessageDialog(null, "Data de termino inválida!");
					return ;
				}
				if(dTermino.isBefore(dInicio)) {
					JOptionPane.showMessageDialog(null, "Data de termino inválida!");
					return ;

				}
				
				
				String atividades = txtAtividades.getText();
				if(atividades.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo Atividades obrigatório!");
					return ;

				}
				
				String orcamento = txtOrcamento.getText();
				Double orcamentoDouble= 00.00;
				try {
					orcamentoDouble = Double.valueOf(orcamento);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Orçamento inválido. Digite apenas números!");
					return ;
					
				}
				
				String doc = txtDoc.getText();
				if(doc.length() == 0) {
					JOptionPane.showMessageDialog(null, "Campo CPF do viajante obrigatório!");
					return ;
				}
				
				InfoViagem v = new InfoViagem();
				v.setNome(nome);
				v.setEmial(email);
				v.setTelefone(telefone);
				v.setDestino(destino);
				v.setDataInicio(dInicio);
				v.setDataTermino(dTermino);
				v.setAtividades(atividades);
				v.setOrcaomento(orcamentoDouble);
				v.setDoc(doc);
				
				ViagemDAO dao = new ViagemDAO();
				int retorno = dao.inserirViagem(v);
				
				if(retorno == 0) {
					// Janela de erro
				} else {
					// Janela de sucesso
				}
				
				list.cadastrarViagem(v);
				dispose();
			}

		});
		btnCadastrarViagem.setBackground(new Color(66, 142, 66));
		btnCadastrarViagem.setForeground(new Color(255, 255, 245));
		btnCadastrarViagem.setFont(new Font("Calibri", Font.BOLD, 15));
		contentPane.add(btnCadastrarViagem, "cell 10 12 2 1");
		
		JLabel lblNewLabel = new JLabel("Caro funcionário");
		lblNewLabel.setForeground(new Color(1, 50, 1));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 40));
		contentPane.add(lblNewLabel, "cell 5 0 6 1");
		
		JLabel lblNewLabel_4 = new JLabel("Insira as informações da viagem:");
		lblNewLabel_4.setForeground(new Color(1, 50, 1));
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_4, "cell 5 1 11 1");
		
		JButton btnSair = new JButton("Cancelar cadastro");
		btnSair.setForeground(new Color(255, 255, 245));
		btnSair.setBackground(new Color(1, 50, 1));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setFont(new Font("Calibri", Font.BOLD, 15));
		btnSair.setIcon(new ImageIcon(CadastroViagem.class.getResource("/imgs/Vector.png")));
		contentPane.add(btnSair, "cell 11 13 11 1");
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
