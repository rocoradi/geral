package com.ambevtech.prova.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Cidade", description = "DTO responsável por poular a cidade")
public class CidadeFrontDto implements Serializable {

    @ApiModelProperty(value = "ID da cidade cadastrada")
    private Integer id;

    @NotEmpty
    @ApiModelProperty(value = "Nome da cidade", required = true, allowEmptyValue = false)
    private String nome;

    @NotEmpty
    @Length(min = 2, max = 2)
    @ApiModelProperty(value = "Estado da cidade", required = true, allowEmptyValue = false)
    private String uf;

}
