public class PeakFinder {
    public int findPeak(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right){
            mid = (right + left)/2;
            if (nums[mid] > nums[mid+1]){
                right = mid;
            }
            else if (nums[mid] < nums[mid+1]) {
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String args[]){
        PeakFinder peakFinder = new PeakFinder();
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(peakFinder.findPeak(nums));
        int[] nums2 = {4,3,6,2,1};
        System.out.println(peakFinder.findPeak(nums2));
    }
}
