package com.medipol.h5210017.midterm.service;

import com.medipol.h5210017.midterm.model.FactorialNumber;

import java.util.ArrayList;

public interface INumberService {
    int reverse(Integer number);

    int getRandomNumber(int start, int stop);
}
