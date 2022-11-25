package com.medipol.h5210017.midterm.controller;

import com.medipol.h5210017.midterm.model.response.BaseResponse;
import com.medipol.h5210017.midterm.model.response.SplitResponse;
import com.medipol.h5210017.midterm.service.string.StringService;
import com.medipol.h5210017.midterm.util.Constants;
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
    private StringService stringService;

    @GetMapping("/split")
    public SplitResponse split(@RequestParam("text") String text, @RequestParam(required = false) Optional<Character> separator) {
        return new SplitResponse(stringService.split(text, separator.orElseGet(() -> ' ')), Constants.SUCCESS_MESSAGE, Constants.SUCCESS_CODE);
    }

    @GetMapping("/longest")
    public BaseResponse longest(@RequestParam("text") String text) {
        List<String> wordList = stringService.split(text, ' ');
        String longest = stringService.longest(wordList);

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
