package com.industria.roupa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.industria.roupa.controller.RoupaController;
import com.industria.roupa.repositories.RoupaRepository;

@SpringBootTest
class RoupaControllerTest {

	@Autowired
	private RoupaRepository roupaRepository;
	
	@Autowired
	private RoupaController roupaController;
	
	@Test
	void listarTest() {
		Integer expected = (int)roupaRepository.count();
		Integer result = roupaController.listar().size();
		assertThat(result).isEqualTo(expected);
	}
	
}
