package br.com.vollmedapi.dto.medico;

import br.com.vollmedapi.entities.MedicoEntity;
import br.com.vollmedapi.enumarations.EspecialidadeEnumaration;

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
