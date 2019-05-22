package br.com.senaijandira.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.senaijandira.dao.PedidoDAO;
import br.com.senaijandira.model.Pedido;

public class FrmPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel_conteudo;
	private JPanel painel_tabela;
	private JTable tabela;
	private JScrollPane scrollTabela;
	private DefaultTableModel modeloTabela;

	public FrmPedido() {
		setBounds(100, 100, 750, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		painel_conteudo = new JPanel();
		painel_conteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel_conteudo.setLayout(new BorderLayout(0, 0));
		setContentPane(painel_conteudo);

		JPanel painel_principal = new JPanel();
		painel_conteudo.add(painel_principal, BorderLayout.CENTER);
		painel_principal.setLayout(null);

		JPanel painel_menu = new JPanel();
		painel_menu.setBounds(0, 11, 200, 500);
		painel_menu.setBorder(null);
		painel_principal.add(painel_menu);
		painel_menu.setLayout(null);

		JPanel painel_img = new JPanel();
		painel_img.setBackground(Color.DARK_GRAY);
		painel_img.setBounds(39, 11, 120, 120);
		painel_menu.add(painel_img);

		JButton btnCadastros = new JButton("Cadastros");
		btnCadastros.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnCadastros.setBounds(10, 159, 180, 50);
		painel_menu.add(btnCadastros);

		JButton btnGerenciamento = new JButton("Gerenciamento");
		btnGerenciamento.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnGerenciamento.setBounds(10, 220, 180, 50);
		painel_menu.add(btnGerenciamento);

		JButton btnControleDeEstoque = new JButton("Controle de Estoque");
		btnControleDeEstoque.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnControleDeEstoque.setBounds(10, 281, 180, 50);
		painel_menu.add(btnControleDeEstoque);

		JButton btnRelatorio = new JButton("Relat\u00F3rios");
		btnRelatorio.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnRelatorio.setBounds(10, 342, 180, 50);
		painel_menu.add(btnRelatorio);

		JButton btnExpedicao = new JButton("Expedi\u00E7\u00E3o");
		btnExpedicao.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnExpedicao.setBounds(10, 403, 180, 50);
		painel_menu.add(btnExpedicao);

		JLabel lbl_titulo = new JLabel("Gerenciamento de Pedidos");
		lbl_titulo.setBounds(231, 11, 461, 82);
		lbl_titulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		painel_principal.add(lbl_titulo);

		painel_tabela = new JPanel();
		painel_tabela.setBounds(210, 132, 514, 248);
		painel_tabela.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pedidos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		painel_principal.add(painel_tabela);
		painel_tabela.setLayout(null);

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarPorId();
			}
		});
		btnEditar.setBounds(404, 440, 150, 40);
		btnEditar.setFont(new Font("Arial Black", Font.BOLD, 14));
		painel_principal.add(btnEditar);

		// Chamando a tabela
		CriarTabela();

		setVisible(true);
	}

	// M�todo para criar uma tabela
	public void CriarTabela() 
	{
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 21, 494, 220);
		painel_tabela.add(scrollTabela);

		tabela = new JTable();

		modeloTabela = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			// Deixar as c�lulas da tabela n�o edit�veis
			@Override
			public boolean isCellEditable(int linha, int coluna) {
				return false;
			}
		};

		String[] nomeColunas = {"Pedido", "Razão Social", "Dt Pedido", "Status"};

		modeloTabela.setColumnIdentifiers(nomeColunas);

		GerarFuncionario();

		tabela.setModel(modeloTabela);
		scrollTabela.setViewportView(tabela);

		// Deixar as colunas da tabela fixas
		tabela.getTableHeader().setReorderingAllowed(false);

		// Deixar o cabe�alho centralizado
		((DefaultTableCellRenderer) tabela.getTableHeader().getDefaultRenderer())
		.setHorizontalAlignment(SwingConstants.CENTER);

		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(1);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(20);
		tabela.getColumnModel().getColumn(3).setResizable(false);

		tabela.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollTabela.setViewportView(tabela);
		scrollTabela.getViewport().setBackground(new Color(255, 255, 255));

	}

	// Apaga toda a tabela e gera os clientes novamente
	public void atualizarTabela(){
		modeloTabela.setRowCount(0);
		GerarFuncionario();
	}


	public void GerarFuncionario() 
	{
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		
		pedidos = new PedidoDAO().SelectAll();


		Object[] linha = new Object[4];

		for (Pedido pedido : pedidos) 
		{
			linha[0] = pedido.getId();
			linha[1] = pedido.getRazaoSocial();
			linha[2] = pedido.getDtCompra();
			linha[3] = pedido.getStatusPedido();

			modeloTabela.addRow(linha);
		}
	}

	public void BuscarPorId() 
	{

		try {

			int linha;
			linha = tabela.getSelectedRow();

			int id;
			id = (int) tabela.getValueAt(linha, 0);
			
			Pedido pedido = new PedidoDAO().SelectById(id);
			
			FrmPedidoFormulario pedidoFormulario = new FrmPedidoFormulario(pedido.getStatusPedido());
			
			pedidoFormulario.setId(pedido.getId());
			
			pedidoFormulario.CriarFormulario(FrmPedido.this);
			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Selecione um contato!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
