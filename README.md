# Viacep API

> Para projetos java SE-11 + Spring Boot 2.6.1 

### Status do Projeto

O projeto está processando apenas requisições JSON, continua em desenvolvimento para outros tipos.

## :tw-1f50c: Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

* Java SE-11
* Spring Boot Spring Boot 2.6.1

## :tw-1f3c1: Exemplo de busca pelo CEP 
#### O método já executa a tarefa de limpar o CEP  e/ou verifiar se o formato é válido   

Para buscar um cep:

```javaposition-relativeoverflow-auto
public static void main(String[] args){
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
```


 