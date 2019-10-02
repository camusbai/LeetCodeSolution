package camusbai.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 */
public class Problem57_InsertInterval {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 5));
//    intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 8));
//    intervals.add(new Interval(8, 10));
//    intervals.add(new Interval(12, 16));

        List<Interval> result1 = insert(intervals, new Interval(5, 6));
        System.out.println(result1);
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        int start = newInterval.start, end = newInterval.end;
        int leftIdx, rightIdx;
        for (leftIdx = 0; leftIdx < intervals.size(); ++leftIdx) {
            Interval interval = intervals.get(leftIdx);
            if (start > interval.end)
                result.add(interval);
            else
                break;
        }

        for (rightIdx = leftIdx; rightIdx < intervals.size(); ++rightIdx) {
            Interval interval = intervals.get(rightIdx);
            if (end <= interval.end)
                break;
        }

        if (leftIdx == rightIdx) {
            // special case when newInterval should be the last and no overlap
            if (rightIdx == intervals.size()) {
                result.add(newInterval);
                return result;
            }

            Interval interval = intervals.get(rightIdx);
            if (end >= interval.start) {
                newInterval.start = Math.min(start, interval.start);
                newInterval.end = Math.max(end, interval.end);
                rightIdx++;
            }

            result.add(newInterval);
        } else if (leftIdx < rightIdx) {
            Interval leftInterval = intervals.get(leftIdx);

            newInterval.start = Math.min(start, leftInterval.start);
            if (rightIdx < intervals.size() && end >= intervals.get(rightIdx).start) {
                newInterval.end = intervals.get(rightIdx).end;
                rightIdx++;
            }

            result.add(newInterval);
        }

        while (rightIdx < intervals.size())
            result.add(intervals.get(rightIdx++));

        return result;
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return Integer.toString(start) + ' ' + Integer.toString(end);
        }
    }
}
