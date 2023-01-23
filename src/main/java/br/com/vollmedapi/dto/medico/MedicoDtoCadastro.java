package br.com.vollmedapi.dto.medico;

import org.hibernate.validator.constraints.Length;

import br.com.vollmedapi.dto.endereco.EnderecoDtoCadastro;
import br.com.vollmedapi.enumarations.EspecialidadeEnumaration;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoDtoCadastro(
		
		@NotBlank(message = "Nome deve ser informado!")
		String nome,
		@NotBlank(message = "Telefone deve ser informado!")
		String telefone,
		@Email(message = "Email inválido!")
		@NotBlank(message = "Email deve ser informado!")
		String email,
		@NotBlank(message = "CRM deve ser informado!")
		@Length(min = 1, max = 6)
		String crm,
		@NotNull(message = "Especialidade não pode estar em branco")
		EspecialidadeEnumaration especialidade,
		@NotNull(message = "Endereco deve ser informado!")
		@Valid
		EnderecoDtoCadastro endereco
		
) {

}
