package com.industria.roupa;

import com.industria.roupa.controller.ViewQuantidadeTecidoController;
import com.industria.roupa.repositories.ViewQuantidadeTecidoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class QuantidadeTecidoControllerTest {

    @Autowired
    private ViewQuantidadeTecidoRepository viewQuantidadeTecidoRepository;

    @Autowired
    private ViewQuantidadeTecidoController viewQuantidadeTecidoController;

    @Test
    void listarTest() {
        Integer expected = (int) viewQuantidadeTecidoRepository.count();
        Integer result = viewQuantidadeTecidoController.listar().size();
        assertThat(result).isEqualTo(expected);
    }
}
