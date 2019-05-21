package br.com.senaijandira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.senaijandira.dao.MotoristaDAO;
import br.com.senaijandira.dao.ProdutoDAO;
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


public class FrmMotoristaUnico extends JFrame {

	private JPanel panelPrincipal;
	private JTextField txtNome;
	private JTextField txtValidade;
	private JTextField txtID;
	private FrmMotorista frmMotorista;
	ProdutoDAO dao = new ProdutoDAO();
	private JTextField txtCPF;
	private JTextField txtHabilitacao;
	private JTextField txtCategoria;
	private JComboBox cbStatus;
	private int id;

	// métodos para setar os valores dos txtfields
	public void setTxtID(int id) {
		this.txtID.setText(String.valueOf(id));

	}

	public void setTxtNome(String nome) {
		this.txtNome.setText(nome);
	}
	
	// métodos para setar os valores dos txtfields
	public void setTxtValidade(java.util.Date date) {
		this.txtValidade.setText(String.valueOf(date));

	}

	public void setTxtCPF(String cpf) {
		this.txtCPF.setText(cpf);
	}	
	
	public void setTxtHabilitacao(String habi) {
		this.txtHabilitacao.setText(habi);
	}	
	
	public void setTxtCategoria(String cat) {
		this.txtCategoria.setText(cat);
	}	
	
	public void setCbStatus(int status) {
		if (status == 1) {
			cbStatus.setSelectedIndex(0);

		} else {
			cbStatus.setSelectedIndex(1);
		}
	}	
	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Create the frame.
	 */
	public FrmMotoristaUnico(String title) {
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

		JLabel lblValidade = new JLabel("Validade: ");
		lblValidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValidade.setBounds(10, 112, 78, 20);
		panelDados.add(lblValidade);

		txtNome = new JTextField();
		txtNome.setBounds(60, 50, 215, 20);
		panelDados.add(txtNome);

		txtValidade = new JTextField();
		txtValidade.setBounds(72, 113, 126, 20);
		panelDados.add(txtValidade);

		// Vetor para níveis de atividade
		String[] nivelAtividade = { "Sedentário", "Levemente Ativo", "Moderadamente Ativo", "Bastante Ativo",
				"Muito Ativo" };

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 49, 45, 20);
		panelDados.add(lblNome);

		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblID.setBounds(10, 13, 46, 14);
		panelDados.add(lblID);

		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(40, 11, 68, 20);
		panelDados.add(txtID);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCPF.setBounds(309, 50, 45, 20);
		panelDados.add(lblCPF);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(344, 50, 192, 20);
		panelDados.add(txtCPF);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStatus.setBounds(222, 112, 108, 20);
		panelDados.add(lblStatus);
		
		JLabel lblHabilitacao = new JLabel("Habilita\u00E7\u00E3o: ");
		lblHabilitacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHabilitacao.setBounds(10, 81, 98, 20);
		panelDados.add(lblHabilitacao);
		
		txtHabilitacao = new JTextField();
		txtHabilitacao.setBounds(88, 81, 187, 20);
		panelDados.add(txtHabilitacao);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCategoria.setBounds(309, 80, 108, 20);
		panelDados.add(lblCategoria);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(380, 81, 60, 20);
		panelDados.add(txtCategoria);
		
		cbStatus = new JComboBox();
		cbStatus.setModel(new DefaultComboBoxModel(new String[] {"Ativado", "Desativado"}));
		cbStatus.setBounds(276, 112, 121, 22);
		panelDados.add(cbStatus);
		
		JButton btnSalvar = new JButton("Salvar");
		
		//-----------------CLIQUE DO BOTÃO-------------------
		btnSalvar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				Motorista motorista = new Motorista();
				
				motorista.setNome(txtNome.getText());
				motorista.setCpf(txtCPF.getText());
				motorista.setHabilitacao(txtHabilitacao.getText());
				motorista.setCategoria(txtCategoria.getText());
				motorista.setValidade(Date.valueOf(txtValidade.getText()));
				motorista.setStatus(cbStatus.getSelectedIndex());
				
				if (title.equals("NOVO")) {
					new MotoristaDAO().insert(motorista);
				}else if (title.equals("EDITAR")) {
					new MotoristaDAO().update(motorista, id);
				}else if (title.equals("EXCLUIR")) {
					int resposta = JOptionPane.showConfirmDialog(null,
							"Tem certeza que deseja excluir " + motorista.getNome() + "?", "Atenção",
							JOptionPane.YES_NO_OPTION);
					
					if (resposta == 0) {
						new MotoristaDAO().delete(id);
					}
				}
				
				FrmMotorista frmMotorista = new FrmMotorista();
				frmMotorista.atualizarTabela();
				
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

		JLabel lblTitulo = new JLabel("Motorista");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 30));
		lblTitulo.setBounds(10, 0, 187, 67);
		panelTitulo.add(lblTitulo);
		
		//Criando um cliente
		final Produto produto = new Produto();

		

		
	}
	
	public void criarFormulario(FrmMotorista frmMotorista) 
	{
		this.frmMotorista = frmMotorista;
		setVisible(true);
	}
}