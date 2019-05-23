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

public class FrmTelaInicial extends JFrame {

	private JPanel painel_conteudo;

	public FrmTelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 700);
		painel_conteudo = new JPanel();
		painel_conteudo.setBackground(new Color(255, 153, 51));
		painel_conteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel_conteudo);
		painel_conteudo.setLayout(null);
		
		JPanel painel_titulo = new JPanel();
		painel_titulo.setBackground(new Color(5, 34, 81));
		painel_titulo.setBounds(0, 0, 854, 75);
		painel_conteudo.add(painel_titulo);
		painel_titulo.setLayout(null);
		
		JLabel lbl_titulo_principal = new JLabel("");
		lbl_titulo_principal.setIcon(new ImageIcon(FrmTelaInicial.class.getResource("/br/com/senaijandira/view/img/novologo-v2.png")));
		lbl_titulo_principal.setForeground(Color.WHITE);
		lbl_titulo_principal.setFont(new Font("Gadugi", Font.BOLD, 20));
		lbl_titulo_principal.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo_principal.setBounds(10, 11, 834, 53);
		painel_titulo.add(lbl_titulo_principal);
		
		JButton btn_cadastrar = new JButton("CADASTROS");
		btn_cadastrar.setFont(new Font("Arial Black", Font.BOLD, 12));
		btn_cadastrar.setBounds(10, 99, 150, 40);
		painel_conteudo.add(btn_cadastrar);
		
		JButton button = new JButton("CADASTROS");
		button.setFont(new Font("Arial Black", Font.BOLD, 12));
		button.setBounds(180, 99, 150, 40);
		painel_conteudo.add(button);
		
		JButton button_1 = new JButton("CADASTROS");
		button_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		button_1.setBounds(350, 99, 150, 40);
		painel_conteudo.add(button_1);
		
		JButton button_2 = new JButton("CADASTROS");
		button_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		button_2.setBounds(520, 99, 150, 40);
		painel_conteudo.add(button_2);
		
		JButton button_3 = new JButton("CADASTROS");
		button_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		button_3.setBounds(690, 99, 150, 40);
		painel_conteudo.add(button_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 195, 830, 414);
		painel_conteudo.add(panel);
	}
}
