package com.achooapi.achoo_api_java.controller;

import com.achooapi.achoo_api_java.model.dto.ApiDto;
import com.achooapi.achoo_api_java.model.dto.HeaderDto;
import com.achooapi.achoo_api_java.model.dto.UsersDto;
import com.achooapi.achoo_api_java.service.HeaderService;
import com.achooapi.achoo_api_java.service.UsersService;
import com.achooapi.achoo_api_java.ultis.ActionResponse;
import com.achooapi.achoo_api_java.ultis.GlobalVariable;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(GlobalVariable.URI_API + "/users")
public class UsersController {
    final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "")
    @ResponseBody
    public Object findAll() {
        try {
            return ActionResponse.actionSuccess(usersService.findAll(), GlobalVariable.ACTION_FIND);
        } catch (Exception ex) {
            log.error(ex);
            return ActionResponse.actionFail(ex + GlobalVariable.ACTION_FIND);
        }
    }

    @PostMapping(value = "")
    @ResponseBody
    public Object save(@RequestBody(required = false) UsersDto item) {
        try {
            Object object = usersService.save(item);
            return ActionResponse.actionSuccess(object, GlobalVariable.ACTION_CREATE);
        } catch (Exception ex) {
            log.error(ex);
            return ActionResponse.actionFail(ex + GlobalVariable.ACTION_CREATE);
        }
    }
}
