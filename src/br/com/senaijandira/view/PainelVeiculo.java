package br.com.senaijandira.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.senaijandira.dao.VeiculoDAO;
import br.com.senaijandira.model.Veiculo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelVeiculo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel painel_tabela;
	private JTable tabela;
	private JScrollPane scrollTabela;
	private DefaultTableModel modeloTabela;

	public PainelVeiculo() {

		setBackground(new Color(255, 153, 51));
		setSize(653, 405);
		setLayout(null);

		JLabel lbl_titulo_modulo = new JLabel("GERENCIAMENTO DE VEÍCULO");
		lbl_titulo_modulo.setForeground(Color.BLACK);
		lbl_titulo_modulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo_modulo.setFont(new Font("Gadugi", Font.BOLD, 20));
		lbl_titulo_modulo.setBounds(10, 11, 633, 60);
		add(lbl_titulo_modulo);

		painel_tabela = new JPanel();
		painel_tabela.setBackground(new Color(255, 153, 51));
		painel_tabela.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ve\u00EDculos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		painel_tabela.setBounds(10, 82, 633, 235);
		add(painel_tabela);
		painel_tabela.setLayout(null);

		// Chamando a tabela
		CriarTabela();

		JButton btn_novo = new JButton("Novo");
		btn_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmVeiculoFormulario("NOVO").criarFormulario(PainelVeiculo.this);
			}
		});
		btn_novo.setFont(new Font("Arial Black", Font.BOLD, 14));
		btn_novo.setBounds(71, 343, 130, 40);
		add(btn_novo);

		JButton btn_editar = new JButton("Editar");
		btn_editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarPorId("EDITAR");
			}
		});
		btn_editar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btn_editar.setBounds(273, 343, 130, 40);
		add(btn_editar);

		JButton btn_excluir = new JButton("Excluir");
		btn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarPorId("EXCLUIR");
			}
		});
		btn_excluir.setFont(new Font("Arial Black", Font.BOLD, 14));
		btn_excluir.setBounds(460, 343, 130, 40);
		add(btn_excluir);
	}

	// Método para criar uma tabela
	public void CriarTabela() 
	{
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 21, 613, 203);
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

		String[] nomeColunas = {"Cód.", "Modelo", "Placa", "Peso Máximo", "Volume Máximo"};

		modeloTabela.setColumnIdentifiers(nomeColunas);

		GerarVeiculos();

		tabela.setModel(modeloTabela);
		scrollTabela.setViewportView(tabela);

		// Deixar as colunas da tabela fixas
		tabela.getTableHeader().setReorderingAllowed(false);

		// Deixar o cabe�alho centralizado
		((DefaultTableCellRenderer) tabela.getTableHeader().getDefaultRenderer())
		.setHorizontalAlignment(SwingConstants.CENTER);

		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(15);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(3).setResizable(false);
		tabela.getColumnModel().getColumn(4).setResizable(false);

		tabela.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollTabela.setViewportView(tabela);
		scrollTabela.getViewport().setBackground(new Color(255, 255, 255));

	}

	// Apaga toda a tabela e gera os clientes novamente
	public void atualizarTabela(){
		modeloTabela.setRowCount(0);
		GerarVeiculos();
	}


	public void GerarVeiculos() 
	{
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

		veiculos = veiculoDAO.SelectAll();

		Object[] linha = new Object[5];

		for (Veiculo veiculo : veiculos) 
		{
			linha[0] = veiculo.getId();
			linha[1] = veiculo.getModelo();
			linha[2] = veiculo.getPlaca();
			linha[3] = veiculo.getCapac_peso() + " KG";
			linha[4] = veiculo.getCapc_volume() + " L";

			modeloTabela.addRow(linha);
		}
	}
	
	public void BuscarPorId(String modo) 
	{
		
		try {
			
			int linha;
			linha = tabela.getSelectedRow();
			
			int id;
			id = (int) tabela.getValueAt(linha, 0);
			
			VeiculoDAO veiculoDAO = new VeiculoDAO();
			Veiculo veiculo = veiculoDAO.SelectById(id);
			
			
			FrmVeiculoFormulario formulario = new FrmVeiculoFormulario(modo);
			formulario.setId(veiculo.getId());
			formulario.setModelo(veiculo.getModelo());
			formulario.setPlaca(veiculo.getPlaca());
			formulario.setPeso(String.valueOf(veiculo.getCapac_peso()));
			formulario.setVolume(String.valueOf(veiculo.getCapc_volume()));
			
			formulario.criarFormulario(PainelVeiculo.this);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Selecione um contato!", "Aten��o", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
		
	}

}
