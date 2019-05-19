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
import br.com.senaijandira.dao.FuncionarioDAO;
import br.com.senaijandira.model.Funcionario;

public class FrmFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painel_conteudo;
	private JPanel painel_tabela;
	private JTable tabela;
	private JScrollPane scrollTabela;
	private DefaultTableModel modeloTabela;

	public FrmFuncionario() {
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

		JLabel lbl_titulo = new JLabel("Gerenciamento de Funcion\u00E1rio");
		lbl_titulo.setBounds(231, 11, 461, 82);
		lbl_titulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		painel_principal.add(lbl_titulo);

		painel_tabela = new JPanel();
		painel_tabela.setBounds(210, 132, 514, 248);
		painel_tabela.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Funcionários", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		painel_principal.add(painel_tabela);
		painel_tabela.setLayout(null);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmFuncionarioFormulario("NOVO").criarFormulario(FrmFuncionario.this);
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

	// Mï¿½todo para criar uma tabela
	public void CriarTabela() 
	{
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 21, 494, 220);
		painel_tabela.add(scrollTabela);

		tabela = new JTable();

		modeloTabela = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			// Deixar as cï¿½lulas da tabela nï¿½o editï¿½veis
			@Override
			public boolean isCellEditable(int linha, int coluna) {
				return false;
			}
		};

		String[] nomeColunas = {"Matrícula", "Nome", "E-mail", "Dt Admissão"};

		modeloTabela.setColumnIdentifiers(nomeColunas);

		GerarFuncionario();

		tabela.setModel(modeloTabela);
		scrollTabela.setViewportView(tabela);

		// Deixar as colunas da tabela fixas
		tabela.getTableHeader().setReorderingAllowed(false);

		// Deixar o cabeï¿½alho centralizado
		((DefaultTableCellRenderer) tabela.getTableHeader().getDefaultRenderer())
		.setHorizontalAlignment(SwingConstants.CENTER);

		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(1);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(3).setResizable(false);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(20);


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
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

		funcionarios = funcionarioDAO.SelectAll();

		Object[] linha = new Object[4];

		for (Funcionario funcionario : funcionarios) 
		{
			linha[0] = funcionario.getMatricula();
			linha[1] = funcionario.getNome();
			linha[2] = funcionario.getEmail();
			linha[3] = funcionario.getDtAdmissao();

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

			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			Funcionario funcionario = funcionarioDAO.SelectById(id);

			FrmFuncionarioFormulario formulario = new FrmFuncionarioFormulario(modo);
			
			formulario.setId(funcionario.getMatricula());
			formulario.setTxt_nome(funcionario.getNome());
			formulario.setTxt_email(funcionario.getEmail());
			formulario.setTxt_telefone(funcionario.getTelefone());
			formulario.setTxt_celular(funcionario.getCelular());
			formulario.setTxt_dtNasc(funcionario.getDtAdmissao());
			formulario.setTxt_usuario(funcionario.getUsuario());
			formulario.setTxt_senha(funcionario.getSenha());
			formulario.setTxt_dtAdmissao(funcionario.getDtAdmissao());
			
			formulario.criarFormulario(FrmFuncionario.this);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Selecione um contato!", "Atenï¿½ï¿½o", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}

	}

}
