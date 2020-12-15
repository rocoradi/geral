package com.ambevtech.prova;

import com.ambevtech.prova.util.Constantes;
import com.github.prominence.openweathermap.api.HourlyForecastRequester;
import com.github.prominence.openweathermap.api.OpenWeatherMapManager;
import com.github.prominence.openweathermap.api.constants.Accuracy;
import com.github.prominence.openweathermap.api.constants.Language;
import com.github.prominence.openweathermap.api.constants.Unit;
import com.github.prominence.openweathermap.api.model.response.HourlyForecast;
import org.springframework.stereotype.Service;

public class Teste {

    public static void main(String[] args) {
        OpenWeatherMapManager openWeatherMapManager = new OpenWeatherMapManager(Constantes.OpenWeatherConfigs.TOKEN);
        HourlyForecastRequester request = openWeatherMapManager.getHourlyForecastRequester();
        HourlyForecast response = request
                                    .setLanguage(Language.PORTUGUESE)
                                    .setUnitSystem(Unit.METRIC_SYSTEM)
                                    .setAccuracy(Accuracy.ACCURATE)
                                    .getByCityName("Assis");

        response.toString();
       response.getForecasts().toString();
    }

}
