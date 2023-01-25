package br.com.vollmedapi.dto.medico;

import br.com.vollmedapi.dto.endereco.EnderecoDtoAtualizacao;
import jakarta.validation.Valid;

public record MedicoDtoAtualizacao(
		String nome,
		String telefone,
		@Valid
		EnderecoDtoAtualizacao endereco
) {

}
