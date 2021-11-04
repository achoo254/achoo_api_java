package com.achooapi.achoo_api_java.service;

import com.achooapi.achoo_api_java.model.dto.ApiDto;
import com.achooapi.achoo_api_java.model.dto.HeaderDto;
import com.achooapi.achoo_api_java.model.entity.Header;

import java.util.List;

public interface HeaderService {
    Object saveAll(List<HeaderDto> itemList);
}
