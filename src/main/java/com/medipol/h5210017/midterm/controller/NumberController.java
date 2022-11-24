package com.medipol.h5210017.midterm.controller;

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
}
