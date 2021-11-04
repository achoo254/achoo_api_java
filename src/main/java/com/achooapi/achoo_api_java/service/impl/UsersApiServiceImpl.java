package com.achooapi.achoo_api_java.service.impl;

import com.achooapi.achoo_api_java.model.dto.ApiDto;
import com.achooapi.achoo_api_java.model.dto.MethodDto;
import com.achooapi.achoo_api_java.model.dto.UsersApiDto;
import com.achooapi.achoo_api_java.model.entity.Api;
import com.achooapi.achoo_api_java.model.entity.Method;
import com.achooapi.achoo_api_java.model.entity.UsersApi;
import com.achooapi.achoo_api_java.model.repository.ApiRepository;
import com.achooapi.achoo_api_java.model.repository.UsersApiRepository;
import com.achooapi.achoo_api_java.service.ApiService;
import com.achooapi.achoo_api_java.service.UsersApiService;
import com.achooapi.achoo_api_java.ultis.GlobalFunction;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class UsersApiServiceImpl implements UsersApiService {
    final UsersApiRepository usersApiRepository;

    final ModelMapper modelMapper = new ModelMapper();

    public UsersApiServiceImpl(UsersApiRepository usersApiRepository) {
        this.usersApiRepository = usersApiRepository;
    }

    @Override
    public Object findAll() {
        List<UsersApiDto> usersApiDtoList = new ArrayList<>();
        List<UsersApi> usersApiList = usersApiRepository.findAll();
        if(usersApiList.size() > 0){
            return GlobalFunction.formatMapList(usersApiList, UsersApiDto.class);
        }
        return usersApiDtoList;
    }

    @Override
    public Object findById(String id) {
        Optional<UsersApi> usersApi = usersApiRepository.findById(id);
        if(usersApi.isPresent()){
            return modelMapper.map(usersApi.get(), UsersApiDto.class);
        }
        return new UsersApiDto();
    }

    @Override
    public Object delete(String id) {
        boolean deleteSuccess = false;
        try{
            usersApiRepository.deleteById(id);
            deleteSuccess = true;
        }catch (Exception e){
            log.error("Khong the xoa id api: " + e);
        }

        return deleteSuccess;
    }
}
