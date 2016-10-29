package com.lufficc.algorithm.sort;

import com.lufficc.algorithm.utils.Printer;
import com.lufficc.algorithm.utils.RandomUtils;

import java.util.Arrays;

/**
 * Created by lufficc on 2016/10/23.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = RandomUtils.randomArray(10);
        Printer.printArray(a);
        new QuickSort().sort(a);
        Printer.printArray(a);
    }

    private int partion2(int[] a, int l, int r) {
        int pivot = a[r];
        int p = l - 1;
        for (int i = 0; i < r; i++) {
            if (a[i] <= pivot) {
                p++;
                swap(a, p, i);
            }
        }
        swap(a, r, p + 1);
        return p + 1;
    }

    /**
     * @see http://blog.csdn.net/morewindows/article/details/6684558
     */
    private int partion1(int[] a, int l, int r) {
        int i = l, j = r;
        int x = a[i];

        while (i < j) {
            // 从右向左搜索
            while (i < j && a[j] >= x) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }
            // 从左向右搜索
            while (i < j && a[i] < x) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        a[i] = x;
        return i;
    }

    private void quickSort(int[] array, int l, int r) {
        if (l < r) {
            int middle = partion1(array, l, r);
            quickSort(array, l, middle);
            quickSort(array, middle + 1, r);
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
}
