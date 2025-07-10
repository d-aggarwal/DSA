public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Peak is in the left half (including mid)
                right = mid;
            } else {
                // Peak is in the right half (excluding mid)
                left = mid + 1;
            }
        }

        // left == right is the peak element index
        return left;
    }
}
