package com.medipol.h5210017.midterm.service;

public class NumberService implements INumberService {

    @Override
    public Integer reverse(Integer number) {
        /**
         * I thought the easiest way I could create a reverse
         * for loop was to convert the incoming number to a string value.
         */
        String reversableNumber = number.toString();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = reversableNumber.length() - 1; i >= 0; i--) {
            stringBuilder.append(reversableNumber.charAt(i));
        }

        return Integer.parseInt(stringBuilder.toString());
    }
}
