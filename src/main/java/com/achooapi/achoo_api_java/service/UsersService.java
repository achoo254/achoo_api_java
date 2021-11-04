package com.achooapi.achoo_api_java.service;

import com.achooapi.achoo_api_java.model.dto.ApiDto;
import com.achooapi.achoo_api_java.model.dto.UsersDto;

public interface UsersService {
    Object save(UsersDto item);
    Object findAll();
}
