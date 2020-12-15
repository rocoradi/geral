package com.ambevtech.prova.service;

import com.ambevtech.prova.dto.previsao.ClimaDto;
import com.ambevtech.prova.dto.previsao.PrevisaoDto;
import com.ambevtech.prova.dto.previsao.TemperaturaDto;
import com.ambevtech.prova.exception.EnumErrorException;
import com.ambevtech.prova.exception.ServiceException;
import com.ambevtech.prova.util.Constantes;
import com.ambevtech.prova.util.FunctionUtil;
import com.github.prominence.openweathermap.api.HourlyForecastRequester;
import com.github.prominence.openweathermap.api.OpenWeatherMapManager;
import com.github.prominence.openweathermap.api.WeatherRequester;
import com.github.prominence.openweathermap.api.exception.DataNotFoundException;
import com.github.prominence.openweathermap.api.model.response.HourlyForecast;
import com.github.prominence.openweathermap.api.model.response.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PrevisaoTempoService {

    private Logger logger = LoggerFactory.getLogger(PrevisaoTempoService.class);
    private OpenWeatherMapManager openWeatherMapManager;

    public PrevisaoTempoService() {
        this.openWeatherMapManager = new OpenWeatherMapManager(Constantes.OpenWeatherConfigs.TOKEN);
    }

    public void validarCidade(String nome) throws ServiceException {
        WeatherRequester weatherRequester = openWeatherMapManager.getWeatherRequester();
        Weather weather = null;
        try {
            logger.info("Consultando previsão do tempo na API para a cidade: " + nome);
            weather = weatherRequester.setLanguage(Constantes.OpenWeatherConfigs.LANGUAGE)
                    .setUnitSystem(Constantes.OpenWeatherConfigs.METRIC)
                    .setAccuracy(Constantes.OpenWeatherConfigs.ACCURATE)
                    .getByCityName(nome);

            logger.info("Consulta realizada...: " + weather.toString());
        } catch (DataNotFoundException de) {
            logger.error("Cidade não encontrada na base da API de previsão do tempo.");
            throw new ServiceException(EnumErrorException.PARAMETROS_INVALIDOS, new Object[]{"Cidade informada não existe na base de dados da previsão do tempo."});
        } catch (Exception e) {
            logger.error("Falha ao consultar API de previsão do tempo: " + e.getMessage());
            throw new ServiceException(EnumErrorException.ERRO_INTERNO, new Object[]{e.getMessage()});
        }
    }

    public PrevisaoDto consultarPrevisao(String nome) throws ServiceException {
        HourlyForecast response = null;
        try {
            logger.info("Conectando na api de previsão do tempo...");
            HourlyForecastRequester requester = openWeatherMapManager.getHourlyForecastRequester();
            response = requester.setLanguage(Constantes.OpenWeatherConfigs.LANGUAGE)
                    .setUnitSystem(Constantes.OpenWeatherConfigs.METRIC)
                    .setAccuracy(Constantes.OpenWeatherConfigs.ACCURATE)
                    .getByCityName(nome);
        } catch (Exception e) {
            logger.error("Falha ao consultar previsão do tempo na api: " + e.getMessage());
            throw new ServiceException(EnumErrorException.ERRO_INTERNO, new Object[]{"Falha ao consultar previsão do tempo"});
        }

        logger.info("Processando retorno da api...");
        return converterRetorno(response);
    }

    private PrevisaoDto converterRetorno(HourlyForecast response) throws ServiceException {
        try {
            List<TemperaturaDto> temperaturas = new ArrayList<>();
            response.getForecasts().forEach(forecast -> {
                temperaturas.add(TemperaturaDto.builder()
                        .data(FunctionUtil.formataData(forecast.getDataCalculationDate()))
                        .hora(Instant.ofEpochMilli(new Date(forecast.getDataCalculationTime() * 1000).getTime()).atZone(ZoneId.systemDefault()).toLocalTime().toString())
                        .temperatura(new BigDecimal(forecast.getWeatherInfo().getTemperature()).setScale(0, RoundingMode.FLOOR))
                        .temperaturaMaxima(new BigDecimal(forecast.getWeatherInfo().getMaximumTemperature()).setScale(0, RoundingMode.FLOOR))
                        .temperaturaMinima(new BigDecimal(forecast.getWeatherInfo().getMinimumTemperature()).setScale(0, RoundingMode.FLOOR))
                        .clima(ClimaDto.builder().previsao(forecast.getWeatherStates().get(0).getDescription())
                                                 .urlIcone(forecast.getWeatherStates().get(0).getWeatherIconUrl().toString()).build())
                        .build());
            });
            logger.info("Consulta realizada com sucesso...");
            getRetorno(response);
            return PrevisaoDto.builder().nomeCidade(response.getCityName()).temperatura(temperaturas).build();
        } catch (Exception e) {
            logger.error("Falha ao converter retorno da api: " + e.getMessage());
            throw new ServiceException(EnumErrorException.ERRO_INTERNO, new Object[]{"Falha ao converter retorno da api"});
        }
    }

    private void getRetorno(HourlyForecast response) throws ServiceException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cidade: " + response.getCityInfo().getName());
        response.getForecasts().forEach(forecast -> {
            LocalTime dateTime = Instant.ofEpochMilli(new Date(forecast.getDataCalculationTime() * 1000).getTime()).atZone(ZoneId.systemDefault()).toLocalTime();
            stringBuilder.append("Data: " + FunctionUtil.formataData(forecast.getDataCalculationDate()) + " - Hora: " + dateTime);
            stringBuilder.append(" - Temperatura: " + forecast.getWeatherInfo().getTemperature());
            stringBuilder.append(" - Máxima do Dia: " + forecast.getWeatherInfo().getMaximumTemperature());
            stringBuilder.append(" - Mínima do Dia: " + forecast.getWeatherInfo().getMinimumTemperature());
            forecast.getWeatherStates().forEach(weatherState -> {
                stringBuilder.append(" - Clima: " + weatherState.getDescription());
                stringBuilder.append(" - Icon: " + weatherState.getWeatherIconUrl());
                stringBuilder.append("\n");
            });
        });

        System.out.println(stringBuilder.toString());
    }
}
