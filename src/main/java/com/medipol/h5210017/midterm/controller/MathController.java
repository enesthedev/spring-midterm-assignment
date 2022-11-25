package com.medipol.h5210017.midterm.controller;

import com.medipol.h5210017.midterm.model.RandomArrayResponse;
import com.medipol.h5210017.midterm.service.math.MathService;
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
        return mathServiceImpl.random(number);
    }
}
