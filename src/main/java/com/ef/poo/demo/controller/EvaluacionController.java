package com.ef.poo.demo.controller;
import com.ef.poo.demo.entity.Evaluacion;
import com.ef.poo.demo.repository.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {

  @Autowired
  private EvaluacionRepository evaluacionRepository;

  // Registrar una nueva evaluación
  @PostMapping("/")
  public Evaluacion registrarEvaluacion(@RequestBody Evaluacion evaluacion) {
    return evaluacionRepository.save(evaluacion);
  }

  // Obtener todas las evaluaciones
  @GetMapping("/")
  public List<Evaluacion> obtenerEvaluaciones() {
    return evaluacionRepository.findAll();
  }

  // Obtener una evaluación por su ID
  @GetMapping("/{id}")
  public Evaluacion obtenerEvaluacion(@PathVariable Long id) {
    return evaluacionRepository.findById(id).orElse(null);
  }
}

