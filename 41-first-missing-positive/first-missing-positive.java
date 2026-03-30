class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;

        // Cyclic sort
        while (i < n) {
            int correctIndex = nums[i] - 1;

            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]) {
                // swap
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

        // Find first missing positive
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all correct
        return n + 1;
    }
}