package com.achooapi.achoo_api_java.controller;

import com.achooapi.achoo_api_java.model.dto.HeaderDto;
import com.achooapi.achoo_api_java.model.dto.ParameterDto;
import com.achooapi.achoo_api_java.service.HeaderService;
import com.achooapi.achoo_api_java.service.ParameterService;
import com.achooapi.achoo_api_java.ultis.ActionResponse;
import com.achooapi.achoo_api_java.ultis.GlobalVariable;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(GlobalVariable.URI_API + "/parameter")
public class ParameterController {
    final ParameterService parameterService;

    public ParameterController(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

    @PostMapping(value = "")
    @ResponseBody
    public Object saveAll(@RequestBody(required = false) ParameterDto item) {
        try {
            return ActionResponse.actionSuccess(parameterService.save(item), GlobalVariable.ACTION_CREATE);
        } catch (Exception ex) {
            log.error(ex);
            return ActionResponse.actionFail(ex + GlobalVariable.ACTION_CREATE);
        }
    }
}
