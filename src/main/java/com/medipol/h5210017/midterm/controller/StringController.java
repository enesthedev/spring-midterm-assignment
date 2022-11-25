package com.medipol.h5210017.midterm.controller;

import com.medipol.h5210017.midterm.model.BaseResponse;
import com.medipol.h5210017.midterm.service.string.StringService;
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

    @Autowired
    private StringService stringServiceImpl;

    @GetMapping("/split")
    public List<String> split(@RequestParam("text") String text, @RequestParam(required = false) Optional<Character> separator) {
        return stringServiceImpl.split(text, separator.orElseGet(() -> ' '));
    }

    @GetMapping("/longest")
    public BaseResponse longest(@RequestParam("text") String text) {
        List<String> wordList = stringServiceImpl.split(text, ' ');
        String longest = stringServiceImpl.longest(wordList);

        // I used a feature that came with Java 15 instead of advancing by adding old format String values to each other.
        String message = "'%s' cümlesindeki en uzun kelime '%s' ve bu kelime %d uzunluğundadır."
                .formatted(
                        text,
                        longest,
                        longest.length()
                );

        return new BaseResponse(message, 200);
    }
}
