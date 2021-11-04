package com.achooapi.achoo_api_java.service;

import com.achooapi.achoo_api_java.model.dto.ApiDto;

public interface ApiService {
    Object findAll();
    Object save(ApiDto item);
    Object delete(String id);
}
