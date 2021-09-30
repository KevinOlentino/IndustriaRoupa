package com.industria.roupa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.industria.roupa.controller.TecidoController;
import com.industria.roupa.entities.Funcao;
import com.industria.roupa.entities.Tecido;
import com.industria.roupa.repositories.TecidoRepository;

@SpringBootTest
public class TecidoTest {
	
	@Autowired
	private TecidoRepository tecidoRepository;
	
	@Autowired
	private TecidoController tecidoController;
	
		
	@Test
	void listarTest() {
		Integer expected = (int)tecidoRepository.count();
		Integer result = tecidoController.listar().size();
		
		assertThat(result).isEqualTo(expected);
	}
	
	@Test
    void incluirTeste(){
        Integer expected = (int)tecidoRepository.count()+1;
        System.out.println(expected);

        Tecido tecido = new Tecido();
        tecido.setNome("Tecido Azul Marinho");
        
        tecidoController.incluir(tecido);

        Integer result = (int)tecidoRepository.count();

        assertThat(result).isEqualTo(expected);
    }
	@Test
    void alterarTeste(){
		Tecido tecido = tecidoController.consultar(2);
        tecido.setIdtecido(2);
        
        System.out.println(tecido.getIdtecido());

        tecidoController.alterar(tecido);
        Tecido tecidoTest = tecidoController.consultar(2);

        assertThat(tecido.getIdtecido()).isEqualTo(tecidoTest.getIdtecido());
        
    }
	@Test
    void ConsultarTest(){
        Integer Expected = 5;
        Tecido tecido = tecidoController.consultar(5);

        assertThat(tecido.getIdtecido()).isEqualTo(Expected);

    }
	

}
