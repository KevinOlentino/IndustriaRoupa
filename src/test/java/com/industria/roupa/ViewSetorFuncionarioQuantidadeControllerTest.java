package com.industria.roupa;

import com.industria.roupa.controller.ViewSetorFuncionarioQuantidadeController;
import com.industria.roupa.repositories.ViewSetorFuncionarioQuantidadeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ViewSetorFuncionarioQuantidadeControllerTest {

    @Autowired
    private ViewSetorFuncionarioQuantidadeRepository viewSetorFuncionarioQuantidadeRepository;

    @Autowired
    private ViewSetorFuncionarioQuantidadeController viewSetorFuncionarioQuantidadeController;

    @Test
    void listarTest() {
        Integer expected = (int) viewSetorFuncionarioQuantidadeRepository.count();
        Integer result = viewSetorFuncionarioQuantidadeController.listar().size();
        assertThat(result).isEqualTo(expected);
    }


}
