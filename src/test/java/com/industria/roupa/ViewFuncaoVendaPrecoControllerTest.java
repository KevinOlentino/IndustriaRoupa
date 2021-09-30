package com.industria.roupa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.industria.roupa.controller.ViewFuncaoVendaPrecoController;
import com.industria.roupa.repositories.ViewFuncaoVendaPrecoRepository;

@SpringBootTest
public class ViewFuncaoVendaPrecoControllerTest {
      
	@Autowired
	private ViewFuncaoVendaPrecoRepository viewFuncaoVendaPrecoRepository;
	
	@Autowired
	private ViewFuncaoVendaPrecoController viewFuncaoVendaPrecoController;
	
	@Test
	void listarTest() {
		Integer expected = (int) viewFuncaoVendaPrecoRepository.count();
		Integer result = viewFuncaoVendaPrecoController.listar().size();
		assertThat(result).isEqualTo(expected);
	}
	
}
