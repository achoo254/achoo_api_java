package com.achooapi.achoo_api_java.service.impl;

import com.achooapi.achoo_api_java.model.dto.ApiDto;
import com.achooapi.achoo_api_java.model.entity.Api;
import com.achooapi.achoo_api_java.model.repository.ApiRepository;
import com.achooapi.achoo_api_java.service.ApiService;
import com.achooapi.achoo_api_java.ultis.GlobalFunction;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ApiServiceImpl implements ApiService {
    final ApiRepository apiRepository;

    final ModelMapper modelMapper = new ModelMapper();

    public ApiServiceImpl(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    @Override
    public Object findAll() {
        List<ApiDto> apiDtoList = new ArrayList<>();
        List<Api> apiList = apiRepository.findAll();
        if(apiList.size() > 0){
            return GlobalFunction.formatMapList(apiList, ApiDto.class);
        }
        return apiDtoList;
    }

    @Override
    public Object save(ApiDto item) {
        Api api = modelMapper.map(item, Api.class);
        apiRepository.save(api);
        return api;
    }

    @Override
    public Object delete(String id) {
        boolean deleteSuccess = false;
        try{
            apiRepository.deleteById(id);
            deleteSuccess = true;
        }catch (Exception e){
            log.error("Khong the xoa id api: " + e);
        }

        return deleteSuccess;
    }
}
