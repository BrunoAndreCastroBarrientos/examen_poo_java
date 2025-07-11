package com.ef.poo.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "postulantes")
public class Postulante {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre", nullable = false)
  private String nombre;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "telefono")
  private String telefono;

  @Lob
  @Column(name = "cv")
  private byte[] cv;

  @Enumerated(EnumType.STRING)
  @Column(name = "estado", nullable = false)
  private EstadoPostulante estado;

  public enum EstadoPostulante {
    POSTULADO, EN_EVALUACION, PRESELECCIONADO, CONTRATADO, RECHAZADO
  }
}
