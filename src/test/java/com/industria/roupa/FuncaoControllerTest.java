package com.industria.roupa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.industria.roupa.controller.FuncaoController;
import com.industria.roupa.repositories.FuncaoRepository;

@SpringBootTest
public class FuncaoControllerTest {
	
		
	
	@Autowired
	private FuncaoRepository funcaoRepository;
	
	@Autowired
	private FuncaoController funcaoController;
	
		
	@Test
	void listarTest() {
		Integer expected = (int)funcaoRepository.count();
		Integer result = funcaoController.Get().size();
		
		assertThat(result).isEqualTo(expected);
	}
	
	

}
