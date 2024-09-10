package com.fie.apiturismo.vega.Repositories;

import com.fie.apiturismo.vega.Entities.WeatherDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataRepository extends JpaRepository<WeatherDataEntity, Long> {
}

