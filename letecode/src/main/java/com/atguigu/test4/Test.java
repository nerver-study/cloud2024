package com.atguigu.test4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        new Test().permuteUnique(new int[]{1,1,2});
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        //先对数组进行排序，这样做目的是相同的值在数组中肯定是挨着的，
        //方便过滤掉重复的结果
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //boolean数组，used[i]表示元素nums[i]是否被访问过
        boolean[] used = new boolean[nums.length];
        //执行回溯算法
        backtrack(nums, used, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int[] nums, boolean[] used, List<Integer> tempList, List<List<Integer>> res) {
        //如果数组中的所有元素都使用完了，类似于到了叶子节点，
        //我们直接把从根节点到当前叶子节点这条路径的元素加入
        //到集合res中
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        //遍历数组中的元素
        for (int i = 0; i < nums.length; i++) {
            //如果已经被使用过，则直接跳过
            if (used[i])
                continue;
            //注意，这里要剪掉重复的组合
            //如果当前元素和前一个一样，并且前一个没有被使用过，我们也跳过
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
                continue;
            //否则我们就使用当前元素，把他标记为已使用
            used[i] = true;
            //把当前元素nums[i]添加到tempList中
            tempList.add(nums[i]);
            //递归，类似于n叉树的遍历，继续往下走
            backtrack(nums, used, tempList, res);
            //递归完之后会往回走，往回走的时候要撤销选择
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
