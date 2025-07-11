package com.senasa.bpm.ng.repository;

import com.senasa.bpm.ng.entity.Entrevista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrevistaRepository extends JpaRepository<com.senasa.bpm.ng.entity.Entrevista, Long> {
}
