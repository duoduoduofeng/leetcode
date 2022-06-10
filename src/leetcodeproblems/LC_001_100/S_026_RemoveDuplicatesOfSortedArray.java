package leetcodeproblems.LC_001_100;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class S_026_RemoveDuplicatesOfSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }

        int l = 0;
        int r = l + 1;

        while(r < nums.length) {
            if(nums[r] != nums[l]) {
                nums[++l] = nums[r];
            }
            r++;
        }

        return l + 1; // return length
    }
}
