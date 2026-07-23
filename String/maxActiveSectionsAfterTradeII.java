// class Solution {
//     Map<String,Integer> gainMap = new HashMap<>();
//     public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
//         List<Integer> result = new ArrayList<>();
//         int n = s.length();

//         int[] prefixOnes = new int[n + 1];

//         for (int i = 0; i < n; i++) {
//             prefixOnes[i + 1] = prefixOnes[i]
//                     + (s.charAt(i) == '1' ? 1 : 0);
//         }

//         for(int i = 0 ; i < queries.length; i++){
//             int start = queries[i][0];
//             int end = queries[i][1]+1;
//             int ones = prefixOnes[end]-prefixOnes[start];
//             int gain = maxActiveSectionsAfterTrade(s , start,end);
//             int oneStart = prefixOnes[start];
//             int oneEnd = prefixOnes[n]-prefixOnes[end];;
//             result.add(gain+oneStart+oneEnd);
//         }
//         return result;
//     }

//     public int maxActiveSectionsAfterTrade(String s, int start , int end) {
//         int n = s.length();
//         int totalOnes = 0;
//         int maxGain = 0;
//         int prevZeroBlock = 0;

//         int i = start;
//         while (i < end) {
//             if (s.charAt(i) == '1') {
//                 totalOnes++;
//                 i++;
//             } else {
//                 int currStart = i;
//                 while (i < end && s.charAt(i) == '0') {
//                     i++;
//                 }
//                 int currZeroBlock = i - currStart;

//                 // Maximize the sum of two adjacent zero blocks
//                 if (prevZeroBlock > 0) {
//                     maxGain = Math.max(maxGain, prevZeroBlock + currZeroBlock);
//                 }
//                 prevZeroBlock = currZeroBlock;
//             }
//         }

//         return totalOnes + maxGain;
//     }

// }


import java.util.*;

class Solution {
    
    // Represents a contiguous block of '0's
    static class Group {
        int start;
        int end;
        int length;
        
        Group(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }

    // Sparse Table for O(1) Range Maximum Queries on adjacent sums
    static class SparseTable {
        private final int[][] st;

        public SparseTable(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                st = new int[0][0];
                return;
            }
            int logN = 32 - Integer.numberOfLeadingZeros(n);
            st = new int[logN][n];
            System.arraycopy(nums, 0, st[0], 0, n);

            for (int k = 1; k < logN; k++) {
                for (int i = 0; i + (1 << k) <= n; i++) {
                    st[k][i] = Math.max(st[k - 1][i], st[k - 1][i + (1 << (k - 1))]);
                }
            }
        }

        public int query(int l, int r) {
            if (l > r || st.length == 0) return 0;
            int length = r - l + 1;
            int k = 31 - Integer.numberOfLeadingZeros(length);
            return Math.max(st[k][l], st[k][r - (1 << k) + 1]);
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int totalOnes = 0;
        List<Group> zeroGroups = new ArrayList<>();

        // 1. Identify all distinct '0' groups and count total '1's in one pass
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '1') {
                totalOnes++;
                i++;
            } else {
                int start = i;
                while (i < n && s.charAt(i) == '0') {
                    i++;
                }
                int end = i - 1;
                zeroGroups.add(new Group(start, end, end - start + 1));
            }
        }

        int m = zeroGroups.size();
        
        // 2. Precompute the sums of adjacent '0' blocks
        int[] adjacentSums = new int[Math.max(0, m - 1)];
        for (int j = 0; j < m - 1; j++) {
            adjacentSums[j] = zeroGroups.get(j).length + zeroGroups.get(j + 1).length;
        }

        SparseTable st = new SparseTable(adjacentSums);
        List<Integer> ans = new ArrayList<>(queries.length);

        // 3. Process each query using Binary Search
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];

            // Find u: The index of the FIRST '0' group ending >= l
            int u = -1;
            int low = 0, high = m - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (zeroGroups.get(mid).end >= l) {
                    u = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Find v: The index of the LAST '0' group starting <= r
            int v = -1;
            low = 0; high = m - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (zeroGroups.get(mid).start <= r) {
                    v = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            int maxGain = 0;

            // If we found valid intersecting groups and there are at least two (u < v)
            if (u != -1 && v != -1 && u < v) {
                // Calculate lengths of boundary groups clamped exactly to [l, r]
                int lu = zeroGroups.get(u).end - Math.max(l, zeroGroups.get(u).start) + 1;
                int lv = Math.min(r, zeroGroups.get(v).end) - zeroGroups.get(v).start + 1;

                if (u + 1 == v) {
                    // Only two groups exist inside this range
                    maxGain = lu + lv;
                } else {
                    // Test boundary group u with its right neighbor
                    maxGain = Math.max(maxGain, lu + zeroGroups.get(u + 1).length);
                    
                    // Test boundary group v with its left neighbor
                    maxGain = Math.max(maxGain, zeroGroups.get(v - 1).length + lv);
                    
                    // Test all fully enclosed inner groups (if any) using the Sparse Table
                    if (u + 1 <= v - 2) {
                        maxGain = Math.max(maxGain, st.query(u + 1, v - 2));
                    }
                }
            }

            // Note: `totalOnes` represents the total '1's in the entire string.
            // This is mathematically identical to your original addition:
            // (ones_inside + gain) + ones_before + ones_after = totalOnes + gain
            ans.add(totalOnes + maxGain);
        }

        return ans;
    }
}
