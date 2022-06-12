package leetcodeproblems.LC_001_100;

public class S_088_MergeSortedArray {
    // https://leetcode.com/problems/merge-sorted-array/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) {
            return;
        }

        int i = m - 1, j = n - 1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] >= nums2[j]) {
                nums1[i + j + 1] = nums1[i--];
            } else {
                nums1[i + j + 1] = nums2[j--];
            }
        }

        if(j >= 0) {
            while(j >= 0) {
                nums1[i + j + 1] = nums2[j--];
            }
        }

        return;
    }
}
