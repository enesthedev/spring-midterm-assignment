package com.medipol.h5210017.midterm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@AllArgsConstructor
public class RandomArrays {
    @Getter int[] randomArray;
    @Getter ArrayList<Integer> oddArray;
    @Getter ArrayList<Integer> evenArray;
}
