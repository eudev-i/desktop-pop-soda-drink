package br.com.senaijandira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.senaijandira.dao.ProdutoDAO;
import br.com.senaijandira.model.Produto;

import java.awt.Color;
import javax.swing.JLabel;


import java.awt.Font;
import javax.swing.JTextField;

public class FrmProdutoUnico extends JFrame {

	private JPanel panelPrincipal;
	private JTextField txtNome;
	private JTextField txtPeso;
	private JTextField txtID;

	ProdutoDAO dao = new ProdutoDAO();
	private JTextField txtTipo;
	private JTextField txtVolume;
	private JTextField txtValorUnitario;
	private JTextField txtQtdeFardo;
	private JTextField txtQtdeEstoque;
	private JTextField txtLocalizacao;
	private JTextField txtIpi;
	private JTextField txtDemandaMensal;
	private JTextField txtTempoRessupri;
	private JTextField txtPontoRessupri;
	private JTextField txtLoteDeCompra;
	private JTextField txtEstoqueMax;
	private JTextField txtDesc;

	// métodos para setar os valores dos txtfields
	public void setTxtID(int id) {
		this.txtID.setText(String.valueOf(id));

	}

	public void setTxtNome(String nome) {
		this.txtNome.setText(nome);
	}
	
	public void setTxtPeso(double peso) {
		this.txtPeso.setText(String.valueOf(peso));

	}

	public void setTxtTipo(String tipo) {
		this.txtTipo.setText(tipo);
	}
	
	public void setTxtVolume(double id) {
		this.txtVolume.setText(String.valueOf(id));

	}

	public void setTxtValorUnitario(double valUnitario) {
		this.txtValorUnitario.setText(String.valueOf(valUnitario));
	}
	
	public void setTxtQtdeFardo(int qtdeFardo) {
		this.txtQtdeFardo.setText(String.valueOf(qtdeFardo));

	}

	public void setTxtQtdeEstoque(int estoque) {
		this.txtQtdeEstoque.setText(String.valueOf(estoque));
	}
	
	public void setTxtLocalizacao(String local) {
		this.txtLocalizacao.setText(local);

	}
	
	public void setTxtDesc(String desc) {
		this.txtDesc.setText(desc);

	}

	public void setTxtIpi(double ipi) {
		this.txtNome.setText(String.valueOf(ipi));
	}
	
	public void setTxtDemandaMensal(double id) {
		this.txtDemandaMensal.setText(String.valueOf(id));

	}

	public void setTxtTempoRessupri(int tr) {
		this.txtTempoRessupri.setText(String.valueOf(tr));
	}
	
	public void setTxtPontoRessupri(int pr) {
		this.txtPontoRessupri.setText(String.valueOf(pr));

	}

	public void setTxtLoteCompra(int lc) {
		this.txtLoteDeCompra.setText(String.valueOf(lc));

	}
	
	public void setTxtEstoqueMax(int em) {
		this.txtEstoqueMax.setText(String.valueOf(em));

	}

	/**
	 * Create the frame.
	 */
	public FrmProdutoUnico(String title) {
		setTitle(title);
		setBounds(100, 100, 574, 478);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel panelDados = new JPanel();
		panelDados.setLayout(null);
		panelDados.setBackground(Color.WHITE);
		panelDados.setBounds(0, 54, 558, 385);
		panelPrincipal.add(panelDados);

		JLabel lblPeso = new JLabel("Peso: ");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPeso.setBounds(10, 112, 45, 20);
		panelDados.add(lblPeso);

		JLabel lblQuilos = new JLabel("quilos(kg)");
		lblQuilos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuilos.setBounds(152, 112, 60, 20);
		panelDados.add(lblQuilos);

		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setBounds(60, 50, 215, 20);
		panelDados.add(txtNome);

		txtPeso = new JTextField();
		txtPeso.setEnabled(false);
		txtPeso.setBounds(55, 112, 86, 20);
		panelDados.add(txtPeso);

		// Vetor para níveis de atividade
		String[] nivelAtividade = { "Sedentário", "Levemente Ativo", "Moderadamente Ativo", "Bastante Ativo",
				"Muito Ativo" };

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 49, 45, 20);
		panelDados.add(lblNome);

		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblID.setBounds(10, 13, 46, 14);
		panelDados.add(lblID);

		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(40, 11, 68, 20);
		panelDados.add(txtID);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipo.setBounds(309, 50, 45, 20);
		panelDados.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setEnabled(false);
		txtTipo.setBounds(344, 50, 192, 20);
		panelDados.add(txtTipo);
		
		JLabel lblVolume = new JLabel("Volume:");
		lblVolume.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVolume.setBounds(222, 112, 108, 20);
		panelDados.add(lblVolume);
		
		txtVolume = new JTextField();
		txtVolume.setEnabled(false);
		txtVolume.setBounds(277, 113, 86, 20);
		panelDados.add(txtVolume);
		
		JLabel lblValorUnitario = new JLabel("Valor Unitario: ");
		lblValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValorUnitario.setBounds(10, 81, 98, 20);
		panelDados.add(lblValorUnitario);
		
		txtValorUnitario = new JTextField();
		txtValorUnitario.setEnabled(false);
		txtValorUnitario.setBounds(101, 82, 53, 20);
		panelDados.add(txtValorUnitario);
		
		JLabel lblRealisR = new JLabel("real(is) R$");
		lblRealisR.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRealisR.setBounds(163, 81, 60, 20);
		panelDados.add(lblRealisR);
		
		JLabel lblQtdefardo = new JLabel("Qtde. Fardo:");
		lblQtdefardo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQtdefardo.setBounds(233, 81, 108, 20);
		panelDados.add(lblQtdefardo);
		
		txtQtdeFardo = new JTextField();
		txtQtdeFardo.setEnabled(false);
		txtQtdeFardo.setBounds(315, 82, 60, 20);
		panelDados.add(txtQtdeFardo);
		
		JLabel lblQtdeestoque = new JLabel("Qtde. Estoque:");
		lblQtdeestoque.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQtdeestoque.setBounds(385, 81, 108, 20);
		panelDados.add(lblQtdeestoque);
		
		txtQtdeEstoque = new JTextField();
		txtQtdeEstoque.setEnabled(false);
		txtQtdeEstoque.setBounds(476, 82, 60, 20);
		panelDados.add(txtQtdeEstoque);
		
		JLabel lblLocalizao = new JLabel("Localiza\u00E7\u00E3o:");
		lblLocalizao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLocalizao.setBounds(10, 149, 90, 20);
		panelDados.add(lblLocalizao);
		
		txtLocalizacao = new JTextField();
		txtLocalizacao.setEnabled(false);
		txtLocalizacao.setBounds(88, 150, 86, 20);
		panelDados.add(txtLocalizacao);
		
		JLabel lblIpi = new JLabel("IPI:");
		lblIpi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIpi.setBounds(197, 148, 108, 20);
		panelDados.add(lblIpi);
		
		txtIpi = new JTextField();
		txtIpi.setEnabled(false);
		txtIpi.setBounds(232, 150, 86, 20);
		panelDados.add(txtIpi);
		
		JLabel lblDemandaMensal = new JLabel("Demanda Mensal:");
		lblDemandaMensal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDemandaMensal.setBounds(10, 186, 106, 20);
		panelDados.add(lblDemandaMensal);
		
		txtDemandaMensal = new JTextField();
		txtDemandaMensal.setEnabled(false);
		txtDemandaMensal.setBounds(126, 187, 86, 20);
		panelDados.add(txtDemandaMensal);
		
		JLabel lblTempoDeRessuprimento = new JLabel("Tempo de Ressuprimento:");
		lblTempoDeRessuprimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTempoDeRessuprimento.setBounds(233, 184, 164, 20);
		panelDados.add(lblTempoDeRessuprimento);
		
		txtTempoRessupri = new JTextField();
		txtTempoRessupri.setEnabled(false);
		txtTempoRessupri.setBounds(407, 187, 86, 20);
		panelDados.add(txtTempoRessupri);
		
		JLabel lblPontoDeRessuprimento = new JLabel("Ponto de Ressuprimento:");
		lblPontoDeRessuprimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPontoDeRessuprimento.setBounds(10, 228, 164, 20);
		panelDados.add(lblPontoDeRessuprimento);
		
		txtPontoRessupri = new JTextField();
		txtPontoRessupri.setEnabled(false);
		txtPontoRessupri.setBounds(163, 229, 86, 20);
		panelDados.add(txtPontoRessupri);
		
		JLabel lblLoteDeCompra = new JLabel("Lote de Compra:");
		lblLoteDeCompra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoteDeCompra.setBounds(276, 228, 164, 20);
		panelDados.add(lblLoteDeCompra);
		
		txtLoteDeCompra = new JTextField();
		txtLoteDeCompra.setEnabled(false);
		txtLoteDeCompra.setBounds(385, 229, 86, 20);
		panelDados.add(txtLoteDeCompra);
		
		JLabel lblEstoqueMximo = new JLabel("Estoque M\u00E1ximo:");
		lblEstoqueMximo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstoqueMximo.setBounds(10, 259, 164, 20);
		panelDados.add(lblEstoqueMximo);
		
		txtEstoqueMax = new JTextField();
		txtEstoqueMax.setEnabled(false);
		txtEstoqueMax.setBounds(112, 260, 86, 20);
		panelDados.add(txtEstoqueMax);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescrio.setBounds(10, 290, 164, 20);
		panelDados.add(lblDescrio);
		
		txtDesc = new JTextField();
		txtDesc.setEnabled(false);
		txtDesc.setBounds(10, 309, 526, 65);
		panelDados.add(txtDesc);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 558, 54);
		panelPrincipal.add(panelTitulo);
		panelTitulo.setLayout(null);
		panelTitulo.setBackground(new Color(0, 0, 102));

		JLabel lblTitulo = new JLabel("Produto");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 30));
		lblTitulo.setBounds(10, 0, 187, 67);
		panelTitulo.add(lblTitulo);
		
		//Criando um cliente
		final Produto produto = new Produto();

		

		
	}
}