package com.medipol.h5210017.midterm.model.response;

import lombok.Getter;

import java.util.List;

@Getter
public class SplitResponse extends BaseResponse {
    public List<String> stringList;

    public SplitResponse(List<String> stringList, String message, int code) {
        super(message, code);
        this.stringList = stringList;
    }
}
