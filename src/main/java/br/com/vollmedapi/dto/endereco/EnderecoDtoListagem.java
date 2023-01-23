package br.com.vollmedapi.dto.endereco;

import br.com.vollmedapi.models.Endereco;

public record EnderecoDtoListagem(
		
		String logradouro,
		String numero,
		String bairro,
		String cidade,
		String uf,
		String complemento

) {
	
	public EnderecoDtoListagem(Endereco endereco) {
		this(endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getUf(), endereco.getComplemento());
	}

}
