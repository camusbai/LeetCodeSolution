package camusbai.leetcode.binarysearch;

/* The isBadVersion API is defined in the parent class VersionControl.
   boolean isBadVersion(int version); */

import camusbai.leetcode.environment.VersionControl;

public class Problem278_FirstBadVersion extends VersionControl {
    Problem278_FirstBadVersion(boolean[] versions) {
        super(versions);
    }

    public int firstBadVersion(int n) {
        int start = 0, end = n;
        int mid;

        while (start < end) {
            // mid = (start + end) / 2;
            // NOTE: the above can fail when sum of 'start' and 'end' exceeds Integer.MAX_VALUE
            mid = start / 2 + end / 2;
            if (isBadVersion(mid))
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }

    public static void main(String[] args) {
        boolean[] versions = {false,true,true};
        Problem278_FirstBadVersion fbv = new Problem278_FirstBadVersion(versions);
        System.out.println(fbv.firstBadVersion(versions.length-1));
    }
}
