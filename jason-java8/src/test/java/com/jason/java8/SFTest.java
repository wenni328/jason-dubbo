package com.jason.java8;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: xieyong
 * @date: 2018/9/18 15:12
 * @Description:
 */
public class SFTest {
    public static void main(String[] args) {

        int[] a ={1,34,54,23,23,1,21,54};
        int length=removeDuplicates(a);
        for (int i = 0; i <length ; i++) {
            System.out.println(a[i]);
        }
    }
    public static int removeDuplicates(int[] nums) {
        /**
         * 先说说我的思路吧，我想的是标注法,之后进行判断
         */
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        /** 我先弄到Set里面，将长度搞出来 */
        Set<Integer> sets = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            sets.add(nums[i]);
        }
        int key = 0; /** 这个值非常的重要 */
        int[] array = new int[sets.size()]; /** 长度搞出来了 */
        key= nums[0]; /** 将初始值赋予过去 */
        array[index] = key;
        index++;
        for(int i = 0; i < nums.length; i++) { /** 只能用着一次循环 */
            /** 下面，我只需要同步数据就可以了  */
            if(key != nums[i]) {
                array[index] = nums[i];
                index++;
                key = nums[i];
            }
        }
        for(int i = 0; i < sets.size(); i++) {
            nums[i] = array[i];
        }
        return sets.size();
    }
}
