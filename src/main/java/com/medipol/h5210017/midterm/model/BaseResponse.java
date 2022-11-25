package com.medipol.h5210017.midterm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class BaseResponse {
    @Getter String message;
    @Getter int code;
}
