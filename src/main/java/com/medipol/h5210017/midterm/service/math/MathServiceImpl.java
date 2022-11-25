package com.medipol.h5210017.midterm.service.math;

import com.medipol.h5210017.midterm.repository.FactorialRepository;
import com.medipol.h5210017.midterm.service.math.file.MathFileService;
import com.medipol.h5210017.midterm.util.MathUtil;
import com.medipol.h5210017.midterm.util.StringUtil;
import com.medipol.h5210017.midterm.util.constant.MathServiceConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MathServiceImpl implements MathService {

    @Autowired
    private MathFileService mathFileServiceImpl;

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

    @Override
    public String factorial(int number) {
        String status = MathServiceConstant.FILE_SUCCESS;

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
            File factorialFile = mathFileServiceImpl.create("src/main/resources/static/faktoriyel.txt", factorialString);
            return "%s - %s".formatted(status, factorialFile.getAbsolutePath());

        } catch (IOException e) {
            status = MathServiceConstant.FILE_ERROR;
        }

        return "%s - %s".formatted(status, "");
    }
}
