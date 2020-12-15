package com.ambevtech.prova.dto.previsao;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemperaturaDto implements Serializable {

    private String data;

    private String hora;

    private BigDecimal temperatura;

    private BigDecimal temperaturaMaxima;

    private BigDecimal temperaturaMinima;

    private ClimaDto clima;
}
