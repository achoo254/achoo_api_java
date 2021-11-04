package com.achooapi.achoo_api_java.controller;

import com.achooapi.achoo_api_java.model.dto.ApiDto;
import com.achooapi.achoo_api_java.model.dto.HeaderDto;
import com.achooapi.achoo_api_java.service.ApiService;
import com.achooapi.achoo_api_java.service.HeaderService;
import com.achooapi.achoo_api_java.ultis.ActionResponse;
import com.achooapi.achoo_api_java.ultis.GlobalVariable;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(GlobalVariable.URI_API + "/header")
public class HeaderController {
    final HeaderService headerService;

    public HeaderController(HeaderService headerService) {
        this.headerService = headerService;
    }

    @PostMapping(value = "")
    @ResponseBody
    public Object saveAll(@RequestBody(required = false) List<HeaderDto> itemList) {
        try {
            return ActionResponse.actionSuccess(headerService.saveAll(itemList), GlobalVariable.ACTION_CREATE);
        } catch (Exception ex) {
            log.error(ex);
            return ActionResponse.actionFail(ex + GlobalVariable.ACTION_CREATE);
        }
    }
}
