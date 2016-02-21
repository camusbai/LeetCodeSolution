package camusbai.leetcode.mathematic;

import camusbai.leetcode.global.Solution;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 */
public class Problem11_WaterContainer {
  public static void main(String[] args) {
    int[] heights = new int[]{2, 3, 4, 5, 5};

    System.out.println(maxArea(heights));
  }

  public static int maxArea(int[] height) {
    Solution sol = Solution.BEST;
    switch (sol) {
      case MINE:
        if (height.length < 2)
          return 0;
        else
          return getMaxArea(height, height.length);
      case BEST:
        int left=0, right = height.length-1;
        int leftH = height[0], rightH = height[height.length - 1];
        int maxArea = Math.min(leftH, rightH) * (right - left);
        while (left != right) {
          if (leftH < rightH) {
            int nextLeft = height[++left];
            if (nextLeft > leftH) {
              leftH = nextLeft;
              maxArea = Math.max(maxArea, Math.min(leftH, rightH) * (right - left));
            }
          }
          else{
            int nextRight = height[--right];
            if (nextRight > rightH) {
              rightH = nextRight;
              maxArea = Math.max(maxArea, Math.min(leftH, rightH) * (right - left));
            }
          }
        }
        return maxArea;
      default:
        return 0;
    }
  }

  private static int getMaxArea(int[] height, int size) {
    if (size == 2) {
      return Math.min(height[0], height[1]);
    } else {
      int prevMax = getMaxArea(height, size - 1);
      for (int i = 1; i < size; i++)
        prevMax = Math.max(prevMax, i * Math.min(height[size - 1 - i], height[size - 1]));
      return prevMax;
    }
  }
}