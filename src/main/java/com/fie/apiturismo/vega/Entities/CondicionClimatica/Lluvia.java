package com.fie.apiturismo.vega.Entities.CondicionClimatica;

import com.fie.apiturismo.vega.Entities.CondicionClimaticaEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// Subclase para "Lluvia"
@Entity
@DiscriminatorValue("Lluvia")
public class Lluvia extends CondicionClimaticaEntity {
    @Override
    public String obtenerTipo() {
        return "Lluvia";
    }
}