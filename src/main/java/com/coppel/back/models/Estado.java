package com.coppel.back.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estados", uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @JoinColumn(name = "pais_id") @ManyToOne(fetch = FetchType.LAZY)
    private Pais pais;
}
