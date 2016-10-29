package com.lufficc.algorithm.utils;

import java.util.Arrays;

/**
 * Created by lufficc on 2016/10/23.
 */
public class Printer {
    public static void print(Object o) {
        System.out.println(o);
    }

    public static void printArray(int[] arr) {
        print(Arrays.toString(arr));
    }
}
