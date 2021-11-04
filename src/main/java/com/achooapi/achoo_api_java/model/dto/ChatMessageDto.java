package com.achooapi.achoo_api_java.model.dto;

import com.achooapi.achoo_api_java.ultis.GlobalVariable;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageDto {
    String usersId;
    String message;
    @JsonFormat(pattern = GlobalVariable.FORMAT_DATE_TIME_DASH, timezone = "Asia/Ho_Chi_Minh")
    private Date createdAt;
}
