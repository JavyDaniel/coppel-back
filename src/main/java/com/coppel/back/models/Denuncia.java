package com.coppel.back.models;

import com.coppel.back.enums.Estatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "denuncias")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "empresa_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresa empresa;
    @JoinColumn(name = "estado_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Estado estado;
    @Column(name = "centro", nullable = false)
    private Integer centro;
    @Column(name = "detalle", nullable = false)
    private String detalle;
    @Column(name = "fecha", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Enumerated(EnumType.STRING)
    @Column(name = "estatus", nullable = false)
    private Estatus estatus;

}
