package br.com.vollmedapi.dto.endereco;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDtoCadastro(
		
		@NotBlank(message = "Logradouro deve ser informado!")
		String logradouro,
		@NotBlank(message = "Numero deve ser informado!")
		@Length(min = 1, max = 20)
		String numero,
		String complemento,
		@NotBlank(message = "Bairro deve ser informado!")
		String bairro,
		@NotBlank(message = "Cidade deve ser informado!")
		String cidade,
		@NotBlank(message = "UF deve ser informado!")
		@Pattern(regexp = "^(?i)(\\s*(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)?)$")
		String uf
		
) {
	
}
