package com.senasa.bpm.ng.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
