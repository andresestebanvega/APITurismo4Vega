package com.fie.apiturismo.vega.Controllers;

import com.fie.apiturismo.vega.Entities.WeatherDataEntity;
import com.fie.apiturismo.vega.Services.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherDataController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/ciudad")
    public ResponseEntity<WeatherDataEntity> obtenerDatosPorCiudad(@RequestParam String ciudad) {
        // Llamamos al servicio para obtener los datos del clima basados en la ciudad
        WeatherDataEntity weatherData = weatherDataService.obtenerPronostico(ciudad);

        // Devolvemos la entidad WeatherDataEntity envuelta en un ResponseEntity
        return ResponseEntity.ok(weatherData);
    }
}


