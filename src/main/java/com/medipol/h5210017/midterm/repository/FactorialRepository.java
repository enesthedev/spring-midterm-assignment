package com.medipol.h5210017.midterm.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
public class FactorialRepository {
    @Getter @Setter public ArrayList<Integer> factorialNumbers = new ArrayList<Integer>();
}
