package com.industria.roupa;



import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.industria.roupa.controller.FuncionarioController;
import com.industria.roupa.entities.Funcionario;
import com.industria.roupa.entities.RoupaTecido;
import com.industria.roupa.repositories.FuncionarioRepository;

@SpringBootTest
class FuncionarioControllerTest {
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioController funcionarioController;

	@Test
	void listarTest() {
		
		Integer expected = (int)funcionarioRepository.count();
		Integer result = funcionarioController.listar().size();
		assertThat(result).isEqualTo(expected);
	}
	
	@Test
    void incluirTeste(){
        Integer expected = (int)funcionarioRepository.count()+1;
        System.out.println(expected);

        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(0);
        funcionario.setNome("Joao");
        funcionario.setCpf("85685937806");
        funcionario.setIdSetor(3);
        funcionario.setEmail("joao@hotmail.com");
        funcionario.setSalario(2000.00);
        funcionario.setIdFuncao(3);
        funcionario.setDatadeContratacao(new Date("2020/10/10"));
        
  

        funcionarioController.incluir(funcionario);

        Integer result = (int)funcionarioRepository.count();

        assertThat(result).isEqualTo(expected);
    }
	
	@Test
    void alterarTeste(){
        Funcionario funcionario = funcionarioController.Consultar(3);	
        
        funcionario.setNome("Joao");
        funcionario.setCpf("85685937806");
        funcionario.setIdSetor(3);
        funcionario.setEmail("joao@hotmail.com");
        funcionario.setSalario(2000.00);
        funcionario.setIdFuncao(3);
 
        	 funcionario.setDatadeContratacao(new Date("2020/10/01"));
    

        System.out.println(funcionario.getIdfuncionario());

        Mensagem mensagem = funcionarioController.alterar(funcionario);
        System.out.println(mensagem.getMensagens()); 
        Funcionario funcionarioTest = funcionarioController.Consultar(3);

        assertThat(funcionario.getNome()).isEqualTo(funcionarioTest.getNome());
        assertThat(funcionario.getCpf()).isEqualTo(funcionarioTest.getCpf());
        assertThat(funcionario.getIdSetor()).isEqualTo(funcionarioTest.getIdSetor());
        assertThat(funcionario.getEmail()).isEqualTo(funcionarioTest.getEmail());
        assertThat(funcionario.getSalario()).isEqualTo(funcionarioTest.getSalario());
        assertThat(funcionario.getIdFuncao()).isEqualTo(funcionarioTest.getIdFuncao());
        assertThat(funcionario.getDatadeContratacao()).isEqualTo(funcionarioTest.getDatadeContratacao());
    }
	
	@Test
    void ConsultarTest(){
        Integer Expected = 5;
        Funcionario funcionario = funcionarioController.Consultar(5);

        assertThat(funcionario.getIdfuncionario()).isEqualTo(Expected);

    }

}
