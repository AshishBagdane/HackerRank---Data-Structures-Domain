package datastructures.trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SwapNodesAlgo {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SwapTree root = new SwapTree(1, null, null);
		int N = sc.nextInt();
		Queue<SwapTree> nodes = new ArrayDeque<>();
		nodes.add(root);
		for (int i = 1; i <= N; i++) {
			SwapTree node = nodes.poll();
			int leftData = sc.nextInt();
			SwapTree left = null, right = null;
			if (leftData != -1) {
				left = new SwapTree(leftData, null, null);
				nodes.add(left);
				node.setLeft(left);
			}
			int rightData = sc.nextInt();
			if (rightData != -1) {
				right = new SwapTree(rightData, null, null);
				nodes.add(right);
				node.setRight(right);
			}
		}

		int T = sc.nextInt();
		int height = height(root);
		while (T-- != 0) {
			int d = sc.nextInt();
			for (int i = d; i <= height; i += 2) {
				nodesAtDepth(root, i);
			}
			inorder(root);
			System.out.println();
		}
		sc.close();
	}

	static int height(SwapTree root) {
		if (root == null) {
			return -1;
		}
		int leftHeight = height(root.getLeft());
		int rightHeight = height(root.getRight());
		return Integer.max(leftHeight, rightHeight) + 1;
	}

	static void nodesAtDepth(SwapTree root, int depth) {
		if (root == null) {
			return;
		}
		if (depth == 1) {
			SwapTree temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);
		} else {
			nodesAtDepth(root.getLeft(), depth - 1);
			nodesAtDepth(root.getRight(), depth - 1);
		}
	}

	static void inorder(SwapTree root) {
		if (root != null) {
			inorder(root.getLeft());
			System.out.print(root.getData() + " ");
			inorder(root.getRight());
		}
	}

	static class SwapTree {
		private int data;
		private SwapTree left;
		private SwapTree right;

		public SwapTree() {
		}

		public SwapTree(int data, SwapTree left, SwapTree right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public SwapTree getRight() {
			return right;
		}

		public void setRight(SwapTree right) {
			this.right = right;
		}

		public SwapTree getLeft() {
			return left;
		}

		public void setLeft(SwapTree left) {
			this.left = left;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
	}
}