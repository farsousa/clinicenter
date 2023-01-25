package br.com.vollmedapi.dto.medico;

import br.com.vollmedapi.dto.endereco.EnderecoDtoCadastro;
import br.com.vollmedapi.enumarations.EspecialidadeEnumaration;
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
		@Pattern(regexp = "\\d{4,6}")
		String crm,
		@NotNull(message = "Especialidade não pode estar em branco")
		EspecialidadeEnumaration especialidade,
		@NotNull(message = "Endereco deve ser informado!")
		@Valid
		EnderecoDtoCadastro endereco
		
) {

}
