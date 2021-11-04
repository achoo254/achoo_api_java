package com.achooapi.achoo_api_java.controller;

import com.achooapi.achoo_api_java.model.dto.CollectionDto;
import com.achooapi.achoo_api_java.model.dto.MethodDto;
import com.achooapi.achoo_api_java.model.dto.UsersApiDto;
import com.achooapi.achoo_api_java.service.MethodService;
import com.achooapi.achoo_api_java.service.UsersApiService;
import com.achooapi.achoo_api_java.ultis.ActionResponse;
import com.achooapi.achoo_api_java.ultis.GlobalVariable;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(GlobalVariable.URI_API + "/users_api")
public class UsersApiController {
    final UsersApiService usersApiService;

    public UsersApiController(UsersApiService usersApiService) {
        this.usersApiService = usersApiService;
    }

    @GetMapping(value = "")
    @ResponseBody
    public Object findAll() {
        try {
            return ActionResponse.actionSuccess(usersApiService.findAll(), GlobalVariable.ACTION_FIND);
        } catch (Exception ex) {
            log.error(ex);
            return ActionResponse.actionFail(ex + GlobalVariable.ACTION_FIND);
        }
    }

    @PostMapping(value = "")
    @ResponseBody
    public Object findById(@RequestBody(required = false) UsersApiDto item) {
        try {
            return ActionResponse.actionSuccess(usersApiService.findById(item.getId()), GlobalVariable.ACTION_FIND);
        } catch (Exception ex) {
            log.error(ex);
            return ActionResponse.actionFail(ex + GlobalVariable.ACTION_FIND);
        }
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestBody(required = false) UsersApiDto item) {
        try {
            Object object = usersApiService.delete(item.getId());
            return ActionResponse.actionSuccess(object, GlobalVariable.ACTION_DELETE);
        } catch (Exception ex) {
            log.error(ex);
            return ActionResponse.actionFail(ex + GlobalVariable.ACTION_DELETE);
        }
    }
}
