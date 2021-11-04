package com.achooapi.achoo_api_java.controller;

import com.achooapi.achoo_api_java.model.dto.ApiDto;
import com.achooapi.achoo_api_java.model.dto.CollectionDto;
import com.achooapi.achoo_api_java.service.ApiService;
import com.achooapi.achoo_api_java.service.CollectionService;
import com.achooapi.achoo_api_java.ultis.ActionResponse;
import com.achooapi.achoo_api_java.ultis.GlobalVariable;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(GlobalVariable.URI_API + "/collection")
public class CollectionController {
    final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @PostMapping(value = "")
    @ResponseBody
    public Object save(@RequestBody(required = false) CollectionDto item) {
        try {
            Object object = collectionService.save(item);
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
            return ActionResponse.actionSuccess(collectionService.findAll(), GlobalVariable.ACTION_FIND);
        } catch (Exception ex) {
            log.error(ex);
            return ActionResponse.actionFail(ex + GlobalVariable.ACTION_FIND);
        }
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestBody(required = false) CollectionDto item) {
        try {
            Object object = collectionService.delete(item.getId());
            return ActionResponse.actionSuccess(object, GlobalVariable.ACTION_DELETE);
        } catch (Exception ex) {
            log.error(ex);
            return ActionResponse.actionFail(ex + GlobalVariable.ACTION_DELETE);
        }
    }
}
