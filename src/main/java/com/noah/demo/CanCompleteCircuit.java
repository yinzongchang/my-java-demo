package com.noah.demo;

/**
 * Title: CanCompleteCircuit.java <br>
 * Description: 加油站出发点 <br>
 * Copyright: Copyright (c) 2015<br>
 *
 * @author yinzo 2020/11/22
 */
public class CanCompleteCircuit {


    public static void main(String[] args) {

        int[] gas = {1, 2, 3, 4, 5};

        int[] cost = {3, 4, 5, 1, 2};

        System.out.println(canCompleteCircuit1(gas, cost));
        System.out.println(canCompleteCircuit2(gas, cost));
        System.out.println(canCompleteCircuit3(gas, cost));
    }


    /**
     * 全部遍历了一遍
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit1(int[] gas, int[] cost) {

        int length = gas.length;
        for (int i = 0; i < length; i++) {

            int sumGas = 0;
            int sumCost = 0;

            int cursor = 0;

            while (cursor < length) {

                int index = (i + cursor) % length;

                sumGas += gas[index];
                sumCost += cost[index];

                if (sumCost > sumGas) {
                    break;
                }

                cursor++;
            }

            if (cursor == length) {
                return i;
            } else {
//                i = i + cursor + 1;
            }
        }

        return -1;
    }


    public static int canCompleteCircuit2(int[] gas, int[] cost) {

        int length = gas.length;

        int i = 0;
        while (i < length) {

            int sumGas = 0;
            int sumCost = 0;

            int cursor = 0;
            while (cursor < length) {

                int index = (i + cursor) % length;
                sumGas += gas[index];
                sumCost += cost[index];

                if (sumCost > sumGas) {
                    break;
                }

                cursor++;
            }

            if (cursor == length) {
                return i;
            } else {

                // 此次遍历不能完成一圈，从第一个无法到达的加油站的后一个开始继续检查。
                i = i + cursor + 1;
            }
        }

        return -1;
    }

    public static int canCompleteCircuit3(int[] gas, int[] cost) {

        int length = gas.length;

        int spare = 0;

        int min = Integer.MAX_VALUE;
        int minIndex = 0;


        for (int i = 0; i < length; i++) {

            spare += (gas[i] - cost[i]);

            if (spare < min) {

                min = spare;
                minIndex = i;
            }
        }

        if (spare >= 0) {

            return (minIndex + 1) % length;
        } else {
            return -1;
        }
    }


}
