package br.com.senaijandira.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senaijandira.dao.PedidoDAO;
import br.com.senaijandira.model.Pedido;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPedidoFormulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painelConteudo;
	private FrmPedido frmPedido;
	private JComboBox<String> comboStatus;
	private int id;

	public void setId(int id) {
		this.id = id;
	}

	public FrmPedidoFormulario(String status) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 290);
		painelConteudo = new JPanel();
		painelConteudo.setBackground(new Color(21, 35, 58));
		painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelConteudo.setLayout(new BorderLayout(0, 0));
		setContentPane(painelConteudo);

		JPanel painel_principal = new JPanel();
		painel_principal.setBackground(new Color(21, 35, 58));
		painelConteudo.add(painel_principal, BorderLayout.CENTER);
		painel_principal.setLayout(null);

		JLabel lbl_titulo = new JLabel("EDITAR PEDIDO");
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo.setForeground(Color.WHITE);
		lbl_titulo.setFont(new Font("Arial Black", Font.BOLD, 18));
		lbl_titulo.setBounds(10, 11, 297, 56);
		painel_principal.add(lbl_titulo);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblStatus.setBounds(77, 91, 150, 14);
		painel_principal.add(lblStatus);

		comboStatus = new JComboBox<String>();
		comboStatus.setBounds(77, 116, 150, 20);
		painel_principal.add(comboStatus);
		
		ComboStatus(status);

		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String status = (String) comboStatus.getSelectedItem();
				
				Pedido pedido = new Pedido();
				
				pedido.setStatusPedido(status);
				
				new PedidoDAO().Update(pedido, id);
				
				frmPedido.atualizarTabela();
				
				dispose();
				
			}
		});
		
		btnNewButton.setBounds(93, 175, 120, 40);
		painel_principal.add(btnNewButton);
	}
	
	public void ComboStatus(String statusPedido) {
		
		String[] todosStatus = {"Separação do estoque", "Nota Fiscal Emitida", "Pedido em transporte", "Pedido entregue"};
		
		for (String status : todosStatus) {
			comboStatus.addItem(status);
			
			if (status.equals(statusPedido)) {
				comboStatus.setSelectedItem(statusPedido);
			}
			
		}
		
	}

	public void CriarFormulario(FrmPedido frmPedido) {	
		this.frmPedido = frmPedido;
		setVisible(true);
	}
}
