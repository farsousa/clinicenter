package br.com.vollmedapi.entities;

import br.com.vollmedapi.dto.medico.MedicoDtoCadastro;
import br.com.vollmedapi.enumarations.EspecialidadeEnumaration;
import br.com.vollmedapi.models.Endereco;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Medicos")
@Table(name = "tab_medico")
public class MedicoEntity {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String crm;
	@Enumerated(EnumType.STRING)
	private EspecialidadeEnumaration especialidade;
	@Embedded
	private Endereco endereco;
	
	
	public MedicoEntity(MedicoDtoCadastro medicoDtoCadastro) {
		this.nome = medicoDtoCadastro.nome();
		this.email = medicoDtoCadastro.email();
		this.telefone = medicoDtoCadastro.telefone();
		this.crm = medicoDtoCadastro.crm();
		this.especialidade = medicoDtoCadastro.especialidade();
		this.endereco = new Endereco(medicoDtoCadastro.endereco());
	}
	
}
