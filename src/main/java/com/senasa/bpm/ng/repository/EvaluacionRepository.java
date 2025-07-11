package com.senasa.bpm.ng.repository;

import com.senasa.bpm.ng.entity.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionRepository extends JpaRepository<com.senasa.bpm.ng.entity.Evaluacion, Long> {
}
