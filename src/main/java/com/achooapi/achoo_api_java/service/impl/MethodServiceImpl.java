package com.achooapi.achoo_api_java.service.impl;

import com.achooapi.achoo_api_java.model.dto.CollectionDto;
import com.achooapi.achoo_api_java.model.dto.MethodDto;
import com.achooapi.achoo_api_java.model.entity.Collection;
import com.achooapi.achoo_api_java.model.entity.Method;
import com.achooapi.achoo_api_java.model.repository.MethodRepository;
import com.achooapi.achoo_api_java.service.MethodService;
import com.achooapi.achoo_api_java.ultis.GlobalFunction;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class MethodServiceImpl implements MethodService {
    final MethodRepository methodRepository;
    final ModelMapper modelMapper = new ModelMapper();

    public MethodServiceImpl(MethodRepository methodRepository) {
        this.methodRepository = methodRepository;
    }

    @Override
    public Object findAll() {
        List<MethodDto> methodDtoList = new ArrayList<>();
        List<Method> methodList = methodRepository.findAll();
        if(methodList.size() > 0){
            return GlobalFunction.formatMapList(methodList, MethodDto.class);
        }
        return methodDtoList;
    }

    @Override
    public Object findById(String id) {
        Optional<Method> method = methodRepository.findById(id);
        if(method.isPresent()){
            return modelMapper.map(method.get(), MethodDto.class);
        }
        return new MethodDto();
    }
}
