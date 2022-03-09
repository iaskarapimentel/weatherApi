package com.example.weatherapi;

import com.example.weatherapi.rest.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {

    private final WebClient webClient;

    public WeatherService(WebClient.Builder builder){
      webClient = builder.baseUrl("http://api.weatherapi.com/v1")
          .build();
    }

  public Weather getWeather(String city) {
    return webClient
        .get()
        .uri(uriBuilder -> uriBuilder
            .path("/current.json")
            .queryParam("key", "3313ce1f441f4149a1c144217220303") // put API key here
            .queryParam("q", city)
            .queryParam("aqi", "yes")
            .build())
        .retrieve() // Perform the HTTP request and retrieve the response body
        .bodyToMono(Weather.class)
        .block(); // returns the body as an array of User
  }
}
