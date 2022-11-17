package com.noah.demo;

public class Mysqrt {


    public int mySqrt(int x) {

//        int left = 0;
//        int right = x;
//
//        int result = 0;
//
//        while (left <= right) {
//
//            int temp = (left + right) / 2;
//            if (temp * temp > x) {
//                right = temp - 1;
//            } else {
//                left = temp + 1;
//            }
//            result = temp;
//        }
//
//        return result;


        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(new Mysqrt().mySqrt(8));


        System.out.println(new Mysqrt().mySqrt2(8));

    }


    public int mySqrt2(int x) {

        int left = 0;
        int right = x;

        int result = 0;

        while (left <= right) {


            int mid = (left + right) / 2;

            if (mid * mid > x) {
                right = mid - 1;
            } else if (mid * mid < x) {
                left = left + 1;
                result = mid;
            } else {
                return mid;
            }


        }

        return result;
    }


}
