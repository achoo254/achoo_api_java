package com.achooapi.achoo_api_java.service;

import com.achooapi.achoo_api_java.model.dto.ParameterDto;
import com.achooapi.achoo_api_java.model.entity.Header;
import com.achooapi.achoo_api_java.model.entity.Parameter;

import java.util.List;

public interface ParameterService {
    Object save(ParameterDto item);
}
