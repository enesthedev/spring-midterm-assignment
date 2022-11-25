package com.medipol.h5210017.midterm.service.string;

import java.util.List;

public interface StringService {
    List<String> split(String text, char separator);

    String longest(List<String> wordList);

    String reverse(int number);
}
