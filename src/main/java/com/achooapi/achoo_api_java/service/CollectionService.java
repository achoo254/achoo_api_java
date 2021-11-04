package com.achooapi.achoo_api_java.service;

import com.achooapi.achoo_api_java.model.dto.ApiDto;
import com.achooapi.achoo_api_java.model.dto.CollectionDto;

public interface CollectionService {
    Object findAll();
    Object save(CollectionDto item);
    Object delete(String id);
}
