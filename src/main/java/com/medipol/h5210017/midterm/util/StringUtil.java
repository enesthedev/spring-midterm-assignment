package com.medipol.h5210017.midterm.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringUtil {
    public static List<String> split(String text, char separator) {

        /*  I prepared my own method by learning the algorithm instead
            of the process supported by Java. I didn't want to use
            a ready-made method. */

        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != separator) {
                stringBuilder.append(text.charAt(i));
            } else {
                if (stringBuilder.length() > 0) {
                    list.add(stringBuilder.toString());

                    /*  Since the reference type data is registered to
                        the same address on the memory, creating a new reference
                        type in each new addition will prevent possible errors
                        of the system. */

                    stringBuilder = new StringBuilder();
                }
            }
        }

        if (stringBuilder.length() > 0) {
            list.add(stringBuilder.toString());
        }

        return list;
    }

    public static String findLongestWord(List<String> wordList) throws IllegalArgumentException {
        if (wordList.isEmpty()) {
            throw new IllegalArgumentException();
        }
        /*  In the previous question, we already divided the sentence into words,
            this time I am testing the static length property of the String class
            with the help of the Java Comparator with the help of stream.
            I also make sure that the incoming string is not empty. */
        return wordList.stream()
                .max(Comparator.comparingInt(String::length))
                .get();
    }

    public static String reverse(String string) { // Rearranges all incoming String values to be reversed
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = string.length() - 1; i >= 0; i--) {
            char w = string.charAt(i);
            if (w == 48 && stringBuilder.length() == 0) { // This is for number-safety responses for example before 1240 0421 after 1240 421
                continue;
            }
            stringBuilder.append(w);
        }

        return stringBuilder.toString();
    }
}
