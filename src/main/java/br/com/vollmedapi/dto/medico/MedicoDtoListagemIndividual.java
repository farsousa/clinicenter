package br.com.vollmedapi.dto.medico;

import br.com.vollmedapi.dto.endereco.EnderecoDtoListagem;
import br.com.vollmedapi.entities.MedicoEntity;
import br.com.vollmedapi.enumarations.EspecialidadeEnumaration;

public record MedicoDtoListagemIndividual(
		
		Long id,
		String nome,
		String telefone,
		String crm,
		EspecialidadeEnumaration especialidade,
		EnderecoDtoListagem endereco
		
) {
	
	public MedicoDtoListagemIndividual(MedicoEntity medico) {
		this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), new EnderecoDtoListagem(medico.getEndereco()));
	}

}
