package com.lufficc.algorithm.quicksort;

import com.lufficc.algorithm.utils.Print;
import com.lufficc.algorithm.utils.RandomUtil;

public class Main {
    public static void main(String[] args) {
        int[] a = RandomUtil.randomArray(10);
        Print.printArray(a);
        QuickSort.sort(a);
        Print.printArray(a);
    }
}
