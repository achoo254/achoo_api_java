package com.achooapi.achoo_api_java.service.impl;

import com.achooapi.achoo_api_java.model.dto.HeaderDto;
import com.achooapi.achoo_api_java.model.entity.Header;
import com.achooapi.achoo_api_java.model.repository.HeaderRepository;
import com.achooapi.achoo_api_java.service.HeaderService;
import com.achooapi.achoo_api_java.ultis.GlobalFunction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeaderServiceImpl implements HeaderService {
    final HeaderRepository headerRepository;

    public HeaderServiceImpl(HeaderRepository headerRepository) {
        this.headerRepository = headerRepository;
    }

    @Override
    public Object saveAll(List<HeaderDto> itemList) {
        return headerRepository.saveAll(GlobalFunction.formatMapList(itemList, Header.class));
    }
}
