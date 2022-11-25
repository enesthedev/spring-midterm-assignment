package com.medipol.h5210017.midterm.service.math;

import com.medipol.h5210017.midterm.model.RandomArray;

public interface MathService {
    RandomArray random(int number);
    String factorial(int number);

    String cone(int r, int h);
}
