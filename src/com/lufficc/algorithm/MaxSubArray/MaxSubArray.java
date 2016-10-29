package com.lufficc.algorithm.MaxSubArray;

import com.lufficc.algorithm.utils.Printer;

/**
 * Created by lufficc on 2016/10/27.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        Printer.printArray(new MaxSubArray().solve(new int[]{10, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7}));
        Printer.printArray(new MaxSubArray().solve(new int[]{-2, -2, -2}));
    }

    public int[] solve(int[] a) {
        return findMaxSubArray(a, 0, a.length - 1);
    }

    public int[] findMaxSubArray(int[] a, int l, int r) {
        int[] result = new int[3];
        if (l == r) {
            result[0] = result[1] = l;
            result[2] = a[l];
            return result;
        }
        int mid = (l + r) / 2;

        int[] leftResult = findMaxSubArray(a, l, mid);

        int[] rightResult = findMaxSubArray(a, mid + 1, r);

        int[] middleResult = findMaxCrossingSubArray(a, l, mid, r);

        if (leftResult[2] > rightResult[2] && leftResult[2] > middleResult[2])
            return leftResult;
        else if (rightResult[2] > leftResult[2] && rightResult[2] > middleResult[2])
            return rightResult;
        return middleResult;
    }

    public int[] findMaxCrossingSubArray(int[] a, int l, int m, int r) {
        int[] result = new int[3];
        int sum = 0, leftMaxSum = Integer.MIN_VALUE, leftMaxIndex = -1;
        for (int i = m; i >= 0; i--) {
            sum += a[i];
            if (sum > leftMaxSum) {
                leftMaxSum = sum;
                leftMaxIndex = i;
            }
        }
        sum = 0;
        int rightMaxSum = Integer.MIN_VALUE, rightMaxIndex = -1;
        for (int j = m + 1; j <= r; j++) {
            sum += a[j];
            if (sum > rightMaxSum) {
                rightMaxSum = sum;
                rightMaxIndex = j;
            }
        }
        result[0] = leftMaxIndex;
        result[1] = rightMaxIndex;
        result[2] = leftMaxSum + rightMaxSum;
        return result;
    }
}
