package com.ambevtech.prova.dto.previsao;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrevisaoDto implements Serializable {

    private String nomeCidade;

    private List<TemperaturaDto> temperatura;

}
