package com.medipol.h5210017.midterm.service.math;

import com.medipol.h5210017.midterm.util.MathUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MathServiceImpl implements MathService {
    @Override
    public ArrayList<int[]> random(int number) {
        int[] randomNumbers = new int[number];
        int oddNumberCount = 0, evenNumberCount = 0;

        for (int i = 0; i < number; i++) {
            int randomNumber = MathUtil.random(1, 9);
            randomNumbers[i] = randomNumber;
            if (MathUtil.isOdd(randomNumber)) {
                oddNumberCount++;
            } else {
                evenNumberCount++;
            }
        }

        int[] oddNumbers = new int[oddNumberCount];
        int[] evenNumbers = new int[evenNumberCount];
        int oddIndex = 0, evenIndex = 0;

        for (int randomNumber: randomNumbers) {
            if (MathUtil.isOdd(randomNumber)) {
                oddNumbers[oddIndex] = randomNumber;
                oddIndex++;
            } else {
                evenNumbers[evenIndex] = randomNumber;
                evenIndex++;
            }
        }

        return new ArrayList<int[]>(Arrays.asList(randomNumbers, oddNumbers, evenNumbers));
    }
}
