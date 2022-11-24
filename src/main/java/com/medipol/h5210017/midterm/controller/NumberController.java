package com.medipol.h5210017.midterm.controller;

import com.medipol.h5210017.midterm.model.RandomArrays;
import com.medipol.h5210017.midterm.service.NumberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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

        ArrayList<Integer> oddArray = new ArrayList<Integer>();
        ArrayList<Integer> evenArray = new ArrayList<Integer>();

        for (int i = 0; i < number; i++) {
            int a = numberService.getRandomNumber(1, 9);
            randomArray[i] = a;
        }

        for (int randomNumber : randomArray) {
            if (randomNumber % 2 == 0) {
                evenArray.add(randomNumber);
            } else {
                oddArray.add(randomNumber);
            }
        }
        return new RandomArrays(randomArray, oddArray, evenArray);
    }
}
