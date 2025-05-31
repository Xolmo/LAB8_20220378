package com.example.lab8_20220378.Entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "expeditions")
public class Expeditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;
    @NotBlank
    @Column(name = "nombre_mision")
    private String nombreMision;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "planeta_destino_id")
    private Planets planetaDestino;
    @NotBlank
    private String estado;
    @Lob
    @Nullable
    private String objetivos;
    @Lob
    @Nullable
    private String resultados;




}
