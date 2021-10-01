package com.industria.roupa;

import static org.assertj.core.api.Assertions.assertThat;
import com.industria.roupa.biz.LojaBiz;
import com.industria.roupa.controller.LojaController;
import com.industria.roupa.entities.Funcionario;
import com.industria.roupa.entities.Loja;
import com.industria.roupa.repositories.LojaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class LojaBizTest {


    public Mensagem msg;

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private LojaController lojaController;


    @Test
    void listarBizTest() {

        Integer expected = (int)lojaRepository.count();
        Integer result = lojaController.Get().size();
        assertThat(result).isEqualTo(expected);
    }

        @Test
        void ConsultarBizTest(){
            Integer Expected = 11;
            Loja loja = lojaController.consultar(11);

            assertThat(loja.getIdloja()).isEqualTo(Expected);

    }


}
