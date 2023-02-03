package leetcodeproblems.LC_101_200;

//154. [Find Minimum in Rotated Sorted Array II]
// (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii)
public class S_154_FindMinInRotatedArrayII {
    public int findMin(int[] nums) {
        if(nums.length <= 1) {
            return nums[nums.length - 1];
        }

        int start = 0;
        int end = nums.length - 1;

        // 最小值肯定在第二个递增区间
        while(start <= end) {
            // 考虑到数组中有重复元素，nums[start] < nums[end] 时才确认是单调递增了
            // 数组从一开始就是单调递增的情况也被考虑进来了
            if(nums[start] < nums[end]) {
                return nums[start];
            }

            int mid = (start + end) / 2;
            if(nums[start] < nums[mid]) { // mid在第一个递增区间
                start = mid + 1;
            } else if(nums[start] == nums[mid]) {
                int min = start;
                for(int i = start + 1; i <= end; i++) { // 需要将start到end区间完整遍历，不止是start到mid
                    if(nums[i] < nums[min]) {
                        min = i;
                    }
                }
                return nums[min];
            } else {
                end = mid; // 这里无法排除mid值不是最小值，所以不能减一
            }
        }

        return -1;
    }
}
