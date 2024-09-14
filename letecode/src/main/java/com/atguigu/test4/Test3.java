package com.atguigu.test4;

public class Test3 {
    class Solution {
        // 三指针
        public void sortColors(int[] nums) {
            //0的右边界
            int left = 0;
            //2的左边界
            int right = nums.length - 1;
            //指向当前数字
            int index = 0;
            while (index <= right) {
                if (nums[index] == 0) {
                    //如果是0，就往前面移
                    swap(nums, left++, index++);
                } else if (nums[index] == 1) {
                    index++;
                } else if (nums[index] == 2) {
                    //如果是2就往后面移
                    swap(nums, right--, index);
                }
            }
        }

        // 交换数组中的两个数字
        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
