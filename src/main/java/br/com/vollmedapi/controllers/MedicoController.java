package br.com.vollmedapi.controllers;

import java.net.URI;

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
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vollmedapi.domains.entities.MedicoEntity;
import br.com.vollmedapi.dtos.medico.MedicoDtoAtualizacao;
import br.com.vollmedapi.dtos.medico.MedicoDtoCadastro;
import br.com.vollmedapi.dtos.medico.MedicoDtoListagem;
import br.com.vollmedapi.dtos.medico.MedicoDtoDetalhamento;
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
	public ResponseEntity<MedicoDtoDetalhamento> cadastrar(
			@RequestBody 
			@Valid
			MedicoDtoCadastro medicoDtoCadastro,
			UriComponentsBuilder uriBuilder
	) {
		MedicoEntity medico = new MedicoEntity(medicoDtoCadastro);
		medico = medicoService.cadastrar(medico);
		URI uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
		return ResponseEntity.created(uri).body(new MedicoDtoDetalhamento(medico));
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> excluirPorId(
			@PathVariable
			Long id
	) {
		medicoService.excluirPorId(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<MedicoDtoDetalhamento> atualizarPorId(
			@RequestBody 
			@Valid
			MedicoDtoAtualizacao medicoDtoAtualizacao,
			@PathVariable 
			Long id
	) {
		MedicoEntity medico = medicoService.atualizarPorId(id, medicoDtoAtualizacao);
		return ResponseEntity.ok().body(new MedicoDtoDetalhamento(medico));
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
	public ResponseEntity<MedicoDtoDetalhamento> detalharPorId(
			@PathVariable
			Long id
	) {
		MedicoEntity medico = medicoService.detalharPorId(id);
		return ResponseEntity.ok(new MedicoDtoDetalhamento(medico));
	}

}
