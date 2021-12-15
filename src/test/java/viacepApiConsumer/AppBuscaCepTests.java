package viacepApiConsumer;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppBuscaCepTests {

	@Test
	void contextLoads() {		

		String uf = "SP";
		String cidade = "São Paulo";
		String logradouro = "Paulista";
		
		Endereco[] dadosCep = ViacepClient.buscaCep(uf, cidade, logradouro);
		
		if(dadosCep[0].getErro() == null) {			
		
			Arrays
			.stream(dadosCep)
			.forEach(e -> {
				System.out.println("---------------------------------------");
				System.out.println("Logradouro.: " + e.getLogradouro());
				System.out.println("Complemento: " + e.getComplemento());
				System.out.println("Bairro.....: " + e.getBairro());
				System.out.println("CEP........: " + e.getCep());
				System.out.println("Localidade.: " + e.getLocalidade() + "/" +
				   								     e.getUf()
				                  );
				System.out.println("DDD........: " + e.getDdd());
				System.out.println("GIA........: " + e.getGia());
				System.out.println("SIAFI......: " + e.getSiafi());
			});		
		
		} else {
			
			System.out.println("Erro: " + dadosCep[0].getErro());		
		
		}
		
	}
	
}
