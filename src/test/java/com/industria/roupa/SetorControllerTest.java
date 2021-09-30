package com.industria.roupa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.industria.roupa.controller.SetorController;
import com.industria.roupa.entities.Setor;
import com.industria.roupa.repositories.SetorRepository;

@SpringBootTest
class SetorControllerTest {
	
	@Autowired
	private SetorRepository setorRepository;
	
	@Autowired
	private SetorController setorController;
	
	@Test
	void listarTest() {
		Integer expected = (int)setorRepository.count();
		Integer result = setorController.Get().size();
		assertThat(result).isEqualTo(expected);
	}
	
	@Test
	void incluirTest() {
		Setor setor = new Setor();
		setor.setIdSetor(0);
	    setor.setNome("Recreacao");
		Integer expected = (int)setorRepository.count()+1;
		setorController.incluir(setor);
		Integer result = (int)setorRepository.count();
		assertThat(result).isEqualTo(expected);
	}
	
	@Test
	void alterarTest() {
		Setor setor = setorController.Consultar(3);	
		setor.setNome("Moises");		
		setorController.alterar(setor);		
		Setor setorTest = setorController.Consultar(3);	
		assertThat(setor.getNome()).isEqualTo(setor.getNome());
	}
	
	@Test
	void consultaTest() {
		Setor setor = new Setor();
		setor.setIdSetor(3);
		setor.setNome("Recepcao");		
		Setor setorTest = setorController.Consultar(3);		
		assertThat(setor.getNome()).isEqualTo(setorTest.getNome());
		}
	


}
