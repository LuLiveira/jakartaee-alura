package br.com.alura.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(indexes = @Index(name = "idx_email_assunto_mensagem", columnList = "email, assunto, mensagem"))
public class AgendamentoEmail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;
	private String assunto;
	private String mensagem;
	private boolean agendado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean getAgendado() {
		return agendado;
	}

	public void setAgendado(boolean agendado) {
		this.agendado = agendado;
	}
	
	@Override
	public String toString() {
		return "AgendamentoEmail [id=" + id + ", email=" + email + ", assunto=" + assunto + ", mensagem=" + mensagem
				+ ", agendado=" + agendado + "]";
	}

}
