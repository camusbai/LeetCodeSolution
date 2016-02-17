package camusbai.leetcode.mathematic;

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
    if (height.length < 2)
      return 0;
    else
      return getMaxArea(height, height.length);
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