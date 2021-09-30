package com.industria.roupa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.industria.roupa.controller.LojaController;
import com.industria.roupa.entities.Loja;
import com.industria.roupa.repositories.LojaRepository;

@SpringBootTest
class LojaControllerTest {

	@Autowired
	private LojaRepository lojaRepository;
	
	@Autowired
	private LojaController lojaController;
	
	@Test
	void listarTest() {
		Integer expected = (int)lojaRepository.count();
		Integer result = lojaController.Get().size();
		assertThat(result).isEqualTo(expected);
	}
	
	@Test
	void incluirTest() {
		Loja loja = new Loja();
		Integer expected = (int) lojaRepository.count()+1;
		loja.setIdloja(0);
		loja.setNome("Moda e acesssorio");
		loja.setCredito(1000.00);
		lojaController.incluir(loja);
		Integer result = (int)lojaRepository.count();
		assertThat(result).isEqualTo(expected);
	}
	
	@Test
	void alterarTest() {
		
		Loja loja = lojaController.consultar(1);
		loja.setNome("Modas");
		loja.setCredito(20000.00);
		lojaController.alterar(loja);
		Loja lojaTest = lojaController.consultar(1);
		
		assertThat(loja.getNome()).isEqualTo(lojaTest.getNome());
		assertThat(loja.getCredito()).isEqualTo(lojaTest.getCredito());
	}
	
	@Test
	void consultarTest(){
		
		Loja loja = new Loja();
		loja.setIdloja(1);
		loja.setNome("Modas");
		loja.setCredito(20000.00);
		Loja lojaTest = lojaController.consultar(1);
		
		assertThat(loja.getIdloja()).isEqualTo(lojaTest.getIdloja());
		assertThat(loja.getNome()).isEqualTo(lojaTest.getNome());
		assertThat(loja.getCredito()).isEqualTo(lojaTest.getCredito());
		
	}

}
