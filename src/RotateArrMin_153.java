public class RotateArrMin_153 {
    public int findMin(int[] nums) {
        if(nums.length <= 1) {
            return nums[nums.length - 1];
        }

        int start = 0;
        int end = nums.length - 1;

        // 确实发生了旋转的情况
        // 最小值肯定在第二个递增区间
        while(start <= end) {
            // 考虑到数组中没有重复元素，已经单调递增了
            if(nums[start] <= nums[end]) {
                return nums[start];
            }

            int mid = (start + end) / 2;
            if(nums[start] <= nums[mid]) { // mid在第一个递增区间
                start = mid + 1;
            } else {
                end = mid; // 这里无法排除mid值不是最小值，所以不能减一
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        RotateArrMin_153 ex = new RotateArrMin_153();
        int[] nums = {3, 1, 2};
        int minEle = ex.findMin(nums);
        System.out.print("minEle = " + minEle);
    }
}