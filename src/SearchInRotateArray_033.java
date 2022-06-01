public class SearchInRotateArray_033 {
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[start] <= nums[mid]) { // mid is in first asending subarray
                if(nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotateArray_033 ex = new SearchInRotateArray_033();
//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 0;
        int[] nums = {1, 3, 1, 1, 1};
        int target = 3;
        int target_index = ex.search(nums, target);
        System.out.println("target index is: " + target_index);
    }
}
