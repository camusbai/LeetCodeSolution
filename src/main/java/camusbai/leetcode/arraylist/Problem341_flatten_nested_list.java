package camusbai.leetcode.arraylist;

import camusbai.leetcode.global.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Problem341_flatten_nested_list {

    public static void main(String[] args) {

    }

    private static class NestedIterator implements Iterator<Integer> {
        private Stack<TrackingStackElement> stackTrack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            if (nestedList != null) {
                stackTrack.push(new TrackingStackElement(nestedList));
            }
        }

        @Override
        public Integer next() {
            TrackingStackElement stackedEntry = stackTrack.peek();
            NestedInteger currElem = stackedEntry.nestedList.get(stackedEntry.currIdx++);
            while (!currElem.isInteger()) {
                stackedEntry = stackTrack.push(new TrackingStackElement(currElem.getList()));
                currElem = stackedEntry.nestedList.get(stackedEntry.currIdx++);
            }

            while (!stackTrack.isEmpty() && stackedEntry.currIdx == stackedEntry.nestedList.size()) {
                stackTrack.pop();
                if (!stackTrack.isEmpty()) {
                    stackedEntry = stackTrack.peek();
                }
            }

            return currElem.getInteger();
        }

        @Override
        public boolean hasNext() {
            if (stackTrack.isEmpty()) {
                return false;
            }

            TrackingStackElement stackedEntry = stackTrack.peek();

            if (stackedEntry.currIdx != -1) {
            }

            NestedInteger currElem = stackedEntry.nestedList.get(stackedEntry.currIdx);
            while (!currElem.isInteger()) {
                stackedEntry = stackTrack.push(new TrackingStackElement(currElem.getList()));
            }


            return stackedEntry.currIdx > -1 && stackedEntry.currIdx < stackedEntry.nestedList.size();
        }

        private static class TrackingStackElement {
            List<NestedInteger> nestedList;
            int currIdx;

            public TrackingStackElement(List<NestedInteger> nestedList) {
                this.nestedList = nestedList;
                if (nestedList != null && nestedList.size() > 0) {
                    currIdx = 0;
                } else {
                    currIdx = -1;
                }
            }
        }

        // appendix
        public List<Integer> getFlattendList(List<NestedInteger> data) {
            List<Integer> result = new ArrayList<>();
            for (NestedInteger item : data) {
                recursion(item, result);
            }

            return result;
        }

        private void recursion(NestedInteger elem, List<Integer> buildList) {
            if (elem.isInteger()) {
                buildList.add(elem.getInteger());
            } else {
                for (NestedInteger ni : elem.getList()) {
                    recursion(ni, buildList);
                }
            }
        }
    }
}
