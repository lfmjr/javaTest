package pages;

import org.junit.Assert;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class consult_pages {
	
	 private static final String BASE_URL = "http://localhost:8080/pessoas/";
	 private static Response response;


	public void o_endereço_da_APi_de_consulta() throws Throwable {
		 RestAssured.baseURI = BASE_URL;
		 RequestSpecification request = RestAssured.given();
	}
	
	public void eu_envio_o_número_do_telefone_inexistente() throws Throwable {
		RequestSpecification request = RestAssured.given(); 
		request.header("Content-Type", "application/json");
		response = request.get("http://localhost:8080/pessoas/11/111111111");
	}
	
	public void eu_envio_o_número_do_telefone_cadastrado_no_sistema() throws Throwable {
		RequestSpecification request = RestAssured.given(); 
		request.header("Content-Type", "application/json");
		response = request.get("http://localhost:8080/pessoas/21/981364693");
	}
	
	public void deve_retornar_erro_quando_buscar_pessoa_por_telefone_inexistente() throws Throwable {
		String body = response.asString();
		int jsonString = response.getStatusCode();
	    Assert.assertEquals(404, jsonString);
	    Assert.assertEquals("{\"erro\":\"Não existe pessoa com o telefone (11)111111111\"}", body);
	}

	public static void deve_retornar_o_código(int code) throws Throwable {
		int jsonString = response.getStatusCode();
	    Assert.assertEquals(code, jsonString);
	}

}
