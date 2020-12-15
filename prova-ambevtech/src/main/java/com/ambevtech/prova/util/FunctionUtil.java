package com.ambevtech.prova.util;

import com.ambevtech.prova.exception.EnumErrorException;
import com.ambevtech.prova.exception.ServiceException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

public class FunctionUtil {

    public static boolean isEmpty(String texto) {
        return (texto == null || texto.trim().equals(""));
    }

    public static boolean isEmpty(Collection<?> list) {
        return (list == null || list.isEmpty() || list.size() == 0);
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean notNull(Object object) {
        return object != null;
    }

    public static boolean isEmpty(Number numero) {
        if (numero == null) {
            return true;
        }

        if (numero instanceof Integer && numero.intValue() <= 0) {
            return true;
        }

        if (numero instanceof Long && numero.longValue() <= 0) {
            return true;
        }

        if (numero instanceof BigDecimal && ((BigDecimal) numero).equals(BigDecimal.ZERO)) {
            return true;
        }

        if (numero instanceof BigInteger && ((BigInteger) numero).equals(BigInteger.ZERO)) {
            return true;
        }

        return false;
    }

    public static Set<ConstraintViolation<Object>> validarEntidade(Object entidade) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        return validator.validate(entidade);
    }

    public static String formataData(Date data) throws ServiceException {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            return formato.format(data);
        } catch (Exception e) {
            throw new ServiceException(EnumErrorException.ERRO_INTERNO, new Object[]{"Falha ao converter data"});
        }
    }
}
