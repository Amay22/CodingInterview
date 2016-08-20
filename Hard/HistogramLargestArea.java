package Hard;

import java.util.Stack;

public class HistogramLargestArea {

    private static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;
        while (i < height.length) {

            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {

                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }
        }
        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }
        return max;
    }
    
    private static int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        for (int aHeight : height) {
            max = Math.max(max, aHeight);
        }
        return max;
    }
    
    public static void main(String[] args) {
        int area[] = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(area));
        System.out.println(maxArea(area));
    }
}
