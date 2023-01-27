package br.com.vollmedapi.dtos.medico;

import br.com.vollmedapi.domains.entities.MedicoEntity;
import br.com.vollmedapi.domains.enumarations.EspecialidadeEnumaration;
import br.com.vollmedapi.dtos.endereco.EnderecoDtoDetalhamento;

public record MedicoDtoDetalhamento(
		
		Long id,
		String nome,
		String telefone,
		String crm,
		EspecialidadeEnumaration especialidade,
		EnderecoDtoDetalhamento endereco
		
) {
	
	public MedicoDtoDetalhamento(MedicoEntity medico) {
		this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), new EnderecoDtoDetalhamento(medico.getEndereco()));
	}

}
