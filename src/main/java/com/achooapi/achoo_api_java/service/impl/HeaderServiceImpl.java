package com.achooapi.achoo_api_java.service.impl;

import com.achooapi.achoo_api_java.model.dto.HeaderDto;
import com.achooapi.achoo_api_java.model.dto.MethodDto;
import com.achooapi.achoo_api_java.model.entity.Header;
import com.achooapi.achoo_api_java.model.entity.Method;
import com.achooapi.achoo_api_java.model.repository.HeaderRepository;
import com.achooapi.achoo_api_java.service.HeaderService;
import com.achooapi.achoo_api_java.ultis.GlobalFunction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeaderServiceImpl implements HeaderService {
    final HeaderRepository headerRepository;
    final ModelMapper modelMapper = new ModelMapper();

    public HeaderServiceImpl(HeaderRepository headerRepository) {
        this.headerRepository = headerRepository;
    }

    @Override
    public Object save(HeaderDto item) {
        List<HeaderDto> headerDtoList = new ArrayList<>();
        Header itemSave = modelMapper.map(item, Header.class);
        headerRepository.save(itemSave);
        headerDtoList.add(modelMapper.map(itemSave, HeaderDto.class));
        return headerDtoList;
    }
}
