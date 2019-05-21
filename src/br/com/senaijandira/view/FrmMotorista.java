package br.com.senaijandira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.senaijandira.dao.MotoristaDAO;
import br.com.senaijandira.model.Motorista;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMotorista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel_conteudo;
	private JPanel painel_tabela;
	private JTable tabela;
	private JScrollPane scrollTabela;
	private DefaultTableModel modeloTabela;

	public FrmMotorista() {
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

		JLabel lbl_titulo = new JLabel("Gerenciamento de Motoristas");
		lbl_titulo.setBounds(231, 11, 461, 82);
		lbl_titulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		painel_principal.add(lbl_titulo);

		painel_tabela = new JPanel();
		painel_tabela.setBounds(210, 132, 514, 248);
		painel_tabela.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Motoristas", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		painel_principal.add(painel_tabela);
		painel_tabela.setLayout(null);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmMotoristaUnico("NOVO").criarFormulario(FrmMotorista.this);
			}
		});
		btnNovo.setBounds(237, 440, 130, 40);
		btnNovo.setFont(new Font("Arial Black", Font.BOLD, 14));
		painel_principal.add(btnNovo);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarPorId("EDITAR");
			}
		});
		btnEditar.setBounds(404, 440, 130, 40);
		btnEditar.setFont(new Font("Arial Black", Font.BOLD, 14));
		painel_principal.add(btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarPorId("EXCLUIR");
			}
		});
		btnExcluir.setBounds(578, 440, 130, 40);
		btnExcluir.setFont(new Font("Arial Black", Font.BOLD, 14));
		painel_principal.add(btnExcluir);

		// Chamando a tabela
		CriarTabela();
		
		setVisible(true);

	}


	
	public void CriarTabela() 
	{
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 21, 494, 220);
		painel_tabela.add(scrollTabela);

		tabela = new JTable();

		modeloTabela = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			
			@Override
			public boolean isCellEditable(int linha, int coluna) {
				return false;
			}
		};

		String[] nomeColunas = {"ID", "Nome", "Habilitação", "Validade", "CPF"};

		modeloTabela.setColumnIdentifiers(nomeColunas);

		gerarMotoristas();

		tabela.setModel(modeloTabela);
		scrollTabela.setViewportView(tabela);

		// Deixar as colunas da tabela fixas
		tabela.getTableHeader().setReorderingAllowed(false);

		
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
		gerarMotoristas();
	}


	public void gerarMotoristas() 
	{
		
		MotoristaDAO motoristaDAO = new MotoristaDAO();
		ArrayList<Motorista> motoristas = new ArrayList<Motorista>();

		motoristas = motoristaDAO.selectAll();

		Object[] linha = new Object[5];
		
		for (Motorista motorista : motoristas) 
		{
			
			linha[0] = motorista.getIdMotorista();
			linha[1] = motorista.getNome();
			linha[2] = motorista.getHabilitacao();
			linha[3] = motorista.getValidade();
			linha[4] = motorista.getCpf();
			modeloTabela.addRow(linha);
		}
	}
	
	public void BuscarPorId(String modo) 
	{
		FrmMotoristaUnico fUnico = new FrmMotoristaUnico(modo);
		try {
			
			int linha;
			linha = tabela.getSelectedRow();
			
			int id;
			id = (int) tabela.getValueAt(linha, 0);
			
			MotoristaDAO dao = new MotoristaDAO();
			Motorista motorista = new Motorista();
			
			motorista = dao.selectById(id);
			
			//System.out.println(motorista.getCpf());
			fUnico.setTxtID(motorista.getIdMotorista());
			fUnico.setTxtNome(motorista.getNome());
			fUnico.setTxtCategoria(motorista.getCategoria());
			fUnico.setTxtCPF(motorista.getCpf());
			fUnico.setTxtHabilitacao(motorista.getHabilitacao());
			fUnico.setTxtValidade(motorista.getValidade());
			fUnico.setCbStatus(motorista.getStatus());
			fUnico.setId(motorista.getIdMotorista());
			
			System.out.println(motorista.getIdMotorista());
			fUnico.setVisible(true);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Selecione um motorista!", "Cuidado!", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	

}