package com.achooapi.achoo_api_java.controller;

import com.achooapi.achoo_api_java.model.dto.CollectionDto;
import com.achooapi.achoo_api_java.model.dto.MethodDto;
import com.achooapi.achoo_api_java.service.MethodService;
import com.achooapi.achoo_api_java.service.UsersService;
import com.achooapi.achoo_api_java.ultis.ActionResponse;
import com.achooapi.achoo_api_java.ultis.GlobalVariable;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(GlobalVariable.URI_API + "/method")
public class MethodController {
    final MethodService methodService;

    public MethodController(MethodService methodService) {
        this.methodService = methodService;
    }

    @GetMapping(value = "")
    @ResponseBody
    public Object findAll() {
        try {
            return ActionResponse.actionSuccess(methodService.findAll(), GlobalVariable.ACTION_FIND);
        } catch (Exception ex) {
            log.error(ex);
            return ActionResponse.actionFail(ex + GlobalVariable.ACTION_FIND);
        }
    }

    @PostMapping(value = "")
    @ResponseBody
    public Object findById(@RequestBody(required = false) MethodDto item) {
        try {
            return ActionResponse.actionSuccess(methodService.findById(item.getId()), GlobalVariable.ACTION_FIND);
        } catch (Exception ex) {
            log.error(ex);
            return ActionResponse.actionFail(ex + GlobalVariable.ACTION_FIND);
        }
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public Object save(@RequestBody(required = false) MethodDto item) {
        try {
            Object object = methodService.save(item);
            return ActionResponse.actionSuccess(object, GlobalVariable.ACTION_CREATE);
        } catch (Exception ex) {
            log.error(ex);
            return ActionResponse.actionFail(ex + GlobalVariable.ACTION_CREATE);
        }
    }
}
