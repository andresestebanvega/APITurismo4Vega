package com.fie.apiturismo.vega.Entities.Temperatura;

import com.fie.apiturismo.vega.Entities.TemperaturaEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

// Subclase para "Templado"
@Entity
@DiscriminatorValue("Templado")
public class Templado extends TemperaturaEntity {
    @Override
    public String obtenerTipo() {
        return "Templado";
    }
}
