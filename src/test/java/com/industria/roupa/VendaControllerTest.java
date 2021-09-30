package com.industria.roupa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.industria.roupa.controller.VendaController;
import com.industria.roupa.entities.Venda;
import com.industria.roupa.repositories.VendaRepository;

@SpringBootTest
public class VendaControllerTest {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	 private VendaController vendaController;
	
	
	@Test
	void listarTest() {
		Integer expected = (int)vendaRepository.count();
		Integer result = vendaController.Get().size();
		assertThat(result).isEqualTo(expected);
	}
	
	@Test
	void incluirTest() {
		Venda venda = new Venda();
		Integer expected = (int) vendaRepository.count()+1;
		venda.setIdFuncionario(2);
		venda.setIdLoja(1);
		venda.setIdRoupa(1);
		vendaController.incluir(venda);
		Integer result = (int)vendaRepository.count();
		assertThat(result).isEqualTo(expected);
	}
	
	@Test
	void alterarTest() {
		
		Venda venda = vendaController.consultar(3);
		venda.setIdRoupa(1);
		venda.setIdLoja(2);
		venda.setIdFuncionario(2);
		vendaController.alterar(venda);
		Venda vendaTest = vendaController.consultar(3);
		
		assertThat(venda.getIdRoupa()).isEqualTo(vendaTest.getIdRoupa());
		assertThat(venda.getIdLoja()).isEqualTo(vendaTest.getIdLoja());
		assertThat(venda.getIdFuncionario()).isEqualTo(vendaTest.getIdFuncionario());
	}
	
	@Test
	void consultarTest(){
		
		Venda venda = new Venda();
		venda.setIdVenda(3);
		venda.setIdRoupa(1);
		venda.setIdLoja(2);
		venda.setIdFuncionario(2);
		Venda vendaTest = vendaController.consultar(3);
		
		assertThat(venda.getIdVenda()).isEqualTo(vendaTest.getIdVenda());
		assertThat(venda.getIdRoupa()).isEqualTo(vendaTest.getIdRoupa());
		assertThat(venda.getIdLoja()).isEqualTo(vendaTest.getIdLoja());
		assertThat(venda.getIdLoja()).isEqualTo(vendaTest.getIdLoja());
	}
}
