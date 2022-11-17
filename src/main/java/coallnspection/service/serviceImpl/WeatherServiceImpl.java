package coallnspection.service.serviceImpl;

import coallnspection.service.WeatherService;
import coallnspection.weather.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    Weather weather;


    @Override
    public String getTemperature() {
        return weather.getWeather();
    }
}
