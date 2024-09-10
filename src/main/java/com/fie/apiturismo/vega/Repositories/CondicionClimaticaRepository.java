package com.fie.apiturismo.vega.Repositories;

import com.fie.apiturismo.vega.Entities.CondicionClimaticaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondicionClimaticaRepository extends JpaRepository<CondicionClimaticaEntity, Long> {
    // Si es necesario, puedes agregar métodos de consulta personalizados aquí
}
