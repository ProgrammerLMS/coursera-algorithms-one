package quiz1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    // 本题最难的是如何去重，比较有技巧性
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // sort first
        Arrays.sort(nums);
        int low, high;
        for(int i=0;i < nums.length;i++) {
            // 为什么不是 nums[i] == nums[i+1]
            // 因为后一位可能要用到，比如 [-1, -1, 2]
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            low = i + 1;
            high = nums.length - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] > 0) {
                    high --;
                } else if (nums[i] + nums[low] + nums[high] < 0) {
                    low ++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    // 第二次去重，是针对后两项的去重
                    // 例如，[-1, -1, -1, 2, 2, 2, 2]
                    while (high > low && nums[high] == nums[high-1]) high--;
                    while (high > low && nums[low] == nums[low+1]) low++;
                    high --;
                    low ++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
