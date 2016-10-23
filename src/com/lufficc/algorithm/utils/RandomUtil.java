package com.lufficc.algorithm.utils;

import java.util.Random;

/**
 * Created by lufficc on 2016/10/23.
 */
public class RandomUtil {
    private static final Random random = new Random(System.currentTimeMillis());

    public static int[] randomArray(int length) {
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = random.nextInt(1000);
        }
        return a;
    }
}
