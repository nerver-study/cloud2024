package com.atguigu.test01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution3 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        ArrayList<Integer> ints = new ArrayList<>();
        int kk=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i]+nums[j]+nums[k]==0){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        if(ints.size()<3){
                            ints.add(temp.get(0));
                            ints.add(temp.get(1));
                            ints.add(temp.get(2));
                            lists.add(temp);
                            continue;
                        }
                        for (int m = 0; m < ints.size(); m+=3) {
                            if(
                                    temp.get(0)==ints.get(m)&&
                                    temp.get(1)==ints.get(m+1)&&
                                    temp.get(2)==ints.get(m+2)
                            ){
                                break;
                            }else if(m==ints.size()-3){
                                ints.add(temp.get(0));
                                ints.add(temp.get(1));
                                ints.add(temp.get(2));
                                lists.add(temp);
                            }
                        }


                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{3,0,-2,-1,1,2});
        System.out.println(lists);
    }
}