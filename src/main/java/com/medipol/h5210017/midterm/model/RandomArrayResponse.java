package com.medipol.h5210017.midterm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RandomArrayResponse extends BaseResponse {
    @Getter int[] randomNumbers;
    @Getter int[] oddNumbers;
    @Getter int[] evenNumbers;
}
