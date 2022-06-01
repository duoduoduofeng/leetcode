import java.util.Arrays;

public class SortArray {
    public int[] sortArray(int[] nums) {
        if(nums.length <= 1){
            return nums;
        }

        // quickSort(nums, 0, nums.length -1);
        heapSort(nums);
        return nums;
    }

    // quicksort
    private void quickSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }

        int sep = partition(nums, start, end);
        quickSort(nums, start, sep - 1);
        quickSort(nums, sep + 1, end);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int partition(int[] nums, int start, int end){
        int flag = start + 1;
        for(int i = start + 1; i <= end; i++) {
            if(nums[i] < nums[start]){
                swap(nums, i, flag);
                flag++;
            }
        }

        flag--;
        swap(nums, start, flag);
        return flag;
    }

    // heap sort
    private void heapSort(int[] nums) {
        buildMaxHeap(nums);

        for(int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            adaptMaxHeap(nums, 0, i);
        }
    }

    private void buildMaxHeap(int[] nums) {
        for(int i = (int)(Math.floor(nums.length/2)) - 1; i >= 0; i--) {
            adaptMaxHeap(nums, i, nums.length);
        }
    }

    private void adaptMaxHeap(int[] nums, int root, int len) {
        if(root > (int)(Math.floor(len/2)) - 1) {
            return;
        }
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        int max = root;

        if(left < len && nums[left] > nums[max]) {
            max = left;
        }
        if(right < len && nums[right] > nums[max]) {
            max = right;
        }

        if(max != root) { // 需要进行调整
            swap(nums, max, root);
            adaptMaxHeap(nums, max, len);
        }
    }

    public static void main(String[] args) {
        SortArray ex = new SortArray();
        int[] nums = {-4, 0, 7, 4, 9, -5, -1, 0, -7, -1};
        System.out.println(Arrays.toString(nums));
        ex.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}