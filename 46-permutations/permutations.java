import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(0, nums, ans);
        return ans;
    }

    private void generate(int idx, int[] nums, List<List<Integer>> ans) {
        int n = nums.length;

        // valid permutation
        if (idx == n - 1) {
            List<Integer> list = new ArrayList<>();

            for (int ele : nums) {
                list.add(ele);
            }

            ans.add(list);
            return;
        }

        // swap idx with every element from idx to n-1
        for (int i = idx; i < n; i++) {

            swap(i, idx, nums);

            generate(idx + 1, nums, ans);

            // backtracking
            swap(i, idx, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}