package com.fie.apiturismo.vega.Services;

import com.fie.apiturismo.vega.Entities.CondicionClimatica.*;
import com.fie.apiturismo.vega.Entities.Temperatura.Calido;
import com.fie.apiturismo.vega.Entities.Temperatura.Frio;
import com.fie.apiturismo.vega.Entities.Temperatura.Templado;
import com.fie.apiturismo.vega.Entities.WeatherDataEntity;
import com.fie.apiturismo.vega.Repositories.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fie.apiturismo.vega.Entities.CondicionClimaticaEntity;
import com.fie.apiturismo.vega.Entities.*;
import com.fie.apiturismo.vega.Repositories.CondicionClimaticaRepository;
import com.fie.apiturismo.vega.Repositories.TemperaturaRepository;
import org.springframework.web.client.RestTemplate;

import org.json.JSONObject;

@Service
public class WeatherDataService {

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @Autowired
    private CondicionClimaticaRepository condicionClimaticaRepository;

    @Autowired
    private TemperaturaRepository temperaturaRepository;

    private final String API_KEY = "f492bd9c121971074e2b2c0faf2fd2a0";
    private final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=";

    public WeatherDataEntity obtenerPronostico(String ciudad) {
        // Crear un RestTemplate para realizar la petición HTTP
        RestTemplate restTemplate = new RestTemplate();

        // Realizar la petición a OpenWeatherMap
        String url = API_URL + ciudad + "&appid=" + API_KEY;
        String jsonResponse = restTemplate.getForObject(url, String.class);

        // Parsear la respuesta JSON
        JSONObject jsonObject = new JSONObject(jsonResponse);

        // Obtener los datos necesarios del JSON
        JSONObject main = jsonObject.getJSONObject("main");
        JSONObject weather = jsonObject.getJSONArray("weather").getJSONObject(0);
        JSONObject wind = jsonObject.getJSONObject("wind");

        // Crear la entidad WeatherDataEntity
        WeatherDataEntity weatherData = new WeatherDataEntity();
        weatherData.setSensacionTermica(main.getDouble("feels_like") - 273.15); // Convertir de Kelvin a Celsius

        weatherData.setHumedad(main.getInt("humidity"));
        weatherData.setVelocidadViento(wind.getDouble("speed"));
        weatherData.setNubosidad(jsonObject.getJSONObject("clouds").getInt("all"));

        // Crear o buscar la condición climática
        String condicionClimatica = weather.getString("main");
        CondicionClimaticaEntity condicionEntity = crearCondicionClimatica(condicionClimatica);

        // Asegurarse de que la entidad CondicionClimatica está persistida
        condicionEntity = condicionClimaticaRepository.save(condicionEntity);  // Guardar CondicionClimaticaEntity
        weatherData.setCondicionClimatica(condicionEntity);

        // Crear o buscar la temperatura adecuada
        double temperatura = main.getDouble("temp") - 273.15; // Convertir de Kelvin a Celsius
        TemperaturaEntity temperaturaEntity = crearTemperaturaEntity(temperatura);

        // Asegurarse de que la entidad Temperatura está persistida
        temperaturaEntity = temperaturaRepository.save(temperaturaEntity);  // Guardar TemperaturaEntity
        weatherData.setTemperatura(temperaturaEntity);

        // Guardar WeatherDataEntity
        return weatherDataRepository.save(weatherData);
    }

    // Lógica para crear la subclase adecuada de CondicionClimaticaEntity
    private CondicionClimaticaEntity crearCondicionClimatica(String tipo) {
        switch (tipo) {
            case "Clear":
                return new Despejado();
            case "Clouds":
                return new Nublado();
            case "Rain":
                return new Lluvia();
            case "Snow":
                return new Nieve();
            case "Thunderstorm":
                return new Tormenta();
            default:
                throw new IllegalArgumentException("Condición climática no reconocida: " + tipo);
        }
    }


    // Lógica para crear la subclase adecuada de TemperaturaEntity
    private TemperaturaEntity crearTemperaturaEntity(double tempCelsius) {
        if (tempCelsius <= 10) {
            return new Frio();
        } else if (tempCelsius <= 25) {
            return new Templado();
        } else {
            return new Calido();
        }
    }




}


