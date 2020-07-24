package com.alibaba.study.compara;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @date 2020/7/24 14:44
 */
public class NumberTest {
    public static int factorial (int n) {

        if (n == 1) {
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }

    public static int factor (int n) {

        int product = 1;

        for(int i=2; i<=n; i++) {

            product *= i;

        }

        return product;

    }

    public static void main(String[] args) {
        int t = factorial(5);
        int z = factor(5);
        System.out.println(z);
    }
}
