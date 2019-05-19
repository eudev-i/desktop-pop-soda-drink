package br.com.senaijandira.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import br.com.senaijandira.dao.CargoDAO;
import br.com.senaijandira.dao.FuncionarioDAO;
import br.com.senaijandira.dao.PerfilDAO;
import br.com.senaijandira.model.Cargo;
import br.com.senaijandira.model.Funcionario;
import br.com.senaijandira.model.Perfil;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class FrmFuncionarioFormulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painelConteudo;
	private FrmFuncionario frmFuncionario;
	private JTextField txt_nome;
	private JTextField txt_email;
	private JTextField txt_telefone;
	private JTextField txt_celular;
	private JTextField txt_dtNasc;
	private JTextField txt_usuario;
	private JTextField txt_senha;
	private JTextField txt_dtAdmissao;
	private JComboBox<Cargo> combo_cargo;
	private JComboBox<Perfil> combo_perfil;
	private int id;

	public void setTxt_nome(String txt_nome) {
		this.txt_nome.setText(txt_nome);
	}

	public void setTxt_email(String txt_email) {
		this.txt_email.setText(txt_email);
	}

	public void setTxt_telefone(String txt_telefone) {
		this.txt_telefone.setText(txt_telefone);
	}

	public void setTxt_celular(String txt_celular) {
		this.txt_celular.setText(txt_celular);
	}

	public void setTxt_dtNasc(Date txt_dtNasc) {
		this.txt_dtNasc.setText(String.valueOf(txt_dtNasc));
	}

	public void setTxt_usuario(String txt_usuario) {
		this.txt_usuario.setText(txt_usuario);
	}

	public void setTxt_senha(String txt_senha) {
		this.txt_senha.setText(txt_senha);
	}

	public void setTxt_dtAdmissao(Date txt_dtAdmissao) {
		this.txt_dtAdmissao.setText(String.valueOf(txt_dtAdmissao));
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public FrmFuncionarioFormulario(String modo) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 499);
		painelConteudo = new JPanel();
		painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelConteudo.setLayout(new BorderLayout(0, 0));
		setContentPane(painelConteudo);
		
		JPanel painel_principal = new JPanel();
		painel_principal.setBackground(new Color(21, 35, 58));
		painelConteudo.add(painel_principal, BorderLayout.CENTER);
		painel_principal.setLayout(null);
		
		JLabel lbl_titulo = new JLabel();
		lbl_titulo.setForeground(Color.WHITE);
		lbl_titulo.setFont(new Font("Arial Black", Font.BOLD, 18));
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo.setBounds(10, 11, 404, 56);
		painel_principal.add(lbl_titulo);
		
		if (modo.equals("NOVO")) {
			lbl_titulo.setText("NOVO FUNCIONÁRIO");
		}else if (modo.equals("EDITAR")) {
			lbl_titulo.setText("EDITAR FUNCIONÁRIO");
		}else if (modo.equals("EXCLUIR")) {
			lbl_titulo.setText("EXCLUIR FUNCIONÁRIO");
		}
		
		txt_nome = new JTextField();
		txt_nome.setBounds(29, 117, 169, 20);
		painel_principal.add(txt_nome);
		txt_nome.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(226, 117, 169, 20);
		painel_principal.add(txt_email);
		
		combo_cargo = new JComboBox<Cargo>();
		combo_cargo.setBounds(29, 187, 169, 20);
		painel_principal.add(combo_cargo);
		
		ComboCargo();
				
		combo_perfil = new JComboBox<Perfil>();
		combo_perfil.setBounds(226, 187, 169, 20);
		painel_principal.add(combo_perfil);
		
		ComboPerfil();
		
		txt_telefone = new JTextField();
		txt_telefone.setBounds(29, 257, 100, 20);
		painel_principal.add(txt_telefone);
		txt_telefone.setColumns(10);
		
		txt_celular = new JTextField();
		txt_celular.setColumns(10);
		txt_celular.setBounds(162, 257, 100, 20);
		painel_principal.add(txt_celular);
		
		txt_dtNasc = new JTextField();
		txt_dtNasc.setColumns(10);
		txt_dtNasc.setBounds(295, 257, 100, 20);
		painel_principal.add(txt_dtNasc);
		
		txt_usuario = new JTextField();
		txt_usuario.setColumns(10);
		txt_usuario.setBounds(29, 327, 100, 20);
		painel_principal.add(txt_usuario);
		
		txt_senha = new JPasswordField();
		txt_senha.setColumns(10);
		txt_senha.setBounds(162, 327, 100, 20);
		painel_principal.add(txt_senha);
		
		txt_dtAdmissao = new JTextField();
		txt_dtAdmissao.setColumns(10);
		txt_dtAdmissao.setBounds(295, 327, 100, 20);
		painel_principal.add(txt_dtAdmissao);
		
		JButton btnOperacao = new JButton();
		
		if (modo.equals("EXCLUIR")) {
			
			btnOperacao.setText("EXCLUIR");
			
			txt_nome.setEnabled(false);
			txt_email.setEnabled(false);
			txt_telefone.setEnabled(false);
			txt_celular.setEnabled(false);
			txt_dtNasc.setEnabled(false);
			txt_usuario.setEnabled(false);
			txt_senha.setEnabled(false);
			txt_dtAdmissao.setEnabled(false);
			combo_cargo.setEnabled(false);
			combo_perfil.setEnabled(false);
			
		}else {
			btnOperacao.setText("SALVAR");
		}
		
		btnOperacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Cargo cargo = (Cargo) combo_cargo.getSelectedItem();
				Perfil perfil = (Perfil) combo_perfil.getSelectedItem();
				
				Funcionario funcionario = new Funcionario();
				
				funcionario.setIdCargo(cargo.getId());
				funcionario.setNome(txt_nome.getText());
				funcionario.setEmail(txt_email.getText());
				funcionario.setTelefone(txt_telefone.getText());
				funcionario.setCelular(txt_celular.getText());
				funcionario.setDtAdmissao(Date.valueOf(txt_dtAdmissao.getText()));
				funcionario.setUsuario(txt_usuario.getText());
				funcionario.setSenha(txt_senha.getText());
				funcionario.setDtNasc(Date.valueOf(txt_dtNasc.getText()));
				funcionario.setIdPerfil(perfil.getId());
				
				if (modo.equals("NOVO")) {
					new FuncionarioDAO().Insert(funcionario);
				}else if (modo.equals("EDITAR")) {
					new FuncionarioDAO().Update(funcionario, id);
				}else if (modo.equals("EXCLUIR")) {
					int resposta = JOptionPane.showConfirmDialog(null,
							"Tem certeza que deseja excluir " + funcionario.getNome() + "?", "Atenção",
							JOptionPane.YES_NO_OPTION);
					
					if (resposta == 0) {
						new FuncionarioDAO().Delete(id);
					}
				}
				
				frmFuncionario.atualizarTabela();
				
				dispose();
				
			}
		});
		btnOperacao.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnOperacao.setBounds(151, 386, 120, 40);
		painel_principal.add(btnOperacao);
		
		JLabel lbl_nome = new JLabel("Nome");
		lbl_nome.setForeground(Color.WHITE);
		lbl_nome.setFont(new Font("Arial Black", Font.BOLD, 11));
		lbl_nome.setBounds(29, 97, 169, 14);
		painel_principal.add(lbl_nome);
		
		JLabel lbl_email = new JLabel("Email");
		lbl_email.setForeground(Color.WHITE);
		lbl_email.setFont(new Font("Arial Black", Font.BOLD, 11));
		lbl_email.setBounds(226, 97, 169, 14);
		painel_principal.add(lbl_email);
		
		JLabel lbl_cargo = new JLabel("Cargo");
		lbl_cargo.setForeground(Color.WHITE);
		lbl_cargo.setFont(new Font("Arial Black", Font.BOLD, 11));
		lbl_cargo.setBounds(29, 167, 169, 14);
		painel_principal.add(lbl_cargo);
		
		JLabel lbl_perfil = new JLabel("Perfil");
		lbl_perfil.setForeground(Color.WHITE);
		lbl_perfil.setFont(new Font("Arial Black", Font.BOLD, 11));
		lbl_perfil.setBounds(226, 167, 169, 14);
		painel_principal.add(lbl_perfil);
		
		JLabel lbl_telefone = new JLabel("Telefone");
		lbl_telefone.setForeground(Color.WHITE);
		lbl_telefone.setFont(new Font("Arial Black", Font.BOLD, 11));
		lbl_telefone.setBounds(29, 237, 100, 14);
		painel_principal.add(lbl_telefone);
		
		JLabel lbl_celular = new JLabel("Celular");
		lbl_celular.setForeground(Color.WHITE);
		lbl_celular.setFont(new Font("Arial Black", Font.BOLD, 11));
		lbl_celular.setBounds(162, 237, 100, 14);
		painel_principal.add(lbl_celular);
		
		JLabel lbl_dtNasc = new JLabel("Dt Nasc");
		lbl_dtNasc.setForeground(Color.WHITE);
		lbl_dtNasc.setFont(new Font("Arial Black", Font.BOLD, 11));
		lbl_dtNasc.setBounds(295, 237, 100, 14);
		painel_principal.add(lbl_dtNasc);
		
		JLabel lbl_usuario = new JLabel("Usu\u00E1rio");
		lbl_usuario.setForeground(Color.WHITE);
		lbl_usuario.setFont(new Font("Arial Black", Font.BOLD, 11));
		lbl_usuario.setBounds(29, 307, 100, 14);
		painel_principal.add(lbl_usuario);
		
		JLabel lbl_senha = new JLabel("Senha");
		lbl_senha.setForeground(Color.WHITE);
		lbl_senha.setFont(new Font("Arial Black", Font.BOLD, 11));
		lbl_senha.setBounds(162, 307, 100, 14);
		painel_principal.add(lbl_senha);
		
		JLabel lbl_dtAdmissao = new JLabel("Dt Admiss\u00E3o");
		lbl_dtAdmissao.setForeground(Color.WHITE);
		lbl_dtAdmissao.setFont(new Font("Arial Black", Font.BOLD, 11));
		lbl_dtAdmissao.setBounds(295, 307, 100, 14);
		painel_principal.add(lbl_dtAdmissao);
	}
	
	public void ComboCargo() 
	{
		ArrayList<Cargo> cargos = new ArrayList<Cargo>();
		cargos = new CargoDAO().SelectAll();
		
		for(Cargo cargo : cargos) 
		{
			combo_cargo.addItem(cargo);
		}
		
	}
	
	public void ComboPerfil() 
	{
		ArrayList<Perfil> perfis = new ArrayList<Perfil>();
		perfis = new PerfilDAO().SelectAll();
		
		for(Perfil perfil : perfis) 
		{
			combo_perfil.addItem(perfil);
		}
	}
	
	public void criarFormulario(FrmFuncionario frmFuncionario) 
	{
		this.frmFuncionario = frmFuncionario;
		setVisible(true);
	}
	
}
