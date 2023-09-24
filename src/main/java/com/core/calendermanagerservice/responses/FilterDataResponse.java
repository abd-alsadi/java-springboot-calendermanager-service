package com.core.calendermanagerservice.responses;

import com.core.calendermanagerservice.constants.ModConstant;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class FilterDataResponse {
    private String message;
    private Object data;
    private int count;
    private  ModConstant.StatusCode statusCode;
}
