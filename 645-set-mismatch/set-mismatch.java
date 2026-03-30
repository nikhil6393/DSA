class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        int n = nums.length;

        // Cyclic sort
        while (i < n) {
            int correctIndex = nums[i] - 1;

            if (nums[i] != nums[correctIndex]) {
                // swap
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

        // Find duplicate and missing
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }

        return new int[]{-1, -1}; // fallback (should not happen)
    }
}