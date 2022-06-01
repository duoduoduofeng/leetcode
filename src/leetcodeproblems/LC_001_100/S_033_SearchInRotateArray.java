package leetcodeproblems.LC_001_100;

//33. [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array)
//[参考](https://www.cnblogs.com/lfri/p/12553209.html)解决了，左闭右开&左开右闭的条件式很重要。
//        第33, 81, 153, 154均可参考此链接内容。

public class S_033_SearchInRotateArray {
        public int search(int[] nums, int target) {
                if(nums.length == 0) {
                        return -1;
                }

                int start = 0;
                int end = nums.length - 1;

                while(start <= end) { // start=end时表示该区间只有一个元素，也要进行判断是否等于target。
                        int mid = (start + end) / 2;

                        if(nums[mid] == target) {
                                return mid;
                        }

                        if(nums[start] <= nums[mid]) { // nums[mid] is in first asending subarray
                                if(nums[start] <= target && target < nums[mid]) { //[start, mid)左闭右开区间
                                        end = mid - 1;
                                } else {
                                        start = mid + 1;
                                }
                        } else { // else nums[mid] is in second ascending subarray
                                if(nums[mid] < target && target <= nums[end]) { // (mid, end] 左开右闭区间，因为target == nums[mid]的情况已经考虑过了。
                                        start = mid + 1;
                                } else {
                                        end = mid - 1;
                                }
                        }
                }

                return -1;
        }
}
