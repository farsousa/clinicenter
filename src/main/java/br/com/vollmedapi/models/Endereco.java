package br.com.vollmedapi.models;

import br.com.vollmedapi.dto.endereco.EnderecoDtoCadastro;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Endereco {
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	
	public Endereco(EnderecoDtoCadastro enderecoDtoCadastro) {
		this.logradouro = enderecoDtoCadastro.logradouro();
		this.numero = enderecoDtoCadastro.numero();
		this.complemento = enderecoDtoCadastro.complemento();
		this.bairro = enderecoDtoCadastro.bairro();
		this.cidade = enderecoDtoCadastro.cidade();
		this.uf = enderecoDtoCadastro.uf();
	}

}
