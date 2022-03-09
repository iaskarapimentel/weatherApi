package com.example.weatherapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WeatherController {

  @Autowired
  private WeatherService weatherService;

  @GetMapping("/weather/{city}")
  public ModelAndView currentWeather(@PathVariable String city){

    ModelAndView mv = new ModelAndView("weather");
    mv.addObject("city", weatherService.getWeather(city));
    mv.addObject("name", weatherService.getWeather(city));

    return mv;
  }
}
