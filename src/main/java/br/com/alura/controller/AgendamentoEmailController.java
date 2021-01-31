package br.com.alura.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.alura.model.AgendamentoEmail;
import br.com.alura.service.AgendamentoEmailService;

@Path("emails")
public class AgendamentoEmailController {

	@Inject
	private AgendamentoEmailService agendamentoEmailService;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	protected Response listar() throws ServletException, IOException {
		return Response.ok(agendamentoEmailService.listar()).build();
	}
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	protected Response inserir(AgendamentoEmail agendamentoEmail) throws ServletException, IOException {
		agendamentoEmailService.inserir(agendamentoEmail);
		return Response.status(201).build();
		
	}
}
