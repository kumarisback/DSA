class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = -1;

        for (int p : piles) {
            if (max < p)
                max = p;
        }

        int l = 1;
        int r = max;
        while (l < r) {
            int hrs = 0;
            int mid = l + (r - l) / 2;
            for (int p : piles) {
                hrs = hrs + p / mid;
                if (p % mid != 0)
                    hrs++;
            }
            if (hrs <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }
}
