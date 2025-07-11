package com.senasa.bpm.ng.controller;



import com.senasa.bpm.ng.entity.OfertaLaboral;
import com.senasa.bpm.ng.repository.OfertaLaboralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ofertas")
public class OfertaLaboralController {

  @Autowired
  private OfertaLaboralRepository ofertaLaboralRepository;

  // Crear una nueva oferta laboral
  @PostMapping("/")
  public OfertaLaboral crearOferta(@RequestBody OfertaLaboral ofertaLaboral) {
    return ofertaLaboralRepository.save(ofertaLaboral);
  }

  // Obtener todas las ofertas laborales
  @GetMapping("/")
  public List<OfertaLaboral> obtenerTodasOfertas() {
    return ofertaLaboralRepository.findAll();
  }

  // Obtener una oferta laboral por su ID
  @GetMapping("/{id}")
  public OfertaLaboral obtenerOferta(@PathVariable Long id) {
    return ofertaLaboralRepository.findById(id).orElse(null);
  }

  // Eliminar una oferta laboral por su ID
  @DeleteMapping("/{id}")
  public void eliminarOferta(@PathVariable Long id) {
    ofertaLaboralRepository.deleteById(id);
  }
}

