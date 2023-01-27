package br.com.vollmedapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vollmedapi.domains.entities.MedicoEntity;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {

}
