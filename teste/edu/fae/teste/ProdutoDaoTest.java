package edu.fae.teste;

import org.junit.Test;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.ProdutoDao;
import edu.fae.model.Produto;

public class ProdutoDaoTest {

	@Test
	public void testSave() {
		Produto produto = new Produto();
		produto.setNome("produto nome 1");
		produto.setValor(25.25);
		
		ProdutoDao dao = DaoFactory.getProdutoDao();
		
		dao.save(produto);
	}

}
