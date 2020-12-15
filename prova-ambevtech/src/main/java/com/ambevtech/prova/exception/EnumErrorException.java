package com.ambevtech.prova.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum EnumErrorException {

    PARAMETROS_INVALIDOS(HttpStatus.BAD_REQUEST,
            "Erro",
            "Corpo e/ou parametros da requisição inválido(s).",
            "{0}"),

    NOT_FOUND(HttpStatus.NOT_FOUND,
            "Aviso",
            "Dados inválidos",
            "{0}"),

    CONFLICT(HttpStatus.CONFLICT,
            "Aviso",
            "Inválido",
            "{0}"),

    DUPLICATE(HttpStatus.CONFLICT,
            "Aviso",
            "Registro duplicado",
            "{0}"),

    NO_CONTENT(HttpStatus.NO_CONTENT,
            "Atenção",
            "Nenhum registro",
            "Nenhum(nha) {0} foi localizado."),

    BAD_REQUEST(HttpStatus.INTERNAL_SERVER_ERROR,
            "Error",
            "Falha ao realizar operação",
            "{0}"),

    ERRO_INTERNO(HttpStatus.INTERNAL_SERVER_ERROR,
            "Erro",
            "Erro interno.",
            "Não foi possível realizar operação: {0}"),

    ;


    EnumErrorException(HttpStatus httpStatus, String tipo, String nome, String detalhe) {
        this.httpStatus = httpStatus;
        this.tipo = tipo;
        this.nome = nome;
        this.detalhe = detalhe;
    }

    private HttpStatus httpStatus;

    private String nome;

    private String detalhe;

    private String tipo;

}
