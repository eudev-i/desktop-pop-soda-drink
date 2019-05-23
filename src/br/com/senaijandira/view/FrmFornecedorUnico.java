package br.com.senaijandira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.senaijandira.dao.FornecedorDAO;
import br.com.senaijandira.dao.MotoristaDAO;
import br.com.senaijandira.dao.ProdutoDAO;
import br.com.senaijandira.model.Fornecedor;
import br.com.senaijandira.model.Motorista;
import br.com.senaijandira.model.Produto;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;


public class FrmFornecedorUnico extends JFrame {

	private JPanel panelPrincipal;
	private JTextField txtRazaoSocial;
	private JTextField txtEmail;
	private JTextField txtID;
	private FrmFornecedor frmFornecedor;
	ProdutoDAO dao = new ProdutoDAO();
	private JTextField txtCNPJ;
	private JTextField txtNomeFantasia;
	private JTextField txtTelefone;
	private JComboBox cbStatus;
	private String id;

	// métodos para setar os valores dos txtfields
	public void setTxtID(int id) {
		this.txtID.setText(String.valueOf(id));

	}

	public void setTxtRazaoSocial(String nome) {
		this.txtRazaoSocial.setText(nome);
	}
	
	// métodos para setar os valores dos txtfields
	public void setTxtEmail(String email) {
		this.txtEmail.setText(email);

	}

	public void setTxtCNPJ(String cnpj) {
		this.txtCNPJ.setText(cnpj);
	}	
	
	public void setTxtNomeFantasia(String nome) {
		this.txtNomeFantasia.setText(nome);
	}	
	
	public void setTxtTelefone(String tel) {
		this.txtTelefone.setText(tel);
	}	
	
	public void setCbStatus(int status) {
		if (status == 1) {
			cbStatus.setSelectedIndex(0);

		} else {
			cbStatus.setSelectedIndex(1);
		}
	}	
	
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Create the frame.
	 */
	public FrmFornecedorUnico(String title) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle(title);
		setBounds(100, 100, 574, 297);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel panelDados = new JPanel();
		panelDados.setLayout(null);
		panelDados.setBackground(Color.WHITE);
		panelDados.setBounds(0, 54, 558, 210);
		panelPrincipal.add(panelDados);

		JLabel lblEmail = new JLabel("E-mail: ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(10, 112, 78, 20);
		panelDados.add(lblEmail);

		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setBounds(99, 50, 200, 20);
		panelDados.add(txtRazaoSocial);

		txtEmail = new JTextField();
		txtEmail.setBounds(72, 113, 192, 20);
		panelDados.add(txtEmail);

		

		JLabel lblRazaoSocial = new JLabel("Raz\u00E3o Social: ");
		lblRazaoSocial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRazaoSocial.setBounds(10, 49, 98, 20);
		panelDados.add(lblRazaoSocial);

		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblID.setBounds(10, 13, 46, 14);
		panelDados.add(lblID);

		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(40, 11, 68, 20);
		panelDados.add(txtID);
		
		JLabel lblCNPJ = new JLabel("CNPJ:");
		lblCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCNPJ.setBounds(309, 50, 45, 20);
		panelDados.add(lblCNPJ);
		
		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(344, 50, 192, 20);
		panelDados.add(txtCNPJ);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStatus.setBounds(280, 110, 108, 20);
		panelDados.add(lblStatus);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia: ");
		lblNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomeFantasia.setBounds(10, 81, 98, 20);
		panelDados.add(lblNomeFantasia);
		
		txtNomeFantasia = new JTextField();
		txtNomeFantasia.setBounds(109, 81, 190, 20);
		panelDados.add(txtNomeFantasia);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefone.setBounds(309, 80, 108, 20);
		panelDados.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(380, 81, 115, 20);
		panelDados.add(txtTelefone);
		
		cbStatus = new JComboBox();
		cbStatus.setModel(new DefaultComboBoxModel(new String[] {"Ativado", "Desativado"}));
		cbStatus.setBounds(334, 110, 121, 22);
		panelDados.add(cbStatus);
		
		JButton btnSalvar = new JButton("Salvar");
		
		//-----------------CLIQUE DO BOTÃO-------------------
		btnSalvar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				Fornecedor fornecedor = new Fornecedor();
				
				fornecedor.setRazaoSocial(txtRazaoSocial.getText());
				fornecedor.setCnpj(txtCNPJ.getText());
				fornecedor.setNomeFantasia(txtNomeFantasia.getText());
				fornecedor.setTelefone(txtTelefone.getText());
				fornecedor.setEmail(txtEmail.getText());
				fornecedor.setStatus(cbStatus.getSelectedIndex());
				
				if (title.equals("NOVO")) {
					new FornecedorDAO().insert(fornecedor);
				}else if (title.equals("EDITAR")) {
					new FornecedorDAO().update(fornecedor, id);
				}else if (title.equals("EXCLUIR")) {
					int resposta = JOptionPane.showConfirmDialog(null,
							"Tem certeza que deseja excluir " + fornecedor.getRazaoSocial() + "?", "Atenção",
							JOptionPane.YES_NO_OPTION);
					
					if (resposta == 0) {
						new FornecedorDAO().delete(id);
					}
				}
				
			
				frmFornecedor.atualizarTabela();
				
				dispose();
				
			}
			
		});
		//----------------------------------------------------
		
		btnSalvar.setForeground(SystemColor.text);
		btnSalvar.setBackground(new Color(0, 0, 102));
		btnSalvar.setBounds(10, 157, 89, 23);
		panelDados.add(btnSalvar);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 558, 54);
		panelPrincipal.add(panelTitulo);
		panelTitulo.setLayout(null);
		panelTitulo.setBackground(new Color(0, 0, 102));

		JLabel lblTitulo = new JLabel("Fornecedor");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 30));
		lblTitulo.setBounds(10, 0, 187, 67);
		panelTitulo.add(lblTitulo);
		
		

		

		
	}
	
	public void criarFormulario(FrmFornecedor frmFornecedor) 
	{
		this.frmFornecedor = frmFornecedor;
		setVisible(true);
	}
}