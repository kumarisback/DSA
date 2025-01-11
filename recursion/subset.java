import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        rec(nums, list, set, 0);
        return new ArrayList<>(set);
    }

    public void rec(int[] arr, List<Integer> list, Set<List<Integer>> set, int i) {
        if (arr.length <= i) { // Fix boundary condition (arr.length < i is incorrect)
            set.add(new ArrayList<>(list)); // Add a copy of the list
            return;
        }

        // Skip the current element
        rec(arr, list, set, i + 1);

        // Include the current element
        list.add(arr[i]);
        rec(arr, list, set, i + 1);
        list.remove(list.size() - 1); // Backtrack to remove the last element
    }
}
