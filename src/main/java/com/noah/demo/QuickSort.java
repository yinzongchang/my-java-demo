package com.noah.demo;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {3, 4, 6, 2, 1, 7};

//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));

        findK(arr, 0, arr.length - 1, 2);

    }

    public static void quickSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int partition = partition(arr, start, end);
        quickSort(arr, start, partition - 1);
        quickSort(arr, partition + 1, end);
    }


    public static int partition(int[] arr, int start, int end) {

        int pivot = arr[start];

        int i = start;
        int j = end;

        while (i != j) {


            while (i < j && arr[j] > pivot) {
                j--;
            }

            while (i < j && arr[i] <= pivot) {
                i++;
            }


            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[start] = arr[i];
        arr[i] = pivot;

        return i;
    }

    public static void findK(int[] arr, int left, int right, int k) {

        int partition = partition(arr, left, right);

        if (partition == k - 1) {
            System.out.println(arr[partition]);
        } else if (partition > k - 1) {

            findK(arr, left, partition - 1, k);
        } else {

            findK(arr, partition + 1, right, k - partition);
        }

    }

}
