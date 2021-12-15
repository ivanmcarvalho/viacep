# Viacep API

> Para projetos java SE-11 + Spring Boot 2.6.1 

### Status do Projeto

O projeto está processando apenas requisições JSON, continua em desenvolvimento para outros tipos.

## Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

* Java SE-11
* Spring Boot Spring Boot 2.6.1

## Exemplo de busca pelo CEP 
#### O método já executa a tarefa de limpar o CEP  e/ou verifiar se o formato é válido   

Para buscar um endereço pelo CEP:

```javaposition-relativeoverflow-auto
public static void main(String[] args){
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
```

## Exemplo de busca pelo Endereço    

Para buscar um CEP pelo endereço:

```javaposition-relativeoverflow-auto
public static void main(String[] args){
	String uf = "SP";
	String cidade = "São Paulo";
	String logradouro = "Berrini";
	
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
```


 