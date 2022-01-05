public class FirstnLastPositionSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFistPosition(nums, target);
        result[1] = findLastPosition(nums, target);
        return result;
    }
    // [4,5,6,7,8,8,10]
    private int findFistPosition(int[] nums, int target){
        int index = -1; // not found the target
        int start = 0;
        int end = nums.length - 1;
        while (start<=end){
            int mid = (start + end)/2;
            if (nums[mid] >= target ){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
            if (nums[mid] == target){
                index = mid;
            }
        }
        return index;
    }
    private int findLastPosition(int[] nums, int target){
        int index = -1; // not found the target
        int start = 0;
        int end = nums.length - 1;
        while (start<=end){
            int mid = (start + end)/2;
            if (nums[mid] <= target){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
            if (nums[mid] == target){
                index = mid;
            }
        }
        return index;
    }

    public static void main(String args[]){
        FirstnLastPositionSortedArray f = new FirstnLastPositionSortedArray();
        int[] nums = {4,5,6,7,8,8,10};
        int target = 8;
        int[] result = f.searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
