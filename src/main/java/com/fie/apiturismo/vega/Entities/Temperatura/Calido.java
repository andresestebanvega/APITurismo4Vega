package com.fie.apiturismo.vega.Entities.Temperatura;

import com.fie.apiturismo.vega.Entities.TemperaturaEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// Subclase para "Calido"
@Entity
@DiscriminatorValue("Calido")
public class Calido extends TemperaturaEntity {
    @Override
    public String obtenerTipo() {
        return "Calido";
    }
}