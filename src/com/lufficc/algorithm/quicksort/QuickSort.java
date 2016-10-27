package com.lufficc.algorithm.quicksort;

/**
 * Created by lufficc on 2016/10/23.
 */
public class QuickSort {
    /**
     * @see http://blog.csdn.net/morewindows/article/details/6684558
     */
    private static int partion(int[] array, int l, int r) {
        int i = l, j = r;
        int x = array[i];

        while (i < j) {
            // 从右向左搜索
            while (i < j && array[j] >= x) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            // 从左向右搜索
            while (i < j && array[i] < x) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = x;
        return i;
    }

    private static void quick_sort(int[] array, int l, int r) {
        if (l < r) {
            int middle = partion(array, l, r);
            quick_sort(array, l, middle);
            quick_sort(array, middle + 1, r);
        }
    }

    public static void sort(int[] array) {
        quick_sort(array, 0, array.length - 1);
    }
}
