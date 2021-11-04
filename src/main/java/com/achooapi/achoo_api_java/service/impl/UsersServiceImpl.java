package com.achooapi.achoo_api_java.service.impl;

import com.achooapi.achoo_api_java.model.dto.MethodDto;
import com.achooapi.achoo_api_java.model.dto.UsersDto;
import com.achooapi.achoo_api_java.model.entity.Api;
import com.achooapi.achoo_api_java.model.entity.Method;
import com.achooapi.achoo_api_java.model.entity.Users;
import com.achooapi.achoo_api_java.model.repository.UsersRepository;
import com.achooapi.achoo_api_java.service.UsersService;
import com.achooapi.achoo_api_java.ultis.GlobalFunction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    final UsersRepository usersRepository;
    final ModelMapper modelMapper = new ModelMapper();

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Object save(UsersDto item) {
        Users itemSave = modelMapper.map(item, Users.class);
        usersRepository.save(itemSave);
        return itemSave;
    }

    @Override
    public Object findAll() {
        List<UsersDto> usersDtoList = new ArrayList<>();
        List<Users> usersList = usersRepository.findAll();
        if(usersList.size() > 0){
            return GlobalFunction.formatMapList(usersList, UsersDto.class);
        }
        return usersDtoList;
    }
}
