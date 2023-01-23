package br.com.vollmedapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vollmedapi.entities.MedicoEntity;
import br.com.vollmedapi.repositories.MedicoRepository;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	public MedicoEntity cadastrar(MedicoEntity medico) {
		return medicoRepository.save(medico);
	}
	
	public void excluir() {
		
	}
	
	public void atualizar() {
		
	}
	
	public void listar() {
		
	}
	
	public void listarPorId() {
		
	}

}
