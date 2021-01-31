package br.com.alura.repository;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.alura.model.AgendamentoEmail;

@Stateful
public class AgendamentoEmailRepository {

	@PersistenceContext
	private EntityManager manager;
	
	public List<AgendamentoEmail> listar(){
		return this.manager.createQuery(" SELECT ae FROM AgendamentoEmail ae ", AgendamentoEmail.class).getResultList();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail) {
		this.manager.persist(agendamentoEmail);
	}

	public List<AgendamentoEmail> listarPorNaoAgendado() {
		return manager.createQuery(" SELECT ae FROM AgendamentoEmail ae WHERE ae.agendado = false ", AgendamentoEmail.class).getResultList();
	}
}
