package com.industria.roupa;


import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.industria.roupa.controller.FuncaoController;
import com.industria.roupa.entities.Funcao;
import com.industria.roupa.entities.RoupaTecido;
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
	
	 @Test
	    void incluirTeste(){
	        Integer expected = (int)funcaoRepository.count()+1;
	        System.out.println(expected);

	        Funcao funcao = new Funcao();
	        funcao.setNome("Analista");
	        
	        funcaoController.incluir(funcao);

	        Integer result = (int)funcaoRepository.count();

	        assertThat(result).isEqualTo(expected);
	    }

	 
	 	@Test
	    void alterarTeste(){
	        Funcao funcao = funcaoController.Consultar(2);
	        funcao.setIdFuncao(2);
	        
	        System.out.println(funcao.getIdFuncao());

	        funcaoController.alterar(funcao);
	        Funcao funcaoTest = funcaoController.Consultar(2);

	        assertThat(funcao.getIdFuncao()).isEqualTo(funcaoTest.getIdFuncao());
	        
	    }
	 	
	 	 @Test
	     void ConsultarTest(){
	         Integer Expected = 5;
	         Funcao funcao = funcaoController.Consultar(5);

	         assertThat(funcao.getIdFuncao()).isEqualTo(Expected);

	     }
}
