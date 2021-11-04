package com.achooapi.achoo_api_java.service.impl;

import com.achooapi.achoo_api_java.model.dto.ParameterDto;
import com.achooapi.achoo_api_java.model.entity.Header;
import com.achooapi.achoo_api_java.model.entity.Parameter;
import com.achooapi.achoo_api_java.model.repository.ParameterRepository;
import com.achooapi.achoo_api_java.service.ParameterService;
import com.achooapi.achoo_api_java.ultis.GlobalFunction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParameterServiceImpl implements ParameterService {
    final ParameterRepository parameterRepository;

    public ParameterServiceImpl(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    @Override
    public Object saveAll(List<ParameterDto> itemList) {
        return parameterRepository.saveAll(GlobalFunction.formatMapList(itemList, Parameter.class));
    }
}
