package com.example.pogodynka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/"})
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String gerWeather(Model model) {
        model.addAttribute("weatherCity", weatherService.getWeatherForCity());
        model.addAttribute("weatherIcon", weatherService.getImage());
        model.addAttribute("city", new WeatherService());
        return "weather";
    }

    @PostMapping({"city"})
    public String weathersCity(@RequestParam String city) {
        this.weatherService.setCity(city);
        return "redirect:/";
    }
}