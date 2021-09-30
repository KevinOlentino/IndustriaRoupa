package com.industria.roupa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.industria.roupa.controller.ViewVendaLojaController;
import com.industria.roupa.repositories.ViewVendaLojaRepository;

@SpringBootTest
public class ViewVendaLojaControllerTest {
	
	@Autowired
	private ViewVendaLojaRepository viewVendaLojaRepository;
	
	@Autowired
	private ViewVendaLojaController viewVendaLojaController;
	
	@Test
	void listarTest() {
		  Integer expected = (int) viewVendaLojaRepository.count();
	      Integer result = viewVendaLojaController.listar().size();
	      assertThat(result).isEqualTo(expected);
	}

}
