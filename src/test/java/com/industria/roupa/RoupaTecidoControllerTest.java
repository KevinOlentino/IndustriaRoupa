package com.industria.roupa;


import com.industria.roupa.controller.RoupaTecidoController;
import com.industria.roupa.entities.RoupaTecido;
import com.industria.roupa.repositories.RoupaRepository;
import com.industria.roupa.repositories.RoupaTecidoRepository;
import com.industria.roupa.repositories.TecidoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RoupaTecidoControllerTest {

    @Autowired
    private RoupaTecidoRepository roupaTecidoRepository;

    @Autowired
    private TecidoRepository tecidoRepository;

    @Autowired
    private RoupaRepository roupaRepository;

    @Autowired
    private RoupaTecidoController roupaTecidoController;

    @Test
    void listarTeste(){
        Integer expected = (int)roupaTecidoRepository.count();
        Integer result = (int) roupaTecidoController.Get().size();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void incluirTeste(){
        Integer expected = (int)roupaTecidoRepository.count()+1;
        System.out.println(expected);

        RoupaTecido roupaTecido = new RoupaTecido();
        roupaTecido.setIdRoupaTecido(0);
        roupaTecido.setIdRoupa(1);
        roupaTecido.setIdTecido(1);

        roupaTecidoController.incluir(roupaTecido);

        Integer result = (int)roupaTecidoRepository.count();

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void alterarTeste(){
        RoupaTecido roupaTecido = roupaTecidoController.Consultar(3);
        roupaTecido.setIdTecido(9);
        roupaTecido.setIdRoupa(3);

        roupaTecidoController.alterar(roupaTecido);
        RoupaTecido roupaTest = roupaTecidoController.Consultar(3);

        assertThat(roupaTecido.getIdRoupa()).isEqualTo(roupaTest.getIdRoupa());
        assertThat(roupaTecido.getIdTecido()).isEqualTo(roupaTest.getIdTecido());
    }

    @Test
    void ConsultarTest(){
        Integer Expected = 5;
        RoupaTecido roupaTecido = roupaTecidoController.Consultar(5);

        assertThat(roupaTecido.getIdRoupaTecido()).isEqualTo(Expected);

    }
    
}
