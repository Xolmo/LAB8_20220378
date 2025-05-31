package com.example.lab8_20220378.Entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Getter
@Setter
@Table(name = "planets")
public class Planets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre")
    @UniqueElements
    @NotBlank
    private String nombre;
    @Column(name = "tipo_planeta")
    @NotBlank
    private String tipoPlaneta;
    @Column(name = "habitable")
    @NotNull
    private boolean habitable;
    @NotNull
    @Column(name = "gravedad_relativa")
    private double gravedadRelativa;
    @Lob
    @Nullable
    private String descripcion;

}
