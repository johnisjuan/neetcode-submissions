class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = 0;

        // Maximum useful speed is the largest pile
        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        int res = r;

        while (l <= r) {
            int m = l + (r - l) / 2;

            long hours = 0;

            for (int pile : piles) {
                hours += (pile + m - 1L) / m;
            }

            if (hours <= h) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return res;
    }
}