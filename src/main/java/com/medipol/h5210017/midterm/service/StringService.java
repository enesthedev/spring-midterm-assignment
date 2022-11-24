package com.medipol.h5210017.midterm.service;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

@Service
public class StringService implements IStringService {
    @Override
    public List<String> split(String text, char separator) {
        /**
         * I prepared my own method by learning the algorithm instead
         * of the process supported by Java. I didn't want to use
         * a ready-made method.
         */

        List<String> list = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != separator) {
                stringBuilder.append(text.charAt(i));
            } else {
                if (stringBuilder.length() > 0) {
                    list.add(stringBuilder.toString());

                    /**
                     * Since the reference type data is registered to
                     * the same address on the memory, creating a new reference
                     * type in each new addition will prevent possible errors
                     * of the system.
                     */
                    stringBuilder = new StringBuilder();
                }
            }
        }

        if (stringBuilder.length() > 0) {
            list.add(stringBuilder.toString());
        }

        return list;
    }
}
