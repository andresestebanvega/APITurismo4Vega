package com.fie.apiturismo.vega.Entities.Temperatura;

import com.fie.apiturismo.vega.Entities.TemperaturaEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Frio")
public class Frio extends TemperaturaEntity {
    @Override
    public String obtenerTipo() {
        return "Frio";
    }
}
