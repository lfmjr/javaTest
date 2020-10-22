package pages;

import static com.jayway.restassured.RestAssured.given;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class cad_pages {
	
	private static String path;
	private static Response response;
	
	private String formulario = "{\r\n" + 
			"\"codigo\": 0,\r\n" + 
			"\"nome\": \"Client 1\",\r\n" + 
			"\"cpf\": \"43466711010\",\r\n" + 
			"\"enderecos\": [\r\n" + 
			"{\r\n" + 
			"\"logradouro\": \"Rua Alexandre Dumas\",\r\n" + 
			"\"numero\": 123,\r\n" + 
			"\"complemento\": \"Empresa\",\r\n" + 
			"\"bairro\": \"Chacara Santo Antonio\",\r\n" + 
			"\"cidade\": \"São Paulo\",\r\n" + 
			"\"estado\": \"SP\"\r\n" + 
			"}\r\n" + 
			"],\r\n" + 
			"\"telefones\": [\r\n" + 
			"{\r\n" + 
			"\"ddd\": \"21\",\r\n" + 
			"\"numero\": \"981364693\"\r\n" + 
			"}]\r\n" + 
			"}";
	
	private String formularioB = "{\r\n" + 
			"\"codigo\": 0,\r\n" + 
			"\"nome\": \"Client 2\",\r\n" + 
			"\"cpf\": \"17846025074\",\r\n" + 
			"\"enderecos\": [\r\n" + 
			"{\r\n" + 
			"\"logradouro\": \"Rua Alexandre Dumas\",\r\n" + 
			"\"numero\": 123,\r\n" + 
			"\"complemento\": \"Empresa\",\r\n" + 
			"\"bairro\": \"Chacara Santo Antonio\",\r\n" + 
			"\"cidade\": \"São Paulo\",\r\n" + 
			"\"estado\": \"SP\"\r\n" + 
			"}\r\n" + 
			"],\r\n" + 
			"\"telefones\": [\r\n" + 
			"{\r\n" + 
			"\"ddd\": \"21\",\r\n" + 
			"\"numero\": \"981364693\"\r\n" + 
			"}]\r\n" + 
			"}";
	
	public void o_endereço_da_APi_para_cadastro() throws Throwable {
		 RestAssured.baseURI = "http://localhost:8080";
	        path = "/pessoas";  	   
	}	

	public void realizar_uma_requisição_para_cadastrar_uma_pessoa_e_seus_dados() throws Throwable {
		response = given()
				   .header("Accept", ContentType.JSON.getAcceptHeader())
				   .contentType("application/json;charset=UTF-8")
				   .body(formulario)
				   .post(path)
	            .then().extract().response();
	}
	
	public void realizo_o_cadastro_com_um_CPF_já_cadastrado() throws Throwable {
		response = given()
				   .header("Accept", ContentType.JSON.getAcceptHeader())
				   .contentType("application/json;charset=UTF-8")
				   .body(formulario)
				   .post(path)
	               .then().extract().response();
	}
	
	public void realizo_o_cadastro_com_um_telefone_já_cadastrado() throws Throwable {
		response = given()
				   .header("Accept", ContentType.JSON.getAcceptHeader())
				   .contentType("application/json;charset=UTF-8")
				   .body(formularioB)
				   .post(path)
	               .then().extract().response();
	}
	
	public static void o_código_de_status_da_resposta_deve_ser(int code) throws Throwable {			
		Assertions.assertEquals(code, response.getStatusCode());				
	}       
	
	public static void a_APi_não_deve_permitir_cadastrar_duas_pessoas_com_o_mesmo_CPF() throws Throwable {
		String body = response.asString();
		Assert.assertEquals("{\"erro\":\"Já existe pessoa cadastrada com o CPF 43466711010\"}", body);
	    
	}

	public static void a_APi_não_deve_permitir_duas_pessoas_com_o_mesmo_telefone() throws Throwable {
		String body = response.asString();
		Assert.assertEquals("{\"erro\":\"Já existe pessoa cadastrada com o Telefone (13)981364693\"}", body);    
	}
}
