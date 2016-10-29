package com.lufficc.algorithm.DynamicProgramming.SteelCutting;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lufficc on 2016/10/25.
 */
public class SteelCutting {

    public static void main(String[] args) {
        int[] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 36, 41, 50, 55, 62};
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            System.out.println(new SteelCutting().cutRoa(p, 7));
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    public Map<Integer, Integer> map = new HashMap<>();

    public int cutRoa(int[] p, int n) {
        /*if (map.containsKey(n))
            return map.get(n);*/
        if (n == 0)
            return 0;
        int q = -99999999;
        for (int i = 1; i <= n; i++) {
            q = Math.max(q, p[i] + cutRoa(p, n - i));
        }
        /*map.put(n, q);*/
        return q;
    }
}
