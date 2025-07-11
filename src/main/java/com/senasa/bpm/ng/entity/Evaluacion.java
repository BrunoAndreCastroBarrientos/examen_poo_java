package com.senasa.bpm.ng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "evaluaciones")
public class Evaluacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "postulante_id", nullable = false)
  private Postulante postulante;

  @Column(name = "tipo", nullable = false)
  private String tipo;

  @Column(name = "resultado", nullable = false)
  private String resultado;

  @Column(name = "fecha_evaluacion", nullable = false)
  private Date fechaEvaluacion;
}

