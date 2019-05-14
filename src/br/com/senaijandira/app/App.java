package br.com.senaijandira.app;

import br.com.senaijandira.dao.ProdutoDAO;


public class App {

	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();
		dao.selectById(11);
	}

}
