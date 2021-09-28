package pl.kate.pogodynka.service;


import pl.kate.pogodynka.model.WeatherForCity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Getter
@Setter
@NoArgsConstructor
public class WeatherService {

    @Value("${apikey}")
    private String appid;
    private String city = "Białystok";

    public WeatherForCity getWeatherForCity() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + city
                + "&units=metric&lang=pl&appid="
                + appid;
        WeatherForCity weather = restTemplate.getForObject(url, WeatherForCity.class);
        return weather;
    }

    public String getIcon() {
        String iconName = this.getWeatherForCity().getWeather().get(0).getIcon();
        getWeatherForCity().setImage("http://openweathermap.org/img/wn/" + iconName + "@2x.png");
        String imgUrl ="http://openweathermap.org/img/wn/" + iconName + "@2x.png";
        getWeatherForCity().getWeather().get(0).setIcon(imgUrl);
        return imgUrl;
    }
}
