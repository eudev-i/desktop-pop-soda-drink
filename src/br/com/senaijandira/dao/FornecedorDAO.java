package br.com.senaijandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.senaijandira.dbutils.Conexao;
import br.com.senaijandira.model.Fornecedor;

public class FornecedorDAO {
	
	private Fornecedor fornecedor;
	private PreparedStatement stmt; //comando sql
	private ResultSet rs = null; //retorno do db
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	//retorna todos os registros inseridos no banco
		public ArrayList<Fornecedor> selectAll(){
			ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
			String sql = "SELECT * FROM tbl_fornecedor ORDER BY nome_fantasia";
			
			try {
				stmt = Conexao.getConnection().prepareStatement(sql);
				
				rs = stmt.executeQuery();
				
				//enquanto os dados forem retornados
				while (rs.next()) {
					Fornecedor fornecedor = new Fornecedor();
					
					fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
					fornecedor.setCnpj(rs.getString("cnpj"));
					fornecedor.setNomeFantasia(rs.getString("nome_fantasia"));
					fornecedor.setRazaoSocial(rs.getString("razao_social"));
					fornecedor.setTelefone(rs.getString("telefone"));
					fornecedor.setEmail(rs.getString("email"));
					fornecedor.setStatus(rs.getInt("status"));
					
					fornecedores.add(fornecedor);
					System.out.println(fornecedor.getEmail());
				}
				
				
			} catch (Exception erro) {
				System.out.println(erro.getMessage());

				JOptionPane.showMessageDialog(null,
						"Não foi " + "possível fazer a consulta. Por Favor," + "tente novamente mais tarde. ", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			
			
			return fornecedores;
		}
		
		public Fornecedor selectById(String cnpj) {
			String sql = "SELECT * FROM tbl_fornecedor WHERE cnpj=?";
			Fornecedor fornecedor = new Fornecedor();
			
			try {
				stmt = Conexao.getConnection().prepareStatement(sql);
				stmt.setString(1, cnpj);
				rs = stmt.executeQuery();
				
				rs.next();
				//enquanto os dados forem retornados
			
					fornecedor = new Fornecedor();
					
					fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
					fornecedor.setCnpj(rs.getString("cnpj"));
					fornecedor.setNomeFantasia(rs.getString("nome_fantasia"));
					fornecedor.setRazaoSocial(rs.getString("razao_social"));
					fornecedor.setTelefone(rs.getString("telefone"));
					fornecedor.setEmail(rs.getString("email"));
					fornecedor.setStatus(rs.getInt("status"));
					
			} catch (Exception erro) {
				System.out.println(erro.getMessage());

				JOptionPane.showMessageDialog(null,
						"Não foi " + "possível fazer a consulta. Por Favor," + "tente novamente mais tarde. ", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			return fornecedor;
		}
		
		public void insert(Fornecedor fornecedor) {
			// Instrução para inserir o registro
			String sql = "INSERT INTO `db_popsoda`.`tbl_fornecedor`" + 
					"(`id_fornecedor`," + 
					"`cnpj`," + 
					"`razao_social`," + 
					"`nome_fantasia`," + 
					"`telefone`," + 
					"`email`," + 
					"`status`) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

			try 
			{
				
				// Prepara a instrução antes que seja executada
				stmt = Conexao.getConnection().prepareStatement(sql);

				// Passa os parâmetros da instrunção
				stmt.setInt(1, fornecedor.getIdFornecedor());
				stmt.setString(2, fornecedor.getCnpj());
				stmt.setString(3, fornecedor.getRazaoSocial());
				stmt.setString(4, fornecedor.getNomeFantasia());
				stmt.setString(5, fornecedor.getTelefone());	
				stmt.setString(6, fornecedor.getEmail());
				stmt.setInt(7, fornecedor.getStatus());
				// Executa a query
				stmt.execute();

				// Fecha conexão
				stmt.close();

				// Exibe uma mensagem de sucesso
				JOptionPane.showMessageDialog(null, "Fornecedor gravado com sucesso!");
			} catch (SQLException e) 
			{
				JOptionPane.showMessageDialog(null,
						"Não foi " + "possível inserir um novo registro. Por Favor," + " tente novamente mais tarde. ", "Error",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		
		public void update(Fornecedor fornecedor, String idFornecedor) {
			// Instrução para inserir o registro
			String sql = "UPDATE `db_popsoda`.`tbl_fornecedor`" + 
					"SET" + 
					"`cnpj` = ?" + 
					",`razao_social` = ?" + 
					",`nome_fantasia` = ?" + 
					",`telefone` = ?" + 
					",`email` = ?" + 
					",`status` = ?" + 
					" WHERE cnpj = ?";

			try 
			{
				
				// Prepara a instrução antes que seja executada
				stmt = Conexao.getConnection().prepareStatement(sql);

				// Passa os parâmetros da instrunção
				
				stmt.setString(1, fornecedor.getCnpj());
				stmt.setString(2, fornecedor.getRazaoSocial());
				stmt.setString(3, fornecedor.getNomeFantasia());
				stmt.setString(4, fornecedor.getTelefone());	
				stmt.setString(5, fornecedor.getEmail());
				stmt.setInt(6, fornecedor.getStatus());
				
				stmt.setString(7, fornecedor.getCnpj());
				// Executa a query
				stmt.execute();

				// Fecha conexão
				stmt.close();

				// Exibe uma mensagem de sucesso
				JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso!");
			} catch (SQLException e) 
			{
				JOptionPane.showMessageDialog(null,
						"Não foi " + "possível atualizar o registro. Por Favor," + " tente novamente mais tarde. ", "Error",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		
		public void delete(String idFornecedor) 
		{
			// Instrução para deletar o registro
			String sql = "DELETE FROM tbl_fornecedor WHERE cnpj = ?";

			try 
			{
				// Prepara a instrução antes que seja executada
				stmt = Conexao.getConnection().prepareStatement(sql);

				// Passa os parâmetros da instrunção
				stmt.setString(1, idFornecedor);

				// Executa a query
				stmt.execute();

				// Fecha conexão
				stmt.close();

				// Exibe uma mensagem de sucesso
				JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!");
			} catch (SQLException e) 
			{
				JOptionPane.showMessageDialog(null,
						"Não foi " + "possível excluir o registro. Por Favor," + " tente novamente mais tarde. ", "Error",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
}
