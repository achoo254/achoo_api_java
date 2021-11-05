package com.achooapi.achoo_api_java.service.impl;

import com.achooapi.achoo_api_java.model.dto.HeaderDto;
import com.achooapi.achoo_api_java.model.dto.ParameterDto;
import com.achooapi.achoo_api_java.model.entity.Header;
import com.achooapi.achoo_api_java.model.entity.Parameter;
import com.achooapi.achoo_api_java.model.repository.ParameterRepository;
import com.achooapi.achoo_api_java.service.ParameterService;
import com.achooapi.achoo_api_java.ultis.GlobalFunction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParameterServiceImpl implements ParameterService {
    final ParameterRepository parameterRepository;
    final ModelMapper modelMapper = new ModelMapper();

    public ParameterServiceImpl(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    @Override
    public Object save(ParameterDto item) {
        List<ParameterDto> parameterDtoList = new ArrayList<>();
        Parameter itemSave = modelMapper.map(item, Parameter.class);
        parameterRepository.save(itemSave);
        parameterDtoList.add(modelMapper.map(itemSave, ParameterDto.class));
        return parameterDtoList;
    }
}
