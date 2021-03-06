package com.industria.roupa.biz;

import com.industria.roupa.Mensagem;
import com.industria.roupa.entities.RoupaTecido;
import com.industria.roupa.repositories.RoupaRepository;
import com.industria.roupa.repositories.TecidoRepository;

public class RoupaTecidoBiz {
	public Mensagem msg;

	private RoupaRepository roupaRepository;

	private TecidoRepository tecidoRepository;

	public RoupaTecidoBiz(RoupaRepository roupaRepository, TecidoRepository tecidoRepository) {
		msg = new Mensagem();
		this.roupaRepository = roupaRepository;
		this.tecidoRepository = tecidoRepository;
	}

	public Boolean Validade(RoupaTecido roupaTecido) {

		boolean result = true;
		if (!roupaRepository.existsById(roupaTecido.getIdRoupa())) {
			msg.mensagens.add("Esta roupa não existe");
			result = false;
		}
		if (!tecidoRepository.existsById(roupaTecido.getIdTecido())) {
			msg.mensagens.add("Este tecido não existe");
			result = false;
		}

		return result;

	}
	
}
