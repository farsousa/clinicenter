package br.com.vollmedapi.dtos.endereco;

import br.com.vollmedapi.domains.models.Endereco;

public record EnderecoDtoDetalhamento(
		
		String logradouro,
		String numero,
		String bairro,
		String cidade,
		String uf,
		String complemento

) {
	
	public EnderecoDtoDetalhamento(Endereco endereco) {
		this(endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getUf(), endereco.getComplemento());
	}

}
