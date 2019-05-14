package br.com.senaijandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.senaijandira.dbutils.Conexao;
import br.com.senaijandira.model.Produto;

public class ProdutoDAO {
	
	private Produto produto;
	private PreparedStatement stmt; //comando sql
	private ResultSet rs = null; //retorno do db
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	//retorna todos os registros inseridos no banco
	public ArrayList<Produto> selectAll(){
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		String sql = "SELECT * FROM tbl_produto ORDER BY nome";
		
		try {
			stmt = Conexao.getConnection().prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			//enquanto os dados forem retornados
			while (rs.next()) {
				Produto produto = new Produto();
				
				produto.setIdProduto(rs.getInt("id_produto"));
				
				produto.setNome(rs.getString("nome"));
				System.out.println(produto.getNome());
				produto.setUnidadeMedida(rs.getDouble("unidade_medida"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setImagem(rs.getString("imagem"));
				
				produto.setValorUnitario(rs.getDouble("valor_unitario"));
				produto.setNome(rs.getString("nome"));
				produto.setUnidadeMedida(rs.getDouble("unidade_medida"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setImagem(rs.getString("imagem"));
				
				
				produto.setQtdeFardo((rs.getInt("qtd_fardo")));
				produto.setQtdeEstoque(rs.getInt("qtd_estoque"));
				produto.setPeso(rs.getDouble("peso"));
				produto.setVolume(rs.getDouble("volume"));
				produto.setStatus(rs.getInt("status"));
				
				produto.setLocalizacao(rs.getString("localizacao"));
				produto.setIpi(rs.getDouble("ipi"));
				produto.setDemandaMensal(rs.getDouble("demanda_mensal"));
				produto.setTempoRessuprimento(rs.getInt("tempo_ressuprimento"));
				produto.setIntervaloRessuprimento(rs.getInt("intervalo_ressuprimento"));
				produto.setEstoqueSeguranca(rs.getInt("estoque_seguranca"));
				produto.setPontoRessuprimento(rs.getInt("ponto_ressuprimento"));
				produto.setLoteCompras(rs.getInt("lote_compras"));
				produto.setEstoqueMaximo(rs.getInt("estoque_maximo"));
				produto.setTipoProduto(rs.getString("tipo_produto"));
				produto.setStatusHome(rs.getInt("status_home"));
				
				produtos.add(produto);
				
				
			}
			
			
		} catch (Exception erro) {
			System.out.println(erro.getMessage());

			JOptionPane.showMessageDialog(null,
					"Não foi " + "possível fazer a consulta. Por Favor," + "tente novamente mais tarde. ", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
		
		return produtos;
	}
	
	public Produto selectById(int idProduto) {
		String sql = "SELECT * FROM tbl_produto WHERE id_produto=?";
		Produto produto = new Produto();
		
		try {
			stmt = Conexao.getConnection().prepareStatement(sql);
			stmt.setInt(1, idProduto);
			rs = stmt.executeQuery();
			
			rs.next();
			//enquanto os dados forem retornados
		
				produto = new Produto();
				
				produto.setIdProduto(rs.getInt("id_produto"));
				
				produto.setNome(rs.getString("nome"));
				System.out.println(produto.getNome());
				produto.setUnidadeMedida(rs.getDouble("unidade_medida"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setImagem(rs.getString("imagem"));
				
				produto.setValorUnitario(rs.getDouble("valor_unitario"));
				produto.setNome(rs.getString("nome"));
				produto.setUnidadeMedida(rs.getDouble("unidade_medida"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setImagem(rs.getString("imagem"));
				
				
				produto.setQtdeFardo((rs.getInt("qtd_fardo")));
				produto.setQtdeEstoque(rs.getInt("qtd_estoque"));
				produto.setPeso(rs.getDouble("peso"));
				produto.setVolume(rs.getDouble("volume"));
				produto.setStatus(rs.getInt("status"));
				
				produto.setLocalizacao(rs.getString("localizacao"));
				produto.setIpi(rs.getDouble("ipi"));
				produto.setDemandaMensal(rs.getDouble("demanda_mensal"));
				produto.setTempoRessuprimento(rs.getInt("tempo_ressuprimento"));
				produto.setIntervaloRessuprimento(rs.getInt("intervalo_ressuprimento"));
				produto.setEstoqueSeguranca(rs.getInt("estoque_seguranca"));
				produto.setPontoRessuprimento(rs.getInt("ponto_ressuprimento"));
				produto.setLoteCompras(rs.getInt("lote_compras"));
				produto.setEstoqueMaximo(rs.getInt("estoque_maximo"));
				produto.setTipoProduto(rs.getString("tipo_produto"));
				produto.setStatusHome(rs.getInt("status_home"));
				
			
				
		
		
			
		} catch (Exception erro) {
			System.out.println(erro.getMessage());

			JOptionPane.showMessageDialog(null,
					"Não foi " + "possível fazer a consulta. Por Favor," + "tente novamente mais tarde. ", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return produto;
	}
}
