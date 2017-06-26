package datastructures.queues.medium;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		while (q-- != 0) {
			byte type = sc.nextByte();
			switch (type) {
			case 1:
				int item = sc.nextInt();
				stack1.push(item);
				break;
			case 2:
				if (stack2.isEmpty() && !stack1.isEmpty()) {
					while (!stack1.isEmpty()) {
						stack2.push(stack1.pop());
					}
					stack2.pop();
				} else {
					stack2.pop();
				}
				break;
			case 3:
				if (!stack2.isEmpty()) {
					System.out.println(stack2.peek());
				} else {
					if (stack2.isEmpty() && !stack1.isEmpty()) {
						while (!stack1.isEmpty()) {
							stack2.push(stack1.pop());
						}
						System.out.println(stack2.peek());
					}
				}
				break;
			}
		}
		sc.close();
    }
}
