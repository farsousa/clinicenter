package br.com.vollmedapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.vollmedapi.dto.medico.MedicoDtoAtualizacao;
import br.com.vollmedapi.entities.MedicoEntity;
import br.com.vollmedapi.repositories.MedicoRepository;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	public MedicoEntity cadastrar(MedicoEntity medico) {
		return medicoRepository.save(medico);
	}
	
	public MedicoEntity excluir(Long id) {
		MedicoEntity medico = medicoRepository.getReferenceById(id);
		medicoRepository.delete(medico);
		return null;
	}
	
	public MedicoEntity atualizar(Long id, MedicoDtoAtualizacao medicoDtoAtualizacao) {
		MedicoEntity medico = medicoRepository.getReferenceById(id);
		medico.atualizar(medicoDtoAtualizacao);
		return medico;
	}
	
	public Page<MedicoEntity> listar(Pageable paginacao) {
		return medicoRepository.findAll(paginacao);
	}
	
	public MedicoEntity listarPorId(Long id) {
		return medicoRepository.getReferenceById(id);
	}

}
