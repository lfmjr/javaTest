package steps;


import org.junit.Test;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.cad_pages;




public class form_api_steps {
	
	 @Test
	 
	
	@Dado("^o endereço da APi para cadastro$")
	 	public void o_endereço_da_APi_para_cadastro() throws Throwable {
		 	cad_pages cad_pages = new cad_pages();
		 	cad_pages.o_endereço_da_APi_para_cadastro();  	   
	}

	@Quando("^realizar uma requisição para cadastrar uma pessoa e seus dados$")
		public void realizar_uma_requisição_para_cadastrar_uma_pessoa_e_seus_dados() throws Throwable {
			cad_pages cad_pages = new cad_pages();
			cad_pages.realizar_uma_requisição_para_cadastrar_uma_pessoa_e_seus_dados();
	}
	
	@Quando("^realizo o cadastro com um CPF já cadastrado$")
		public void realizo_o_cadastro_com_um_CPF_já_cadastrado() throws Throwable {
			cad_pages cad_pages = new cad_pages();
			cad_pages.realizo_o_cadastro_com_um_CPF_já_cadastrado();
	}
	
	@Quando("^realizo o cadastro com um telefone já cadastrado$")
		public void realizo_o_cadastro_com_um_telefone_já_cadastrado() throws Throwable {
			cad_pages cad_pages = new cad_pages();
			cad_pages.realizo_o_cadastro_com_um_telefone_já_cadastrado();
	}
		
	@Entao("^o código de status da resposta deve ser (\\d+)$")
		public void o_código_de_status_da_resposta_deve_ser(int code) throws Throwable {			
			pages.cad_pages.o_código_de_status_da_resposta_deve_ser(code);
	}       
	
	@Entao("^a APi não deve permitir cadastrar duas pessoas com o mesmo CPF$")
		public void a_APi_não_deve_permitir_cadastrar_duas_pessoas_com_o_mesmo_CPF() throws Throwable {
			pages.cad_pages.a_APi_não_deve_permitir_cadastrar_duas_pessoas_com_o_mesmo_CPF();
	}

	@Entao("^a APi não deve permitir duas pessoas com o mesmo telefone$")
		public void a_APi_não_deve_permitir_duas_pessoas_com_o_mesmo_telefone() throws Throwable {
			pages.cad_pages.a_APi_não_deve_permitir_duas_pessoas_com_o_mesmo_telefone();
	}
}
