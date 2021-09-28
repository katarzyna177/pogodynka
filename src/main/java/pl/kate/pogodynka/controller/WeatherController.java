package pl.kate.pogodynka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kate.pogodynka.service.WeatherService;

@Controller
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String gerWeather(Model model) {
        model.addAttribute("weatherCity", weatherService.getWeatherForCity());
        model.addAttribute("weatherIcon", weatherService.getIcon());
        model.addAttribute("city", new WeatherService());
        return "weather";
    }

    @PostMapping({"city"})
    public String weathersCity(@RequestParam String city) {
        this.weatherService.setCity(city);
        return "redirect:/";
    }
}