package viacepApiConsumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import viacepApiConsumer.Cep;
import viacepApiConsumer.ViacepClient;

@SpringBootTest
class AppViacepTests {

	@Test
	void contextLoads() {
		
		Cep dadosEndereco = ViacepClient.buscaEndereco("03614010");
		if(dadosEndereco.getErro() == null) {
			
			System.out.println("Logradouro.: " + dadosEndereco.getLogradouro());
			System.out.println("Complemento: " + dadosEndereco.getComplemento());
			System.out.println("Bairro.....: " + dadosEndereco.getBairro());
			System.out.println("CEP........: " + dadosEndereco.getCep());
			System.out.println("Localidade.: " + dadosEndereco.getLocalidade() + "/" +
												dadosEndereco.getUf()
			                  );
			System.out.println("DDD........: " + dadosEndereco.getDdd());
			System.out.println("GIA........: " + dadosEndereco.getGia());
			System.out.println("SIAFI......: " + dadosEndereco.getSiafi());
			
		} else {
			
			System.out.println("Erro: " + dadosEndereco.getErro());		
		
		}
		
	}
	
}
