package br.com.senaijandira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.senaijandira.dao.VeiculoDAO;
import br.com.senaijandira.model.Veiculo;

import javax.swing.UIManager;

public class FrmVeiculo {

	private JFrame frame;
	private JPanel painel_tabela;
	private JTable tabelaVeiculo;
	private JScrollPane scrollTabela;
	private DefaultTableModel modeloTabela;
	
	public FrmVeiculo() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JPanel painel_principal = new JPanel();
		frame.getContentPane().add(painel_principal, BorderLayout.CENTER);
		painel_principal.setLayout(null);
		
		JPanel painel_menu = new JPanel();
		painel_menu.setBorder(null);
		painel_menu.setBounds(0, 11, 200, 500);
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
		
		JLabel lbl_titulo = new JLabel("Gerenciamento de Veiculos");
		lbl_titulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo.setBounds(231, 11, 461, 82);
		painel_principal.add(lbl_titulo);
		
		painel_tabela = new JPanel();
		painel_tabela.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Veiculos", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		painel_tabela.setBounds(210, 132, 514, 257);
		painel_principal.add(painel_tabela);
		painel_tabela.setLayout(null);
		
		// Chamando a tabela
		CriarTabela();
		
		JPanel painel_opcoes = new JPanel();
		painel_opcoes.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Opções", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		painel_opcoes.setBackground(Color.BLUE);
		painel_opcoes.setBounds(210, 400, 514, 72);
		painel_principal.add(painel_opcoes);
		painel_opcoes.setLayout(null);
		
	}
	
	// Método para criar uma tabela
	public void CriarTabela() 
	{
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 21, 494, 220);
		painel_tabela.add(scrollTabela);
		
		tabelaVeiculo = new JTable();
		
		modeloTabela = new DefaultTableModel() {
			// Deixar as células da tabela não editáveis
			@Override
			public boolean isCellEditable(int linha, int coluna) {
				return false;
			}
		};
		
		String[] nomeColunas = {"Modelo", "Placa", "Capacidade Peso", "Capacidade Volume"};
		
		modeloTabela.setColumnIdentifiers(nomeColunas);
		
		GerarVeiculos();
		
		tabelaVeiculo.setModel(modeloTabela);
		scrollTabela.setViewportView(tabelaVeiculo);
		
		// Deixar as colunas da tabela fixas
		tabelaVeiculo.getTableHeader().setReorderingAllowed(false);
				
		// Deixar o cabeçalho centralizado
		((DefaultTableCellRenderer) tabelaVeiculo.getTableHeader().getDefaultRenderer())
			.setHorizontalAlignment(SwingConstants.CENTER);
				
		tabelaVeiculo.getColumnModel().getColumn(0).setResizable(false);
		tabelaVeiculo.getColumnModel().getColumn(1).setResizable(false);
		tabelaVeiculo.getColumnModel().getColumn(2).setResizable(false);
		tabelaVeiculo.getColumnModel().getColumn(3).setResizable(false);
		
		tabelaVeiculo.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollTabela.setViewportView(tabelaVeiculo);
		scrollTabela.getViewport().setBackground(new Color(255, 255, 255));
		
		
	}
	
	public void GerarVeiculos() 
	{
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		
		veiculos = veiculoDAO.SelectAll();
		
		Object[] linha = new Object[4];
		
		for (Veiculo veiculo : veiculos) 
		{
			linha[0] = veiculo.getModelo();
			linha[1] = veiculo.getPlaca();
			linha[2] = veiculo.getCapac_peso() + " KG";
			linha[3] = veiculo.getCapc_volume() + " L";
			
			modeloTabela.addRow(linha);
		}
	}
}
