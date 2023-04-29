package com.coppel.back.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cuerpo", nullable = false)
    private String cuerpo;
    @JoinColumn(name = "denuncia_id", nullable = false) @ManyToOne(fetch = FetchType.LAZY)
    private Denuncia denuncia;
}
