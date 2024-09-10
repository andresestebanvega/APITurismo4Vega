package com.fie.apiturismo.vega.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "weather_data")
@Data
public class WeatherDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "condicion_climatica_id")
    private CondicionClimaticaEntity condicionClimatica;

    @ManyToOne
    @JoinColumn(name = "temperatura_id")
    private TemperaturaEntity temperatura;

    private double sensacionTermica;
    private int humedad;
    private double velocidadViento;
    private int nubosidad;
}

