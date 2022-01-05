//There is an integer array nums sorted in ascending order (with distinct values).

//Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k
// (1 <= k < nums.length) such that the resulting array is
// [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
// For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

//Given the array nums after the possible rotation and an integer target,
// return the index of target if it is in nums, or -1 if it is not in nums.

//You must write an algorithm with O(log n) runtime complexity.
public class SearchRotatedArray {
    public int search(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while (nums[left] > nums[right]){
            left++;
        }
        int temp = left;
        left = 0;
        if (nums[temp] <= target && target <= nums[right]){
            left = temp;
        }
        else{
            right = temp;
        }

        while (left < right){
            int mid = (right +left)/2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] > target){
                right=mid-1;
            }
            else if (nums[mid] < target){
                left=mid+1;
            }
        }
        if (nums[left] > target || nums[right] < target){
            return -1;
        }
        return left;
        }
        public static void main(String [] args){
        // {4,5,6,7,0,1,2}; {1,3}; {1}; {3,5}
            int [] nums = {4,5,6,7,0,1,2};
            int target = 3;
            SearchRotatedArray s = new SearchRotatedArray();
            System.out.println(s.search(nums,target));

        }
    }

