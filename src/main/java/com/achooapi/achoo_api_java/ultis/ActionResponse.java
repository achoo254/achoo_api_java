package com.achooapi.achoo_api_java.ultis;

import com.achooapi.achoo_api_java.model.dto.ApiResponseDto;

import javax.validation.constraints.NotNull;

public final class ActionResponse {
    //Contructor
    private ActionResponse() {
        //Not called
    }

    @NotNull
    public static ApiResponseDto actionSuccess(Object T, String method) {
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setMessage(method + GlobalVariable.ACTION_SUCCESS);
        apiResponseDto.setStatus(GlobalVariable.STRING_SUCCESS);
        apiResponseDto.setDetails(T);
        return apiResponseDto;
    }

    @NotNull
    public static ApiResponseDto actionFail(String method) {
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setMessage(method + GlobalVariable.ACTION_FAILED);
        apiResponseDto.setStatus(GlobalVariable.STRING_ERROR);
        return apiResponseDto;
    }
}
