package com.medipol.h5210017.midterm.controller;

import com.medipol.h5210017.midterm.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("string")
public class StringController {

    private final StringService stringService = new StringService();

    @GetMapping("/split")
    public List<String> split(@RequestParam("text") String text, @RequestParam(required = false) Optional<Character> separator) {
        return stringService.split(text, separator.orElseGet(() -> ' '));
    }
}
