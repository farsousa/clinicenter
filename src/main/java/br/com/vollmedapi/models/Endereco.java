package br.com.vollmedapi.models;

import br.com.vollmedapi.dto.endereco.EnderecoDtoAtualizacao;
import br.com.vollmedapi.dto.endereco.EnderecoDtoCadastro;
import br.com.vollmedapi.entities.MedicoEntity;
import br.com.vollmedapi.enumarations.EspecialidadeEnumaration;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
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
	
	public void atualizar(EnderecoDtoAtualizacao enderecoDtoAtualizacao) {
		if(enderecoDtoAtualizacao.logradouro() != null) {
			this.logradouro = enderecoDtoAtualizacao.logradouro();
		}
		if(enderecoDtoAtualizacao.numero() != null) {
			this.numero = enderecoDtoAtualizacao.numero();
		}
		if(enderecoDtoAtualizacao.cidade() != null) {
			this.cidade = enderecoDtoAtualizacao.cidade();
		}
		if(enderecoDtoAtualizacao.bairro() != null ) {
			this.bairro = enderecoDtoAtualizacao.bairro();
		}
		if(enderecoDtoAtualizacao.uf() != null) {
			this.uf = enderecoDtoAtualizacao.uf();
		}
		if(enderecoDtoAtualizacao.complemento() != null) {
			this.complemento = enderecoDtoAtualizacao.complemento();
		}
	}

}
