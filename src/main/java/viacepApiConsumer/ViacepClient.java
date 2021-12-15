package viacepApiConsumer;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;

public class ViacepClient {
	
	private static final String HTTP = "https";
	private static final String HOST = "viacep.com.br";
    private static final Gson GSON   = new Gson();
    public static String tipoRetorno = "json";    
    
	public static Cep buscaEndereco(String cep) {
    	
    	HttpHeaders authHeaders = Headers.makeHeader(tipoRetorno);
		
		UriComponentsBuilder apiUriBuilder = UriComponentsBuilder.newInstance()
				.scheme(HTTP)
				.host(HOST)
				.path("/ws/" + Cep.limpaCep(cep) + "/json");		
				//apiUriBuilder.queryParam("grantType", "client_credentials");
				URI pullsUri = apiUriBuilder.build().encode().toUri();


		RestTemplate rest = new RestTemplate();
		String restBody = ""; 
		HttpEntity<String> authEntity = new HttpEntity<String>(restBody, authHeaders);
		
		try {
	
			ResponseEntity<String> entity = rest.exchange(pullsUri, HttpMethod.GET, authEntity, String.class);
	        String jsonInString = entity.getBody();
	        Cep dados = GSON.fromJson(jsonInString, Cep.class);
	        
	        if(dados.getErro() != null) {
	        	dados.setErro("Cep Inválido");
	        }
	        
	        return dados;
			
			
		} catch (RestClientException e) {	
			
			String jsonInString = "{\"erro\": \"O Formato do CEP está inválido!\"}";
	        return GSON.fromJson(jsonInString, Cep.class);
			
		}
    	
    }
    public static Endereco[] buscaCep(String uf, String cidade, String logradouro) {
    	
    	HttpHeaders authHeaders = Headers.makeHeader(tipoRetorno);
		// https://viacep.com.br/ws/SP/S%C3%A3o%20Paulo/Rua%20Verena/json/
		UriComponentsBuilder apiUriBuilder = UriComponentsBuilder.newInstance()
				.scheme(HTTP)
				.host(HOST)
				.path("/ws/" + uf + "/" + cidade + "/" + logradouro + "/json");		
				//apiUriBuilder.queryParam("grantType", "client_credentials");
				URI pullsUri = apiUriBuilder.build().encode().toUri();


		RestTemplate rest = new RestTemplate();
		String restBody = ""; 
		HttpEntity<String> authEntity = new HttpEntity<String>(restBody, authHeaders);
		
		try {
	
			ResponseEntity<String> entity = rest.exchange(pullsUri, HttpMethod.GET, authEntity, String.class);
	        String jsonInString = entity.getBody();
	        //Endereco dados = GSON.fromJson(jsonInString, Endereco.class);

	          
	        
	        Endereco[] dados = GSON.fromJson(jsonInString, Endereco[].class);

	        if(dados[0].getCep() == null) {
	        	dados[0].setErro("Os dados informados são inválidos");
	        }
	        
	        return dados;
			
			
		} catch (RestClientException e) {	
			
			String jsonInString = "[{\"erro\": \"O Formato dos Dados estão incorretos!\"}]";
			Endereco[] dados = GSON.fromJson(jsonInString, Endereco[].class);
			return dados;
			
		}
    	
    }
    
    public static String getTipoRetorno() {
		return tipoRetorno;
	}
	public static void setTipoRetorno(String tipoRetorno) {
		ViacepClient.tipoRetorno = tipoRetorno;
	}

}
