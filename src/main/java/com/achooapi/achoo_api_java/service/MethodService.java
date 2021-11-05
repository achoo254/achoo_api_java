package com.achooapi.achoo_api_java.service;

import com.achooapi.achoo_api_java.model.dto.MethodDto;

public interface MethodService {
    Object save(MethodDto item);
    Object findAll();
    Object findById(String id);
}
