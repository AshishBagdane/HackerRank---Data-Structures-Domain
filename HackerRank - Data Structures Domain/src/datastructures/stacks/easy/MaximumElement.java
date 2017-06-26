package datastructures.stacks.easy;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int max = Integer.MIN_VALUE;
		Stack<Content> stack = new Stack<>();
		while (n-- != 0) {
			String[] ip = sc.nextLine().split(" ");
			int type = Integer.parseInt(ip[0]);
			int x = (ip.length > 1) ? Integer.parseInt(ip[1]) : 0;
			switch (type) {
			case 1:
				if (x > max)
					max = x;
				stack.push(new Content(x, max));
				break;
			case 2:
				stack.pop();
				if (stack.empty())
					max = Integer.MIN_VALUE;
				else
					max = stack.peek().max;
				break;
			case 3:
				System.out.println(stack.peek().max);
				break;
			}
		}
		sc.close();
	}

	static class Content {
		int no;
		int max;

		public Content(int no, int max) {
			this.no = no;
			this.max = max;
		}
	}
}