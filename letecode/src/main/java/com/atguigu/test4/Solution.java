package com.atguigu.test4;

import java.util.Arrays;

//回溯算法
class Solution {
    public boolean reorderedPowerOf23(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);


        for (int i = 0; i < 31; i++) {
            char[] chars1 = String.valueOf(1 << i).toCharArray();
            Arrays.sort(chars1);
            if (Arrays.equals(chars, chars1))
                return true;
        }
        return false;
    }



















    public boolean reorderedPowerOf2(int n) {
        //先把数字转化为字符
        char[] numChar = String.valueOf(n).toCharArray();
        //对字符进行排序
        Arrays.sort(numChar);
        for (int i = 0; i < 31; i++) {
            //把2的幂转化为字符，然后排序
            char[] bitChar = String.valueOf(1 << i).toCharArray();
            Arrays.sort(bitChar);
            //比较这两个数组
            if (Arrays.equals(numChar, bitChar))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.reorderedPowerOf2(231);
    }

    //回溯算法的模板
/*    private void backtrack("原始参数") {
        //终止条件(递归必须要有终止条件)
        if ("终止条件") {
        //一些逻辑操作（可有可无，视情况而定）
            return;
        }
        for (int i = "for循环开始的参数"; i < "for循环结束的参数"; i++) {
            //一些逻辑操作（可有可无，视情况而定）
            //做出选择
            //递归
            backtrack("新的参数");
            //一些逻辑操作（可有可无，视情况而定）
            //撤销选择
        }
    }*/




}