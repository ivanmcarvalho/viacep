package viacepApiConsumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppEnderecoTests {

	@Test
	void contextLoads() {
		
		Cep dadosEndereco = ViacepClient.buscaEndereco("05508010");
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
