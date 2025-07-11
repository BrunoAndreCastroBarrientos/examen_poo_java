package com.ef.poo.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "entrevistas")
public class Entrevista {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "postulante_id", nullable = false)
  private Postulante postulante;

  @Column(name = "fecha_entrevista", nullable = false)
  private Date fechaEntrevista;

  @Column(name = "tipo_entrevista", nullable = false)
  private String tipoEntrevista;

  @Column(name = "comentarios")
  private String comentarios;

  @Column(name = "puntaje")
  private Integer puntaje;
}
