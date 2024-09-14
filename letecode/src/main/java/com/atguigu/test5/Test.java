package com.atguigu.test5;

public class Test {
    public static void main(String[] args) {

        String babad = new Test().longestPalindrome("babad");
//        String babad = new Test().longestPalindrome("bad");
        System.out.println(babad);
    }
    // 返回最长回文串长度
    public String longestPalindrome(String s) {
        int charLen = s.length();//源字符串的长度
        int length = charLen * 2 + 1;//添加特殊字符之后的长度
        char[] chars = s.toCharArray();//源字符串的字符数组
        char[] res = new char[length];//添加特殊字符的字符数组
        int index = 0;
        //添加特殊字符
        for (int i = 0; i < res.length; i++) {
            res[i] = (i % 2) == 0 ? '#' : chars[index++];
        }
        //新建p数组 ，p[i]表示以res[i]为中心的回文串半径
        int[] p = new int[length];
        //maxRight(某个回文串延伸到的最右边下标)
        //maxCenter(maxRight所属回文串中心下标),
        //resCenter（记录遍历过的最大回文串中心下标）
        // 录 历 的最大 文串中 下标
        //resLen（记录遍历过的最大回文半径）
        int maxRight = 0,
                maxCenter = 0,
                resCenter = 0,
                resLen = 0;
        //遍历字符数组res
        for (int i = 0; i < length; i++) {
            //合并后的代码
            p[i] = maxRight > i ?
                    Math.min(maxRight - i, p[2 * maxCenter - i]) :
                    1;
            //上面的语句只能确定i~maxRight的回文情况，至于maxRight之后的部分是否对称，
            //就只能一个个去匹配了，匹配的时候首先数组不能越界
            while (i - p[i] >= 0 &&
                    i + p[i] < length &&
                    res[i - p[i]] == res[i + p[i]]
            )
                p[i]++;


            //匹配完之后，如果右边界i + p[i]超过maxRight，那么就更新maxRight和maxCenter
            if (i + p[i] > maxRight) {
                maxRight = i + p[i];
                maxCenter = i;
            }
            //记录最长回文串的半径和中心位置
            if (p[i] > resLen) {
                resLen = p[i];
                resCenter = i;
            }
        }
        //计算最长回文串的长度和开始的位置
        resLen = resLen - 1;
        int start = (resCenter - resLen) >> 1;
        //截取最长回文子串
        return s.substring(start, start + resLen);
    }
}
