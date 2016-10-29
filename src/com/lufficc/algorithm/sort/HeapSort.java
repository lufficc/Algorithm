package com.lufficc.algorithm.sort;

import com.lufficc.algorithm.utils.Printer;
import com.lufficc.algorithm.utils.RandomUtils;

/**
 * Created by lufficc on 2016/10/28.
 */
public class HeapSort {
    public static void main(String[] args) {
        int a[] = RandomUtils.randomArray(12);
        Printer.printArray(a);
        new HeapSort().heapSort(a);
        Printer.printArray(a);
    }

    public void heapSort(int[] a) {
        buildMaxHeap(a);
        int length = a.length;
        for (int i = a.length - 1; i >= 1; i--) {
            swap(a, i, 0);
            length--;
            maxHeapify(a, 0, i);
        }

    }

    private void buildMaxHeap(int a[]) {
        for (int i = a.length / 2 + 1; i >= 0; i--) {
            maxHeapify(a, i);
        }
    }

    /**
     * 维持最大堆
     * @param a 数组
     * @param i 下标
     * @param length 数组长度
     */
    private void maxHeapify(int[] a, int i, int length) {
        int l = left(i);
        int r = right(i);
        int max;
        if (l < length && a[l] > a[i]) {
            max = l;
        } else {
            max = i;
        }
        if (r < length && a[r] > a[max]) {
            max = r;
        }
        if (max != i) {
            swap(a, i, max);
            maxHeapify(a, max, length);
        }
    }

    private void maxHeapify(int[] a, int i) {
        maxHeapify(a, i, a.length);
    }

    private int left(int i) {
        return i * 2 + 1;
    }

    private int right(int i) {
        return i * 2 + 2;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
