package br.com.vollmedapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vollmedapi.dto.medico.MedicoDtoCadastro;
import br.com.vollmedapi.dto.medico.MedicoDtoListagemIndividual;
import br.com.vollmedapi.entities.MedicoEntity;
import br.com.vollmedapi.services.MedicoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("medicos")
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;
	
	@PostMapping
	public ResponseEntity<MedicoDtoListagemIndividual> cadastrar(
			@RequestBody 
			@Valid
			MedicoDtoCadastro medicoDtoCadastro
	) {
		MedicoEntity medico = medicoService.cadastrar(new MedicoEntity(medicoDtoCadastro));
		return ResponseEntity.created(null).body(new MedicoDtoListagemIndividual(medico));
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
