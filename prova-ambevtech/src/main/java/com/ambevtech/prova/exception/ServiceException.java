package com.ambevtech.prova.exception;

import lombok.Getter;

import javax.validation.ConstraintViolation;
import java.text.MessageFormat;
import java.util.Set;

@Getter
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private EnumErrorException errorException;
    private String formattedDetalhe;
    private Set<ConstraintViolation<Object>> violations;

    public ServiceException(EnumErrorException error) {
        super(error.getNome());
        this.errorException = error;
        this.formattedDetalhe = error.getDetalhe();
    }

    public ServiceException(Set<ConstraintViolation<Object>> violations) {
        super(EnumErrorException.PARAMETROS_INVALIDOS.getNome());
        this.errorException = EnumErrorException.PARAMETROS_INVALIDOS;
        this.formattedDetalhe = EnumErrorException.PARAMETROS_INVALIDOS.getDetalhe();
        this.violations = violations;
    }

    public ServiceException(EnumErrorException error, Object[] args) {
        super(error.getNome());
        this.errorException = error;
        this.formattedDetalhe = MessageFormat.format(this.errorException.getDetalhe(), args);
    }

    public ServiceException(EnumErrorException error, String detalhe) {
        super(error.getNome());
        this.errorException = error;
        this.formattedDetalhe = detalhe;
    }
}
