package com.medipol.h5210017.midterm.service.number;

import com.medipol.h5210017.midterm.util.StringUtil;
import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl implements NumberService {

    @Override
    public String reverse(long number) {
        String numberStr = String.valueOf(number);
        return StringUtil.reverse(numberStr);
    }
}
