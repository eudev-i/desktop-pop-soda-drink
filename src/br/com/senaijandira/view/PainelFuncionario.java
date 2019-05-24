package br.com.senaijandira.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import br.com.senaijandira.dao.FuncionarioDAO;
import br.com.senaijandira.model.Funcionario;

public class PainelFuncionario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel painel_tabela;
	private JTable tabela;
	private JScrollPane scrollTabela;
	private DefaultTableModel modeloTabela;

	public PainelFuncionario() {
		setBackground(new Color(255, 153, 51));
		setSize(695, 391);
		setLayout(null);

		JLabel lbl_titulo_modulo = new JLabel("GERENCIAMENTO DE FUNCIONÁRIO");
		lbl_titulo_modulo.setForeground(Color.BLACK);
		lbl_titulo_modulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo_modulo.setFont(new Font("Gadugi", Font.BOLD, 20));
		lbl_titulo_modulo.setBounds(10, 11, 665, 60);
		add(lbl_titulo_modulo);

		painel_tabela = new JPanel();
		painel_tabela.setBackground(new Color(255, 153, 51));
		painel_tabela.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Funcion\u00E1rios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		painel_tabela.setBounds(10, 82, 675, 235);
		add(painel_tabela);
		painel_tabela.setLayout(null);

		// Chamando a tabela
		CriarTabela();

		JButton btn_novo = new JButton("Novo");
		btn_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmFuncionarioFormulario("NOVO", 0, 0).criarFormulario(PainelFuncionario.this);
			}
		});
		btn_novo.setFont(new Font("Arial Black", Font.BOLD, 14));
		btn_novo.setBounds(75, 335, 130, 40);
		add(btn_novo);

		JButton btn_editar = new JButton("Editar");
		btn_editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarPorId("EDITAR");
			}
		});
		btn_editar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btn_editar.setBounds(283, 335, 130, 40);
		add(btn_editar);

		JButton btn_excluir = new JButton("Excluir");
		btn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarPorId("EXCLUIR");
			}
		});
		btn_excluir.setFont(new Font("Arial Black", Font.BOLD, 14));
		btn_excluir.setBounds(487, 335, 130, 40);
		add(btn_excluir);
	}

	// M�todo para criar uma tabela
	public void CriarTabela() 
	{
		scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 21, 655, 203);
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

		String[] nomeColunas = {"Cód.", "Nome", "E-mail", "Dt Admissão"};

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
		tabela.getColumnModel().getColumn(0).setMaxWidth(50);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(2).setResizable(false);
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

			FrmFuncionarioFormulario formulario = new FrmFuncionarioFormulario(modo, funcionario.getIdCargo(), funcionario.getIdPerfil());

			formulario.setTxt_nome(funcionario.getNome());
			formulario.setTxt_email(funcionario.getEmail());
			formulario.setTxt_telefone(funcionario.getTelefone());
			formulario.setTxt_celular(funcionario.getCelular());
			formulario.setTxt_dtNasc(funcionario.getDtAdmissao());
			formulario.setTxt_usuario(funcionario.getUsuario());
			formulario.setTxt_senha(funcionario.getSenha());
			formulario.setTxt_dtAdmissao(funcionario.getDtAdmissao());
			formulario.setId(funcionario.getMatricula());

			formulario.criarFormulario(this);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Selecione um contato!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
