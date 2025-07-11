package com.senasa.bpm.ng.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ofertas_laborales")
public class OfertaLaboral {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "titulo", nullable = false)
  private String titulo;

  @Column(name = "descripcion", nullable = false)
  private String descripcion;

  @Column(name = "area", nullable = false)
  private String area;

  @Column(name = "fecha_publicacion", nullable = false)
  private Date fechaPublicacion;

  @Column(name = "fecha_cierre")
  private Date fechaCierre;

  @Enumerated(EnumType.STRING)
  @Column(name = "estado", nullable = false)
  private EstadoOfertaLaboral estado;

  public enum EstadoOfertaLaboral {
    ABIERTO, CERRADO, COMPLETO
  }
}
