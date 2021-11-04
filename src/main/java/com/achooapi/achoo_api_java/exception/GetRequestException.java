package com.achooapi.achoo_api_java.exception;

import com.achooapi.achoo_api_java.model.dto.ApiResponseDto;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/error")
public class GetRequestException extends AbstractErrorController {
    public GetRequestException(final ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @GetMapping
    public Object error(final HttpServletRequest request) {
        ApiResponseDto error = new ApiResponseDto();
        error.setMessage(HttpStatus.BAD_REQUEST.toString());
        final Map<String, Object> body = this.getErrorAttributes(request, ErrorAttributeOptions.defaults());
        error.setDetails(body.entrySet().stream().filter(x -> x.getKey().equals("error")).map(x -> x.getValue().toString()).findFirst().orElse(null));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
