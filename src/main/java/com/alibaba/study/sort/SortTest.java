package com.alibaba.study.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/27 13:26
 */
public class SortTest {

    public static void main(String[] args) {
        Integer[] arr = {6, 3, 8, 2, 9, 1};
        //Arrays.sort(arr);
        Arrays.sort(arr, Collections.reverseOrder());
        //sort(arr);
        //selectionSort(arr);
        for (int i : arr) {
            //System.out.print(i + " ");
        }

        Integer[] ints2={212,43,2,324,4,4,57,1};
        //对数组的[2,6)位进行排序

        Arrays.sort(ints2,5,7);
        for (int i=0;i<ints2.length;i++)
        {
            System.out.print(ints2[i]+" ");
        }
    }

    /**
     * N个数字排序，进行 N-1趟排序
     * 每趟排序次数为 N-i-1次
     * 双重循环 外层控制趟数，内层控制每一趟排序次数
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序的第一趟处理是从数据序列所有n个数据中选择一个最小的数据作为有序序列中的第1个元素并将它定位在第一号存储位置，
     * 第二趟处理从数据序列的n-1个数据中选择一个第二小的元素作为有序序列中的第2个元素并将它定位在第二号存储位置，依此类推，
     * 当第n-1趟处理从数据序列的剩下的2个元素中选择一个较小的元素作为有序序列中的最后第2个元素并将它定位在倒数第二号存储位置，至此，整个的排序处理过程就已完成
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        int temp;
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = i + 1; j <= arr.length - 1; j++) {
                // 第i个和第j个比较，j可以取到最后以为
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
