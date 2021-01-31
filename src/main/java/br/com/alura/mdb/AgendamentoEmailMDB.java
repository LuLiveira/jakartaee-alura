package br.com.alura.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.management.RuntimeErrorException;

import br.com.alura.model.AgendamentoEmail;
import br.com.alura.service.AgendamentoEmailService;


@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/EmailQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class AgendamentoEmailMDB implements MessageListener {


	@Inject
	private AgendamentoEmailService agendamentoEmailService;
	
	
	@Override
	public void onMessage(Message message) {
		
		try {
			AgendamentoEmail agendamentoEmail = message.getBody(AgendamentoEmail.class);
//			agendamentoEmailService.enviar(agendamentoEmail);
			System.out.println("PEGANDO O E-MAIL " + agendamentoEmail.getEmail());
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
		
	}

}
