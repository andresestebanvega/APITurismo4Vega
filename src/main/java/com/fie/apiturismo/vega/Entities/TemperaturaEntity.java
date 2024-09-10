package com.fie.apiturismo.vega.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_temperatura")
@Data
public abstract class TemperaturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public abstract String obtenerTipo(); // Método abstracto que las subclases implementarán
}
