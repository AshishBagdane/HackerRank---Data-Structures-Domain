package datastructures.stacks.hard;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] heights = new int[N];
		int i;
		int maxArea = Integer.MIN_VALUE;
		for (i = 0; i < N; i++) {
			heights[i] = sc.nextInt();
		}
		Stack<Integer> heightIndex = new Stack<>();
		i = 0;
		while (i < N) {
			if (heightIndex.isEmpty() || heights[heightIndex.peek()] <= heights[i]) {
				heightIndex.push(i++);
			} else {
				int topIndex = heightIndex.pop();
				int area = heights[topIndex] * (heightIndex.isEmpty() ? i : i - heightIndex.peek() - 1);
				if (maxArea < area) {
					maxArea = area;
				}
			}
		}
		while (!heightIndex.isEmpty()) {
			int topIndex = heightIndex.pop();
			int area = heights[topIndex] * (heightIndex.isEmpty() ? i : i - heightIndex.peek() - 1);
			if (maxArea < area) {
				maxArea = area;
			}
		}
		System.out.println(maxArea);
		sc.close();
	}
}
