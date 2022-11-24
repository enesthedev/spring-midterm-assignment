package com.medipol.h5210017.midterm.repository;

import com.medipol.h5210017.midterm.model.FactorialNumber;
import lombok.Getter;

import java.util.ArrayList;

public class FactorialRepository {
    @Getter public static ArrayList<FactorialNumber> factorialNumbers = new ArrayList<FactorialNumber>();
}
