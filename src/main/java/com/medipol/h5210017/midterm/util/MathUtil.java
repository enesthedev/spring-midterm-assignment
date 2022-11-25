package com.medipol.h5210017.midterm.util;

import com.medipol.h5210017.midterm.repository.FactorialRepository;

import java.util.Random;
import java.util.stream.IntStream;

public class MathUtil {
    public static int random(int start, int stop) {
        /*  With the help of the streamer, I create a virtual loop
            and randomly draw lots in the number ranges given here,
            set the limit as the number of stops,
            and finally return the array. */
        int[] randomNumbers = IntStream.iterate(start, n -> n + 1).limit(stop).toArray();
        return randomNumbers[new Random().nextInt(stop)];
    }

    public static int factorial(int number, FactorialRepository factorialRepository) {
        int result;
        if (number == 0) {
            result = 1;
        } else {
            result = (number * factorial(number - 1, factorialRepository));
        }

        if (factorialRepository != null) {
            factorialRepository.factorialNumbers.add(result);
        }

        return result;
    }

    public static boolean isOdd(int number) {
        return !(number % 2 == 0);
    }

    public static double findConeVolume(int r, int h) {
        return (Math.PI *  (Math.pow(r, 2)) * h) / 3 ;
    }
}
