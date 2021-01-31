package br.com.alura.jobs;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import br.com.alura.model.AgendamentoEmail;
import br.com.alura.service.AgendamentoEmailService;

@Singleton
public class AgendamentoEmailJob {

	@Inject
	private AgendamentoEmailService agendamentoEmailService;
	
	@Inject
	@JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
	private JMSContext context;
	
	@Resource(mappedName = "java:/jms/queue/EmailQueue")
	private Queue queue;
	
	
	@Schedule(hour = "*", minute = "*", second = "*/10")
	public void enviarEmail() {
		
		List<AgendamentoEmail> listaDeNaoAgendado = agendamentoEmailService.listarPorNaoAgendado();
		
		listaDeNaoAgendado.forEach(email -> {
			context.createProducer().send(queue, email);
//			agendamentoEmailService.alterar(email);
		});
		
		
	}
}
