package com.fie.apiturismo.vega.Entities.CondicionClimatica;

import com.fie.apiturismo.vega.Entities.CondicionClimaticaEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// Subclase para "Nublado"
@Entity
@DiscriminatorValue("Nublado")
public class Nublado extends CondicionClimaticaEntity {
    @Override
    public String obtenerTipo() {
        return "Nublado";
    }
}
