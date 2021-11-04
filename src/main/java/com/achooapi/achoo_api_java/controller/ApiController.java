package com.achooapi.achoo_api_java.controller;

import com.achooapi.achoo_api_java.model.dto.ApiDto;
import com.achooapi.achoo_api_java.service.ApiService;
import com.achooapi.achoo_api_java.ultis.ActionResponse;
import com.achooapi.achoo_api_java.ultis.GlobalVariable;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(GlobalVariable.URI_API + "/api")
public class ApiController {
    final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping(value = "")
    @ResponseBody
    public Object save(@RequestBody(required = false) ApiDto item) {
        try {
            Object object = apiService.save(item);
            return ActionResponse.actionSuccess(object, GlobalVariable.ACTION_CREATE);
        } catch (Exception ex) {
            log.error(ex);
            return ActionResponse.actionFail(ex + GlobalVariable.ACTION_CREATE);
        }
    }

    @GetMapping(value = "")
    @ResponseBody
    public Object findAll() {
        try {
            return ActionResponse.actionSuccess(apiService.findAll(), GlobalVariable.ACTION_FIND);
        } catch (Exception ex) {
            log.error(ex);
            return ActionResponse.actionFail(ex + GlobalVariable.ACTION_FIND);
        }
    }
}
