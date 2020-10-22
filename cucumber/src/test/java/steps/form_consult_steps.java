package steps;

import org.junit.Assert;
import org.junit.Test;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.consult_pages;

public class form_consult_steps {
	

	 @Test
	
	@Dado("^o endereço da APi de consulta$")
	 	public void o_endereço_da_APi_de_consulta() throws Throwable {
		 	pages.consult_pages consult_pages = new consult_pages();
		 	consult_pages.o_endereço_da_APi_de_consulta();
	}
	
	@Quando("^eu envio o número do telefone inexistente$")
		public void eu_envio_o_número_do_telefone_inexistente() throws Throwable {
			pages.consult_pages consult_pages = new consult_pages();
			consult_pages.eu_envio_o_número_do_telefone_inexistente();
	}
	
	@Quando("^eu envio o número do telefone cadastrado no sistema$")
		public void eu_envio_o_número_do_telefone_cadastrado_no_sistema() throws Throwable {
			pages.consult_pages consult_pages = new consult_pages();
			consult_pages.eu_envio_o_número_do_telefone_cadastrado_no_sistema();
	}

	@Entao("^deve retornar erro quando buscar pessoa por telefone inexistente$")
		public void deve_retornar_erro_quando_buscar_pessoa_por_telefone_inexistente() throws Throwable {
			pages.consult_pages consult_pages = new consult_pages();
			consult_pages.deve_retornar_erro_quando_buscar_pessoa_por_telefone_inexistente();
	}

	@Entao("^deve retornar o código (\\d+)$")
		public void deve_retornar_o_código(int code) throws Throwable {
			pages.consult_pages consult_pages = new consult_pages();
			consult_pages.deve_retornar_o_código(code);
	}	
}
