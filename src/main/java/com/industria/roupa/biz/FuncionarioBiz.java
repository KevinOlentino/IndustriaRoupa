package com.industria.roupa.biz;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.industria.roupa.Mensagem;
import com.industria.roupa.entities.Funcionario;
import com.industria.roupa.repositories.FuncaoRepository;
import com.industria.roupa.repositories.SetorRepository;



public class FuncionarioBiz {

	public Mensagem msg;
	
	
	private SetorRepository setorRepository;
	private FuncaoRepository funcaoRepository;
	
	public FuncionarioBiz(SetorRepository setorRepository, FuncaoRepository funcaoRepository) {
		msg = new Mensagem();
		
		this.setorRepository = setorRepository;
		this.funcaoRepository = funcaoRepository;
		
		
	}
	
	public Boolean Validade(Funcionario funcionario) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formatter.parse("01/10/2020");
		
		Boolean result = true;
		if (funcionario.getNome().isEmpty()) {
			msg.mensagens.add("O nome do funcionario não pode ser vazio");
			result = false;
		}
		if (funcionario.getNome().startsWith("PP")) {
			msg.mensagens.add("O nome do funcionario é inválido");
			result = false;
		}
		
		if (setorRepository.findById( funcionario.getIdSetor() ).isEmpty()) {
			msg.mensagens.add( "O setor escolhido não é válido");
			result = false;
		}
		
		if (funcaoRepository.findById( funcionario.getIdFuncao() ).isEmpty()) {
			msg.mensagens.add( "A funcao escolhida não é válida");
			result = false;
		}
		
		if (funcionario.getSalario() < 1100) {
			msg.mensagens.add( "O salario não pode ser menor que o salario minimo");
			result = false;
		}
		
		if (funcionario.getSalario() > 10000) {
			msg.mensagens.add("O salario não pode exceder 10000");
			result = false;
		}
		
		//if (funcionario.getDatadeContratacao().before(date)) {
			//msg.mensagens.add("A data de contratacao esta inferior a data minima permitida");
			//result = false;
		//}
		
		
		return result;
	
}
}
