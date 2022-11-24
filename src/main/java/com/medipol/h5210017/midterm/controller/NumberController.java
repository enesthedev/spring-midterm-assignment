package com.medipol.h5210017.midterm.controller;

import com.medipol.h5210017.midterm.model.RandomArrays;
import com.medipol.h5210017.midterm.service.NumberService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("number")
public class NumberController {

    private final NumberService numberService = new NumberService();

    @GetMapping("reverse")
    public Integer reverse(@RequestParam("number") int number) {
        return numberService.reverse(number);
    }

    @GetMapping("array/random")
    public RandomArrays random(@RequestParam("number") int number) {
        int[] randomArray = new int[number];

        int oddCount = 0, evenCount = 0;

        for (int i = 0; i < number; i++) {
            int a = numberService.getRandomNumber(1, 9);
            randomArray[i] = a;
        }

        for (int randomNumber : randomArray) {
            if (randomNumber % 2 == 0) {
                oddCount++;
            } else {
                evenCount++;
            }
        }

        /**
         * At the top, I create the string with the desired properties with my own random number finding algorithm.
         * I also calculate the amount of even and odd numbers.
         */

        int[] oddArray = new int[oddCount];
        int[] evenArray = new int[evenCount];

        oddCount = 0; evenCount = 0;

        // Generating strings containing even and odd numbers
        for (int randomNumber : randomArray) {
            if (randomNumber % 2 == 0) {
                oddArray[oddCount] = randomNumber;
                oddCount++;
            } else {
                evenArray[evenCount] = randomNumber;
                evenCount++;
            }
        }

        return new RandomArrays(randomArray, oddArray, evenArray);
    }
}
