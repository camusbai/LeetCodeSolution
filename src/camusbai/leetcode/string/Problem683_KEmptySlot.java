package camusbai.leetcode.string;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Input:
 * flowers: [1,3,2]
 * k: 1
 * Output: 2
 */
public class Problem683_KEmptySlot {
    public int kEmptySlots(int[] flowers, int k) {
        if (k + 2 > flowers.length) {
            return -1;
        }
        LinkedList<Range> ranges = new LinkedList<>();
        ranges.add(new Range(0, flowers.length + 1, true));
        for (int i = 0; i < flowers.length; i++) {
            int pos = flowers[i];
            Iterator<Range> iter = ranges.iterator();
            while (iter.hasNext()) {
                Range range = iter.next();
                if (range.valid && pos > range.startPos && pos < range.endPos) {
                    int gap1 = pos - range.startPos - 1;
                    int gap2 = range.endPos - pos - 1;
                    if ((range.startPos != 0 && gap1 == k) || (range.endPos != flowers.length + 1 && gap2 == k)) {
                        return i + 1;
                    }

                    Range r1 = new Range(range.startPos, pos, gap1 > k);
                    Range r2 = new Range(pos, range.endPos, gap2 > k);

                    iter.remove();
                    ranges.add(r1);
                    ranges.add(r2);

                    break;
                }
            }

        }

        return -1;
    }

    static class Range {
        int startPos, endPos;
        boolean valid;

        Range(int startPos, int endPos, boolean valid) {
            this.startPos = startPos;
            this.endPos = endPos;
            this.valid = valid;
        }
    }
}
