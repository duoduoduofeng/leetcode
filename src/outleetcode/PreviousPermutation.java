package outleetcode;

//数字的前序排列：给定一个数字n，求最大且小于它的排列
//        372 -> 327 -> 273
//        463478 -> 448763
//        25463478 ->  25448763
//        接口定义：
//        vector<int> previousPermutation(vector<int> input);
//        例如给定{3, 7, 2}，返回{3, 2, 7}。

import java.util.Arrays;

public class PreviousPermutation {
    public int[] getLargestPreviousPermutation(int[] nums) {
        if(nums.length <= 1) {
            return nums;
        }

        if(nums.length == 2) {
            swap(nums, 0, 1);
            return nums;
        }

        int sepIndex = nums.length - 1;
        for(int i = nums.length - 1; i >= 1; i--) {
            if(nums[i-1] > nums[i]) {
                sepIndex = i - 1;
                break;
            }
        }

        // 如果是单调递增的数组，怎么操作呢？
        int maxLargerThanSep = sepIndex + 1;
        while(nums[maxLargerThanSep] < nums[sepIndex]) {
            ++maxLargerThanSep;
        }

        swap(nums, sepIndex, maxLargerThanSep - 1); //maxLargerThanSep在while循环中多往前走了一步。

        // 反转剩余数组
        int i = sepIndex + 1;
        int j = nums.length - 1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        PreviousPermutation ex = new PreviousPermutation();
        int[] nums = {2, 5, 4, 6, 3, 4, 7, 8};
        int[] output = ex.getLargestPreviousPermutation(nums);
        System.out.println(Arrays.toString(output));
    }
}
