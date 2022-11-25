package com.medipol.h5210017.midterm.controller;

import com.medipol.h5210017.midterm.model.BaseResponse;
import com.medipol.h5210017.midterm.model.RandomArrayResponse;
import com.medipol.h5210017.midterm.service.math.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("math")
public class MathController {

    @Autowired
    private MathService mathServiceImpl;

    @GetMapping("array/create/random")
    public RandomArrayResponse random(@RequestParam("number") int number) {
        ArrayList<int[]> numbers = mathServiceImpl.random(number);

        /*  Unfortunately, I couldn't find a way to move integer size values with less resources,
            I'm waiting for your suggestions. You can also help the code by sending a Pull Request. */

        int[] randomNumbers = numbers.get(0);
        int[] oddNumbers = numbers.get(1);
        int[] evenNumbers = numbers.get(2);

        return new RandomArrayResponse(randomNumbers, oddNumbers, evenNumbers);
    }
}
