package com.medipol.h5210017.midterm.controller;

import com.medipol.h5210017.midterm.model.RandomArray;
import com.medipol.h5210017.midterm.model.response.BaseResponse;
import com.medipol.h5210017.midterm.model.response.RandomArrayResponse;
import com.medipol.h5210017.midterm.service.math.MathService;
import com.medipol.h5210017.midterm.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("math")
public class MathController {

    @Autowired
    private MathService mathServiceImpl;

    @GetMapping("array/create/random")
    public RandomArrayResponse random(@RequestParam("number") int number) {
        RandomArray arrays = mathServiceImpl.random(number);

        /*  Unfortunately, I couldn't find a way to move integer size values with less resources,
            I'm waiting for your suggestions. You can also help the code by sending a Pull Request. */

        return new RandomArrayResponse(arrays, Constants.SUCCESS_MESSAGE, Constants.SUCCESS_CODE);
    }

    @GetMapping("factorial")
    public BaseResponse factorial(@RequestParam("number") int number) {
        return new BaseResponse(mathServiceImpl.factorial(number), 200);
    }

    @GetMapping("cone")
    public BaseResponse cone(@RequestParam("r") int r, @RequestParam("h") int h) {
        return new BaseResponse(mathServiceImpl.cone(r, h), 200);
    }
}
