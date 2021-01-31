package br.com.alura.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.alura.model.AgendamentoEmail;
import br.com.alura.repository.AgendamentoEmailRepository;

@Stateless
public class AgendamentoEmailService {

	@Inject
	private AgendamentoEmailRepository agendamentoEmailRepository;
	
	public List<AgendamentoEmail> listar(){
		return agendamentoEmailRepository.listar();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail) {
		agendamentoEmailRepository.inserir(agendamentoEmail);
	}

	public List<AgendamentoEmail> listarPorNaoAgendado() {
		return agendamentoEmailRepository.listarPorNaoAgendado();
	}
	
}
