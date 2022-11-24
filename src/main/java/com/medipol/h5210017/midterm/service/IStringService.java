package com.medipol.h5210017.midterm.service;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;

public interface IStringService {
    List<String> split(String text, char separator);

    String findLongestWord(List<String> wordList);
}
