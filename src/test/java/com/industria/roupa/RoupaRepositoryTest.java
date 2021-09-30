package com.industria.roupa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.industria.roupa.entities.Roupa;
import com.industria.roupa.repositories.RoupaRepository;

@SpringBootTest
public class RoupaRepositoryTest {
	
	@Autowired
	private RoupaRepository roupaRepository;
	
	
	
	@Test
	public void ListarTest() {
		
		Integer expected = -1;
		Integer result = (int) roupaRepository.count();
		assertThat(result).isGreaterThan(expected);
	
	}
	
	@Test
	public void SaveTest() {
		
		Integer expected = (int) roupaRepository.count()+1;
		
		Roupa nova = new Roupa();
		nova.setMedida(8);
		nova.setPreco(44);
		nova.setNome("Manta Acrilica");
		roupaRepository.save(nova);
		roupaRepository.flush();
		
		Integer result = (int)roupaRepository.count();
		assertThat(result).isEqualTo(expected);
		
		
	}
	
	

}
