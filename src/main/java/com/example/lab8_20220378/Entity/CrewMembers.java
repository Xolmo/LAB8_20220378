package com.example.lab8_20220378.Entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "crew_members")
public class CrewMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @NotNull
    @Column(name = "especialidad")
    private String especialidad;
    @Nullable
    private String rango;
    @Column(name = "fecha_contratacion")
    private LocalDate fechaContratacion;
}
