package br.com.vollmedapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.vollmedapi.dto.medico.MedicoDtoAtualizacao;
import br.com.vollmedapi.dto.medico.MedicoDtoCadastro;
import br.com.vollmedapi.dto.medico.MedicoDtoListagem;
import br.com.vollmedapi.dto.medico.MedicoDtoListagemIndividual;
import br.com.vollmedapi.entities.MedicoEntity;
import br.com.vollmedapi.services.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("medicos")
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<MedicoDtoListagemIndividual> cadastrar(
			@RequestBody 
			@Valid
			MedicoDtoCadastro medicoDtoCadastro
	) {
		MedicoEntity medico = new MedicoEntity(medicoDtoCadastro);
		
		System.out.println(medico.toString());
		medico = medicoService.cadastrar(medico);
		return ResponseEntity.created(null).body(new MedicoDtoListagemIndividual(medico));
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> excluir(
			@PathVariable
			Long id
	) {
		medicoService.excluir(id);
		return ResponseEntity.ok().body(null);
	}
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<MedicoDtoListagemIndividual> atualizar(
			@RequestBody 
			@Valid
			MedicoDtoAtualizacao medicoDtoAtualizacao,
			@PathVariable 
			Long id
	) {
		MedicoEntity medico = medicoService.atualizar(id, medicoDtoAtualizacao);
		return ResponseEntity.ok().body(new MedicoDtoListagemIndividual(medico));
	}
	
	@GetMapping
	public ResponseEntity<Page<MedicoDtoListagem>> listar(
			@PageableDefault(size = 10, sort = {"nome"})
			Pageable paginacao
	) {
		Page<MedicoEntity> medicos = medicoService.listar(paginacao);
		return ResponseEntity.ok(medicos.map(MedicoDtoListagem::new));		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<MedicoDtoListagemIndividual> listarPorId(
			@PathVariable
			Long id
	) {
		MedicoEntity medico = medicoService.listarPorId(id);
		return ResponseEntity.ok(new MedicoDtoListagemIndividual(medico));
	}

}
