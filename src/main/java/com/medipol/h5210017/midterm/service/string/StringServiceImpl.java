package com.medipol.h5210017.midterm.service.string;

import com.medipol.h5210017.midterm.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StringServiceImpl implements StringService {

    /*  In accordance with the logic layer, the functions in the String Service have been moved under the name StringUtil,
        since they are actually dynamic functions that can be used in more than one place. */

    @Override
    public List<String> split(String text, char separator) {
        return StringUtil.split(text, separator);
    }

    @Override
    public String findLongestWord(List<String> wordList) throws IllegalArgumentException {
        return StringUtil.findLongestWord(wordList);
    }
}
