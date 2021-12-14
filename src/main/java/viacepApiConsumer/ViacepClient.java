package viacepApiConsumer;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;

public class ViacepClient {
	
	private static final String HTTP = "https";
	private static final String HOST = "viacep.com.br";
    private static final Gson GSON = new Gson();
    
    public static Cep buscaEndereco(String cep) {
    	
    	HttpHeaders authHeaders = new HttpHeaders();
		authHeaders.setContentType(MediaType.APPLICATION_JSON);
		authHeaders.set("Accept", "application/json");
		
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

}
