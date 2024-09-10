package com.fie.apiturismo.vega.Entities.CondicionClimatica;

import com.fie.apiturismo.vega.Entities.CondicionClimaticaEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Nieve")
public class Nieve extends CondicionClimaticaEntity {
    @Override
    public String obtenerTipo() {
        return "Nieve";
    }
}