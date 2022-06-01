package leetcodeproblems.LC_001_100;

//81. [Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii)
//因为有相等的元素，因此在start&mid所指元素相等时，要特殊处理，这个区间进行顺序查找。

public class S_081_SearchInRotateArrayII {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) {
            return false;
        }

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(nums[mid] == target) {
                return true;
            }

            if(nums[start] < nums[mid]) { // mid is in first asending subarray
                if(nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if(nums[start] == nums[mid]) { // if equals, need to traverse this region.
                for(int i = start; i <= end; i++) {
                    if(nums[i] == target) {
                        return true;
                    }
                }

                return false;
            } else {
                if(nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }
}
