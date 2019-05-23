package br.com.senaijandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmTelaInicial extends JFrame {

	private JPanel painel_principal;
	private JTable table;

	public FrmTelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 670);
		painel_principal = new JPanel();
		painel_principal.setBackground(new Color(255, 153, 51));
		painel_principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel_principal);
		painel_principal.setLayout(null);
		
		JPanel painel_titulo = new JPanel();
		painel_titulo.setBackground(new Color(5, 34, 81));
		painel_titulo.setBounds(0, 0, 854, 75);
		painel_principal.add(painel_titulo);
		painel_titulo.setLayout(null);
		
		JLabel lbl_titulo_principal = new JLabel("");
		lbl_titulo_principal.setIcon(new ImageIcon(FrmTelaInicial.class.getResource("/br/com/senaijandira/view/img/novologo-v2.png")));
		lbl_titulo_principal.setForeground(Color.WHITE);
		lbl_titulo_principal.setFont(new Font("Gadugi", Font.BOLD, 20));
		lbl_titulo_principal.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo_principal.setBounds(10, 11, 834, 53);
		painel_titulo.add(lbl_titulo_principal);
		
		JButton btn_cadastrar = new JButton("CADASTROS");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_cadastrar.setFont(new Font("Arial Black", Font.BOLD, 12));
		btn_cadastrar.setBounds(10, 99, 150, 40);
		painel_principal.add(btn_cadastrar);
		
		JButton btn_funcionarios = new JButton("FUNCIONÁRIOS");
		btn_funcionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_funcionarios.setFont(new Font("Arial Black", Font.BOLD, 12));
		btn_funcionarios.setBounds(180, 99, 150, 40);
		painel_principal.add(btn_funcionarios);
		
		JButton btn_estoque = new JButton("ESTOQUE");
		btn_estoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_estoque.setFont(new Font("Arial Black", Font.BOLD, 12));
		btn_estoque.setBounds(350, 99, 150, 40);
		painel_principal.add(btn_estoque);
		
		JButton btn_relatorio = new JButton("RELATÓRIOS");
		btn_relatorio.setFont(new Font("Arial Black", Font.BOLD, 12));
		btn_relatorio.setBounds(520, 99, 150, 40);
		painel_principal.add(btn_relatorio);
		
		JButton btn_expedicao = new JButton("EXPEDIÇÃO");
		btn_expedicao.setFont(new Font("Arial Black", Font.BOLD, 12));
		btn_expedicao.setBounds(690, 99, 150, 40);
		painel_principal.add(btn_expedicao);
		
		JPanel painel_conteudo = new JPanel();
		painel_conteudo.setBackground(new Color(255, 153, 51));
		painel_conteudo.setBounds(10, 195, 830, 414);
		painel_principal.add(painel_conteudo);
		painel_conteudo.setLayout(null);
		
		JLabel lbl_titulo_modulo = new JLabel("GERENCIAMENTO DE FUNCIONÁRIO");
		lbl_titulo_modulo.setForeground(Color.BLACK);
		lbl_titulo_modulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo_modulo.setFont(new Font("Gadugi", Font.BOLD, 20));
		lbl_titulo_modulo.setBounds(10, 11, 810, 60);
		painel_conteudo.add(lbl_titulo_modulo);
		
		JPanel painel_tabela = new JPanel();
		painel_tabela.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Funcion\u00E1rios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painel_tabela.setBounds(10, 82, 810, 235);
		painel_conteudo.add(painel_tabela);
		painel_tabela.setLayout(null);
		
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 23, 790, 201);
		painel_tabela.add(scrollTabela);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Matr\u00EDcula", "Nome", "E-mail", "Perfil"
			}
		));
		table.setFont(new Font("Arial", Font.BOLD, 12));
		scrollTabela.setViewportView(table);
		
		JButton btn_novo = new JButton("Novo");
		btn_novo.setFont(new Font("Arial Black", Font.BOLD, 14));
		btn_novo.setBounds(162, 343, 130, 40);
		painel_conteudo.add(btn_novo);
		
		JButton btn_editar = new JButton("Editar");
		btn_editar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btn_editar.setBounds(329, 343, 130, 40);
		painel_conteudo.add(btn_editar);
		
		JButton btn_excluir = new JButton("Excluir");
		btn_excluir.setFont(new Font("Arial Black", Font.BOLD, 14));
		btn_excluir.setBounds(503, 343, 130, 40);
		painel_conteudo.add(btn_excluir);
	}
}
