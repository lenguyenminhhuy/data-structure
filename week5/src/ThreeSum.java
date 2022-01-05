import java.util.*;
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>(); // note: Arrays.asList()
        for (int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i>0 && nums[i] != nums[i - 1])){
                int left = i+1;
                int right = nums.length - 1;
                int remainSum = -nums[i];
                while (left < right){
                    if (nums[left] + nums[right] > remainSum){
                        right--;
                    }
                    else if (nums[left] + nums[right] < remainSum ){
                        left++;
                    }
                    else {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // remove duplicate case
                        while (left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        while (left < right && nums[right] == nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String args[]){
        ThreeSum threeSumProb = new ThreeSum();
        int[] testArr = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSumProb.threeSum(testArr);
        for (List<Integer> list : result){
            System.out.println(list);
        }
        System.out.println(result);
    }
}
