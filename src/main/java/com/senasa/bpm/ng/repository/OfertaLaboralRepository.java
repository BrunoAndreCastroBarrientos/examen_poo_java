package com.senasa.bpm.ng.repository;

import com.senasa.bpm.ng.entity.OfertaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfertaLaboralRepository extends JpaRepository<com.senasa.bpm.ng.entity.OfertaLaboral, Long> {
}

