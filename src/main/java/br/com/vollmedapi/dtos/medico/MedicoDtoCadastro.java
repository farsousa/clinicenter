package br.com.vollmedapi.dtos.medico;

import br.com.vollmedapi.domains.enumarations.EspecialidadeEnumaration;
import br.com.vollmedapi.dtos.endereco.EnderecoDtoCadastro;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDtoCadastro(
		
		@NotBlank(message = "Nome deve ser informado!")
		String nome,
		@NotBlank(message = "Telefone deve ser informado!")
		String telefone,
		@Email(message = "Email inválido!")
		@NotBlank(message = "Email deve ser informado!")
		String email,
		@NotBlank(message = "CRM deve ser informado!")
		@Pattern(regexp = "\\d{4,6}", message = "CRM deve ser apenas números e ter no mínimo 4 e no máximo 6 dígitos!")
		String crm,
		@NotNull(message = "Especialidade não pode estar em branco")
		EspecialidadeEnumaration especialidade,
		@NotNull(message = "Endereco deve ser informado!")
		@Valid
		EnderecoDtoCadastro endereco
		
) {

}
