package com.zhouhao.study.maven;

import java.util.Arrays;

public class Calculator {

    public int sum(int... a) {
        if (a == null) {
            return 0;
        }

        return Arrays.stream(a).sum();
    }

}
