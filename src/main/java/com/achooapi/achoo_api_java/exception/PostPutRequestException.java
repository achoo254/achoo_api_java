package com.achooapi.achoo_api_java.exception;

import com.achooapi.achoo_api_java.model.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.achooapi.achoo_api_java.ultis.GlobalVariable;

@ControllerAdvice
public class PostPutRequestException extends RuntimeException {
    ApiResponseDto apiResponseDto = new ApiResponseDto();

    //Exception request medthod not support
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Object handleError405(Exception e) {
        apiResponseDto.setStatus(HttpStatus.METHOD_NOT_ALLOWED.toString());
        apiResponseDto.setMessage(e.getLocalizedMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.METHOD_NOT_ALLOWED);
    }

    public Object commonException(String message) {
        apiResponseDto.setMessage(message);
        apiResponseDto.setStatus(GlobalVariable.STRING_ERROR);
        return apiResponseDto;
    }
}
