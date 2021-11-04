package com.achooapi.achoo_api_java.ultis;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import java.util.*;
import java.util.stream.Collectors;

@Log4j2
public class GlobalFunction {

    public static <S, T> List<T> formatMapList( List<S> listSource, Class<T> target) {
        ModelMapper modelMapper = new ModelMapper();
        return listSource.stream().map(source -> modelMapper.map(source, target)).collect(Collectors.toList());
    }
}
