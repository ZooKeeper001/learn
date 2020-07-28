package com.alibaba.study.compara;


import java.util.Arrays;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/27 15:02
 */
public class ArraysSortTest {

    public static void main(String[] args) {
        // initializing unsorted int array
        int[] iArr = {3, 1, 2, 18, 10};

        // let us print all the elements available in list
        for (int number : iArr) {
            System.out.println("Number = " + number);
        }

        // sorting array from index 0 to 3
        Arrays.sort(iArr, 0, 3);

        // let us print all the elements available in list
        System.out.println("int array with some sorted values(0 to 3) is:");
        for (int number : iArr) {
            System.out.println("Number = " + number);
        }
    }
}
