package com.medipol.h5210017.midterm.model.response;

import com.medipol.h5210017.midterm.model.RandomArray;
import lombok.Getter;

@Getter
public class RandomArrayResponse extends BaseResponse {
    RandomArray randomArray;

    public RandomArrayResponse(RandomArray randomArray, String message, int code) {
        super(message, code);
        this.randomArray = randomArray;
    }
}
