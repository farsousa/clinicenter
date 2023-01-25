package br.com.vollmedapi.dto.endereco;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Pattern;

public record EnderecoDtoAtualizacao(
		String logradouro,
		@Length(min = 1, max = 20)
		String numero,
		String bairro,
		String cidade,
		@Pattern(regexp = "^(?i)(\\s*(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)?)$", message = "UF inválido")
		String uf,
		String complemento
) {

}
