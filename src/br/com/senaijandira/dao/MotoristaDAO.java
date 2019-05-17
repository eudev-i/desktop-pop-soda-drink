package br.com.senaijandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.senaijandira.dbutils.Conexao;
import br.com.senaijandira.model.Fornecedor;
import br.com.senaijandira.model.Motorista;

public class MotoristaDAO {
	private Motorista motorista;
	private PreparedStatement stmt; //comando sql
	private ResultSet rs = null; //retorno do db
	
	public void setFornecedor(Motorista motorista) {
		this.motorista = motorista;
	}
	
	//retorna todos os registros inseridos no banco
		public ArrayList<Motorista> selectAll(){
			ArrayList<Motorista> motoristas = new ArrayList<Motorista>();
			String sql = "SELECT * FROM tbl_motorista ORDER BY nome";
			
			try {
				stmt = Conexao.getConnection().prepareStatement(sql);
				
				rs = stmt.executeQuery();
				
				//enquanto os dados forem retornados
				while (rs.next()) {
					Motorista motorista = new Motorista();
					
					motorista.setIdMotorista(rs.getInt("id_motorista"));
					motorista.setIdVeiculo(rs.getInt("id_veiculo"));
					motorista.setNome(rs.getString("nome"));
					motorista.setCpf(rs.getString("cpf"));
					motorista.setHabilitacao(rs.getString("habilitacao"));
					motorista.setCategoria(rs.getString("categoria"));
					motorista.setValidade(rs.getDate("validade"));
					motorista.setStatus(rs.getInt("status"));
				}
				
				
			} catch (Exception erro) {
				System.out.println(erro.getMessage());

				JOptionPane.showMessageDialog(null,
						"Não foi " + "possível fazer a consulta. Por Favor," + "tente novamente mais tarde. ", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			
			
			return motoristas;
		}
		
		public Motorista selectById(int idMotorista) {
			String sql = "SELECT * FROM tbl_motorista WHERE id_motorista=?";
			
			
			try {
				stmt = Conexao.getConnection().prepareStatement(sql);
				stmt.setInt(1, idMotorista);
				rs = stmt.executeQuery();
				
				rs.next();
				//enquanto os dados forem retornados
			
				Motorista motorista = new Motorista();
				
				motorista.setIdMotorista(rs.getInt("id_motorista"));
				motorista.setIdVeiculo(rs.getInt("id_veiculo"));
				motorista.setNome(rs.getString("nome"));
				motorista.setCpf(rs.getString("cpf"));
				motorista.setHabilitacao(rs.getString("habilitacao"));
				motorista.setCategoria(rs.getString("categoria"));
				motorista.setValidade(rs.getDate("validade"));
				motorista.setStatus(rs.getInt("status"));
			} catch (Exception erro) {
				System.out.println(erro.getMessage());

				JOptionPane.showMessageDialog(null,
						"Não foi " + "possível fazer a consulta. Por Favor," + "tente novamente mais tarde. ", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			return motorista;
		}
		
		//----PAREI AQUI-------------------
		public void insert() {
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
				e.printStackTrace();
			}
		}
		
		public void update(Fornecedor fornecedor, int idFornecedor) {
			// Instrução para inserir o registro
			String sql = "UPDATE `db_popsoda`.`tbl_fornecedor`" + 
					"SET" + 
					"`cnpj` = ?" + 
					"`razao_social` = ?" + 
					"`nome_fantasia` = ?" + 
					"`telefone` = ?" + 
					"`email` = ?" + 
					"`status` = ?" + 
					"WHERE `id_fornecedor` = ?";

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
				
				stmt.setInt(7, fornecedor.getIdFornecedor());
				// Executa a query
				stmt.execute();

				// Fecha conexão
				stmt.close();

				// Exibe uma mensagem de sucesso
				JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso!");
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		public void delete(int idFornecedor) 
		{
			// Instrução para deletar o registro
			String sql = "DELETE FROM tbl_fornecedor WHERE id_fornecedor = ?";

			try 
			{
				// Prepara a instrução antes que seja executada
				stmt = Conexao.getConnection().prepareStatement(sql);

				// Passa os parâmetros da instrunção
				stmt.setInt(1, idFornecedor);

				// Executa a query
				stmt.execute();

				// Fecha conexão
				stmt.close();

				// Exibe uma mensagem de sucesso
				JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!");
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
}
