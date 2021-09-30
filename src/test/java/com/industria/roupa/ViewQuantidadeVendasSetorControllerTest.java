package com.industria.roupa;

import com.industria.roupa.controller.ViewQuantidadeTecidoController;
import com.industria.roupa.controller.ViewQuantidadeVendasSetorController;
import com.industria.roupa.repositories.ViewQuantidadeVendasSetorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ViewQuantidadeVendasSetorControllerTest {

    @Autowired
    private ViewQuantidadeVendasSetorRepository viewQuantidadeVendasSetorRepository;

    @Autowired
    private ViewQuantidadeVendasSetorController viewQuantidadeVendasSetorController;

    @Test
    void listarTest() {
        Integer expected = (int) viewQuantidadeVendasSetorRepository.count();
        Integer result = viewQuantidadeVendasSetorController.listar().size();
        assertThat(result).isEqualTo(expected);
    }
}
