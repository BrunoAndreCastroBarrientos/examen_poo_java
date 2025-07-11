package com.senasa.bpm.ng.controller;

import com.senasa.bpm.ng.entity.Entrevista;
import com.senasa.bpm.ng.repository.EntrevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrevistas")
public class EntrevistaController {

  @Autowired
  private EntrevistaRepository entrevistaRepository;

  // Registrar una nueva entrevista
  @PostMapping("/")
  public Entrevista registrarEntrevista(@RequestBody Entrevista entrevista) {
    return entrevistaRepository.save(entrevista);
  }

  // Obtener todas las entrevistas
  @GetMapping("/")
  public List<Entrevista> obtenerEntrevistas() {
    return entrevistaRepository.findAll();
  }

  // Obtener una entrevista por su ID
  @GetMapping("/{id}")
  public Entrevista obtenerEntrevista(@PathVariable Long id) {
    return entrevistaRepository.findById(id).orElse(null);
  }
}
