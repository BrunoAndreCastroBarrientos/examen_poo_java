package com.ef.poo.demo.controller;

import com.ef.poo.demo.entity.Postulante;
import com.ef.poo.demo.repository.PostulanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postulantes")
public class PostulanteController {

  @Autowired
  private PostulanteRepository postulanteRepository;

  // Registrar un nuevo postulante
  @PostMapping("/")
  public Postulante registrarPostulante(@RequestBody Postulante postulante) {
    return postulanteRepository.save(postulante);
  }

  // Obtener todos los postulantes
  @GetMapping("/")
  public List<Postulante> obtenerPostulantes() {
    return postulanteRepository.findAll();
  }

  // Obtener un postulante por su ID
  @GetMapping("/{id}")
  public Postulante obtenerPostulante(@PathVariable Long id) {
    return postulanteRepository.findById(id).orElse(null);
  }

  // Eliminar un postulante por su ID
  @DeleteMapping("/{id}")
  public void eliminarPostulante(@PathVariable Long id) {
    postulanteRepository.deleteById(id);
  }
}
