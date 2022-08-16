package leetcodeproblems.LC_001_100;

// 1. [Two Sum](https://leetcode.com/problems/two-sum)

import java.util.HashMap;

public class S_001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] rs = {-1, -1};

        if(nums.length < 2){
            return rs;
        }

        HashMap<Integer, Integer> arr = new HashMap<Integer, Integer>();

        for(int i = 0; i< nums.length; i++) {
            int another = target - nums[i];
            if(arr.containsKey(another)) {
                rs[0] = i;
                rs[1] = arr.get(another);
                return rs;
            } else {
                if(!arr.containsKey(nums[i])){
                    arr.put(nums[i], i);
                }
            }
        }

        return rs;
    }
}

