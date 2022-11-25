package com.medipol.h5210017.midterm.service.math;

import com.medipol.h5210017.midterm.model.RandomArray;
import com.medipol.h5210017.midterm.repository.FactorialRepository;
import com.medipol.h5210017.midterm.util.Constants;
import com.medipol.h5210017.midterm.util.FileUtil;
import com.medipol.h5210017.midterm.util.MathUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

@Service
public class MathServiceImpl implements MathService {

    @Override
    public RandomArray random(int number) {
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

        return new RandomArray(randomNumbers, oddNumbers, evenNumbers);
    }

    @Override
    public String factorial(int number) {
        String status = Constants.SUCCESS_MESSAGE;

        StringBuilder stringBuilder = new StringBuilder();
        FactorialRepository factorialRepository = new FactorialRepository();

        MathUtil.factorial(number, factorialRepository);

        ArrayList<Integer> factorialNumbers = factorialRepository.getFactorialNumbers();

        for (Integer result: factorialNumbers) {
            stringBuilder.append(result)
                    .append("\n");
        }

        String factorialString = stringBuilder.toString();

        try {
            File factorialFile = FileUtil.create("src/main/resources/static/faktoriyel.txt");
            FileUtil.write(factorialFile, factorialString);

            return "%s - %s".formatted(status, factorialFile.getAbsolutePath());

        } catch (IOException e) {
            status = Constants.ERROR_MESSAGE;
        }

        return "%s - %s".formatted(status, "");
    }

    @Override
    public String cone(int r, int h) {
        double coneVolume = MathUtil.findConeVolume(r, h);

        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);

        return decimalFormat.format(coneVolume);
    }
}
