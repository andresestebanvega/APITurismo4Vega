package com.fie.apiturismo.vega.Controllers;

import com.fie.apiturismo.vega.Entities.WeatherDataEntity;
import com.fie.apiturismo.vega.Services.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class WeatherDataController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/ciudad")
    public ResponseEntity<Map<String, Object>> obtenerDatosPorCiudad(@RequestParam String ciudad) {
        // Llamamos al servicio para obtener los datos del clima
        WeatherDataEntity weatherData = weatherDataService.obtenerPronostico(ciudad);

        // Crear un mapa para devolver la respuesta con las unidades de medida
        Map<String, Object> response = new HashMap<>();
        response.put("id", weatherData.getId());

        // Sensación térmica con °C
        response.put("sensacionTermica", weatherData.getSensacionTermica() + " °C");

        // Velocidad del viento en km/h (convertida de m/s a km/h)
        double velocidadVientoKmH = weatherData.getVelocidadViento() * 3.6;
        response.put("velocidadViento", velocidadVientoKmH + " km/h");

        // Humedad con %
        response.put("humedad", weatherData.getHumedad() + " %");

        // Nubosidad con %
        response.put("nubosidad", weatherData.getNubosidad() + " %");

        // Añadir la información de la condición climática
        Map<String, Object> condicionClimatica = new HashMap<>();
        condicionClimatica.put("id", weatherData.getCondicionClimatica().getId());
        condicionClimatica.put("tipo", weatherData.getCondicionClimatica().obtenerTipo());
        response.put("condicionClimatica", condicionClimatica);

        // Añadir la información de la temperatura
        Map<String, Object> temperatura = new HashMap<>();
        temperatura.put("id", weatherData.getTemperatura().getId());
        temperatura.put("tipo", weatherData.getTemperatura().obtenerTipo());
        response.put("temperatura", temperatura);

        return ResponseEntity.ok(response);
    }
}



