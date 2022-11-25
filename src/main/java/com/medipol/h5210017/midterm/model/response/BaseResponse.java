package com.medipol.h5210017.midterm.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class BaseResponse {
    String message;
    int code;
}
