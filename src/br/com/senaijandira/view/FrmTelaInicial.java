package br.com.senaijandira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmTelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel_principal;
	private JPanel painel_conteudo;

	public FrmTelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 527);
		painel_principal = new JPanel();
		painel_principal.setBackground(new Color(255, 153, 51));
		painel_principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel_principal);
		painel_principal.setLayout(null);
		
		JPanel painel_titulo = new JPanel();
		painel_titulo.setBackground(new Color(5, 34, 81));
		painel_titulo.setBounds(0, 0, 875, 75);
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
		btn_cadastrar.setBounds(10, 140, 150, 40);
		painel_principal.add(btn_cadastrar);
		
		JButton btn_funcionarios = new JButton("FUNCIONÁRIOS");
		btn_funcionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_funcionarios.setFont(new Font("Arial Black", Font.BOLD, 12));
		btn_funcionarios.setBounds(10, 200, 150, 40);
		painel_principal.add(btn_funcionarios);
		
		JButton btn_estoque = new JButton("ESTOQUE");
		btn_estoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_estoque.setFont(new Font("Arial Black", Font.BOLD, 12));
		btn_estoque.setBounds(10, 260, 150, 40);
		painel_principal.add(btn_estoque);
		
		JButton btn_relatorio = new JButton("RELATÓRIOS");
		btn_relatorio.setFont(new Font("Arial Black", Font.BOLD, 12));
		btn_relatorio.setBounds(10, 320, 150, 40);
		painel_principal.add(btn_relatorio);
		
		JButton btn_expedicao = new JButton("EXPEDIÇÃO");
		btn_expedicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				painel_conteudo.removeAll();
				painel_conteudo.add(new PainelVeiculo(), BorderLayout.CENTER);
				painel_conteudo.revalidate();
				painel_conteudo.repaint();
			}
		});
		btn_expedicao.setFont(new Font("Arial Black", Font.BOLD, 12));
		btn_expedicao.setBounds(10, 380, 150, 40);
		painel_principal.add(btn_expedicao);
		
		painel_conteudo = new JPanel();
		painel_conteudo.setBackground(new Color(255, 153, 51));
		painel_conteudo.setBounds(202, 86, 653, 405);
		painel_principal.add(painel_conteudo);
		painel_conteudo.setLayout(null);
		
		JLabel lbl_titulo_modulo = new JLabel("BEM-VINDO CAIO");
		lbl_titulo_modulo.setForeground(Color.BLACK);
		lbl_titulo_modulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo_modulo.setFont(new Font("Gadugi", Font.BOLD, 30));
		lbl_titulo_modulo.setBounds(10, 11, 633, 120);
		painel_conteudo.add(lbl_titulo_modulo);
		
		JLabel lblNewLabel = new JLabel("Usuário: admin");
		lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 18));
		lblNewLabel.setBounds(188, 180, 455, 20);
		painel_conteudo.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("E-mail: caio.costacarmo@gmail.com");
		lblEmail.setFont(new Font("Gadugi", Font.BOLD, 18));
		lblEmail.setBounds(188, 210, 455, 20);
		painel_conteudo.add(lblEmail);
		
		JLabel lblDataDeAdmisso = new JLabel("Data de Admissão: 11/03/2019");
		lblDataDeAdmisso.setFont(new Font("Gadugi", Font.BOLD, 18));
		lblDataDeAdmisso.setBounds(188, 240, 455, 20);
		painel_conteudo.add(lblDataDeAdmisso);
		
		JLabel lblPerfil = new JLabel("Perfil: Administrativo");
		lblPerfil.setFont(new Font("Gadugi", Font.BOLD, 18));
		lblPerfil.setBounds(188, 270, 455, 20);
		painel_conteudo.add(lblPerfil);
	}
}
