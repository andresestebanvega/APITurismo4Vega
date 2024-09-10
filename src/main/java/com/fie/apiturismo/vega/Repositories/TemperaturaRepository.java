package com.fie.apiturismo.vega.Repositories;

import com.fie.apiturismo.vega.Entities.TemperaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperaturaRepository extends JpaRepository<TemperaturaEntity, Long> {
    // Si es necesario, puedes agregar métodos de consulta personalizados aquí
}

