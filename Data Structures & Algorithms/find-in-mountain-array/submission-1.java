class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int l = 0;
        int r = n - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (mountainArr.get(m) < mountainArr.get(m + 1)) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int peak = l;

        l = 0;
        r = peak;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = mountainArr.get(m);

            if (val < target) {
                l = m + 1;
            } else if (val > target) {
                r = m - 1;
            } else {
                return m;
            }
        }
        l = peak + 1;
        r = n - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = mountainArr.get(m);

            if (val > target) {
                l = m + 1;
            } else if (val < target) {
                r = m - 1;
            } else {
                return m;
            }
        }

        return -1;
    }
}