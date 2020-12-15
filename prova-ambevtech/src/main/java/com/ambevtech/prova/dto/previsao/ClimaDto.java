package com.ambevtech.prova.dto.previsao;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClimaDto implements Serializable {

    private String previsao;
    private String urlIcone;
}
