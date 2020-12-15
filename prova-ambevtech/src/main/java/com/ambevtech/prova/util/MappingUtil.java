package com.ambevtech.prova.util;

import com.ambevtech.prova.exception.EnumErrorException;
import com.ambevtech.prova.exception.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class MappingUtil {

    @Autowired
    private ModelMapper mapper;

    private static ModelMapper staticMapper;

    @PostConstruct
    public void init() {
        MappingUtil.staticMapper = mapper;
    }

    public static <D> D map(final Object source, final Class<D> target) throws ServiceException {
        try {
            return staticMapper.map(source, target);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(EnumErrorException.ERRO_INTERNO, new Object[]{"Extrair informações do objeto"});
        }
    }

    public static void map(Object source, Object destination) throws ServiceException {
        try {
            staticMapper.map(source, destination);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(EnumErrorException.ERRO_INTERNO, new Object[]{"Extrair informações do objeto"});
        }
    }

    public static <T, U> List<U> mapList(final List<T> source, final Class<U> destType) {
        final List<U> dest = new ArrayList<>();
        try {
            for (T element : source) {
                dest.add(staticMapper.map(element, destType));
            }
            return dest;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(EnumErrorException.ERRO_INTERNO, new Object[]{"Extrair informações do objeto"});
        }
    }

}
