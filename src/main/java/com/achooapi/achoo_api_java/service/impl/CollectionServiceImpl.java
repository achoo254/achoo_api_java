package com.achooapi.achoo_api_java.service.impl;

import com.achooapi.achoo_api_java.model.dto.ApiDto;
import com.achooapi.achoo_api_java.model.dto.CollectionDto;
import com.achooapi.achoo_api_java.model.entity.Api;
import com.achooapi.achoo_api_java.model.entity.Collection;
import com.achooapi.achoo_api_java.model.repository.CollectionRepository;
import com.achooapi.achoo_api_java.service.CollectionService;
import com.achooapi.achoo_api_java.ultis.GlobalFunction;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class CollectionServiceImpl implements CollectionService {
    final CollectionRepository collectionRepository;

    final ModelMapper modelMapper = new ModelMapper();

    public CollectionServiceImpl(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    @Override
    public Object findAll() {
        List<CollectionDto> collectionDtoList = new ArrayList<>();
        List<Collection> collectionList = collectionRepository.findAll();
        if(collectionList.size() > 0){
            return GlobalFunction.formatMapList(collectionList, CollectionDto.class);
        }
        return collectionDtoList;
    }

    @Override
    public Object save(CollectionDto item) {
        List<CollectionDto> collectionList = new ArrayList<>();
        Collection itemSave = modelMapper.map(item, Collection.class);
        collectionRepository.save(itemSave);
        collectionList.add(modelMapper.map(itemSave, CollectionDto.class));
        return collectionList;
    }

    @Override
    public Object delete(String id) {
        boolean deleteSuccess = false;
        try{
            collectionRepository.deleteById(id);
            deleteSuccess = true;
        }catch (Exception e){
            log.error("Khong the xoa id collection: " + e);
        }

        return deleteSuccess;
    }
}
