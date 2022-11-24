package com.medipol.h5210017.midterm.service;

import com.medipol.h5210017.midterm.model.FactorialNumber;
import com.medipol.h5210017.midterm.repository.FactorialRepository;

import java.util.Random;
import java.util.stream.IntStream;

public class NumberService implements INumberService {

    @Override
    public int reverse(Integer number) {
        /**
         * I thought the easiest way I could create a reverse
         * for loop was to convert the incoming number to a string value.
         */
        String reversableNumber = number.toString();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = reversableNumber.length() - 1; i >= 0; i--) {
            stringBuilder.append(reversableNumber.charAt(i));
        }

        return Integer.parseInt(stringBuilder.toString());
    }

    @Override
    public int getRandomNumber(int start, int stop) {
        /**
         * With the help of the streamer, I create a virtual loop
         * and randomly draw lots in the number ranges given here,
         * set the limit as the number of stops,
         * and finally return the array.
         */
        int[] randomNumbers = IntStream.iterate(start, n -> n + 1).limit(stop).toArray();
        return randomNumbers[new Random().nextInt(stop)];
    }

    @Override
    public int factorial(Integer number) {
        int result;
        if (number == 0) {
            result = 1;
        } else {
            result = (number * factorial(number - 1));
        }

        FactorialRepository.factorialNumbers
                .add(new FactorialNumber(
                                number.toString() + "!",
                                result
                        )
                );

        return result;
    }
}
