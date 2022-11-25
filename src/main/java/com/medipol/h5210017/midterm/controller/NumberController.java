package com.medipol.h5210017.midterm.controller;

import com.medipol.h5210017.midterm.model.response.BaseResponse;
import com.medipol.h5210017.midterm.service.number.NumberService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("number")
public class NumberController {

    @Autowired
    private NumberService numberServiceImpl;

    @GetMapping("reverse")
    public BaseResponse reverse(@RequestParam("number") long number) {
        String message = "%d sayısından %s sayısı oluşur."
                .formatted(number, numberServiceImpl.reverse(number));

        return new BaseResponse(message, 200);
    }
}
