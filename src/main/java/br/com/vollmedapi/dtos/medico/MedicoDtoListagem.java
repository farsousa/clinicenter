package br.com.vollmedapi.dtos.medico;

import br.com.vollmedapi.domains.entities.MedicoEntity;
import br.com.vollmedapi.domains.enumarations.EspecialidadeEnumaration;

public record MedicoDtoListagem(
		Long id,
		String nome,
		String email,
		String crm,
		EspecialidadeEnumaration especialidade
) {
	public MedicoDtoListagem(MedicoEntity medico) {
		this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
	}
}
