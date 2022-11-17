package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: Test.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 *
 * @author yinzo 2020/12/8
 */
public class Test {


    public static void main(String[] args) {


        test2();
    }

    public static void test() {


        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();


        result.add(new ArrayList<Integer>());


        for (int i = 0; i < list.size(); i++) {

            int size = result.size();

            for (int j = 0; j < size; j++) {

                List<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(list.get(i));
                result.add(tmp);
            }

        }
        System.out.println(result);
    }

    public static void test2() {

        int[] arr = {1, 2, 2};


        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<Integer>());

        int start = 0;
        for (int i = 0; i < arr.length; i++) {


            int size = result.size();


            if (i >= 1 && arr[i] != arr[i - 1]) {
                start = 0;
            }

            for (int j = start; j < size; j++) {

                List<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(arr[i]);
                result.add(tmp);
            }

            start = size;

        }

        System.out.println(result);
    }



}
