package viacepApiConsumer;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class Headers {	
	
	public static HttpHeaders makeHeader(String tipo) {
		HttpHeaders authHeaders = new HttpHeaders();
		authHeaders.setContentType(MediaType.APPLICATION_JSON);
		authHeaders.set("Accept", "application/" + tipo);
		return authHeaders;
		
	}
	
}
