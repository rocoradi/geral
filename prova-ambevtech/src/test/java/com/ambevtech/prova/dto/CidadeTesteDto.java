package com.ambevtech.prova.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CidadeTesteDto implements Serializable {

    private String nome;
    private String uf;
}
