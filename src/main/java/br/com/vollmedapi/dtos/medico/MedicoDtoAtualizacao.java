package br.com.vollmedapi.dtos.medico;

import br.com.vollmedapi.dtos.endereco.EnderecoDtoAtualizacao;
import jakarta.validation.Valid;

public record MedicoDtoAtualizacao(
		String nome,
		String telefone,
		@Valid
		EnderecoDtoAtualizacao endereco
) {

}
