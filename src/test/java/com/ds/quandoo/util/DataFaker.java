package com.ds.quandoo.util;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * DataFaker
 * Wrapper over Java implementation of well-known Ruby library Faker which generates all kinds of random data
 *
 * @author Dmitrii Speranskii
 */
public class DataFaker {

    public static String getNewUserName() {
        return Arrays.stream(new Faker().name().name().split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.joining(""));
    }

    public static String getNewPassword() {
        int minPassLength = 5;
        int maxPassLength = 10;
        return new Faker().internet().password(minPassLength, maxPassLength, true, true);
    }

}
