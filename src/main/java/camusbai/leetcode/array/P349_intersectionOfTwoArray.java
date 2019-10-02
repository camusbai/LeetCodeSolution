package camusbai.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

public class P349_intersectionOfTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<Integer> resultList = new ArrayList<>();
        for (Integer i : set1) {
            if (set2.contains(i)) {
                resultList.add(i);
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
