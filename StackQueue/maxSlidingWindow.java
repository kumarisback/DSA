import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // Remove indices of elements not in the sliding window
            if (!queue.isEmpty() && queue.peekFirst() < i - k + 1) {
                queue.pollFirst();
            }

            // Remove indices of elements smaller than the current element
            // as they will not be needed
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            // Add current index to the deque
            queue.offerLast(i);

            // Add the maximum value of the current window to the result
            if (i >= k - 1) {
                res[index++] = nums[queue.peekFirst()];
            }
        }

        return res;
    }
}
