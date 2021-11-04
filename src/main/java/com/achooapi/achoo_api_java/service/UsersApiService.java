package com.achooapi.achoo_api_java.service;

import com.achooapi.achoo_api_java.model.dto.ApiDto;

public interface UsersApiService {
    Object findAll();
    Object findById(String id);
    Object delete(String id);
}
