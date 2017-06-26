package datastructures.trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Tree {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node() {
		}

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node root = null;
		root = new Node(3);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right = new Node(5);
		/*
		 * while(n--!=0) { root = insertNode(root, (int) (Math.random() * n)); }
		 */
		inorder(root);
		System.out.println(checkBST(root));
		sc.close();
	}

	static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	static void preorder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	static void postorder(Node root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}

	static Node insertNode(Node root, int data) {
		if (root == null) {
			root = new Node();
			root.data = data;
		} else {
			if (data < root.data) {
				root.left = insertNode(root.left, data);
			} else if (data > root.data) {
				root.right = insertNode(root.right, data);
			}
		}
		return root;
	}

	static int height(Node root) {
		if (root == null) {
			return -1;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Integer.max(leftHeight, rightHeight) + 1;
	}

	static void topView(Node root) {
		if (root == null) {
			return;
		}
		topLeft(root);
		topRight(root.right);
	}

	static void topLeft(Node root) {
		if (root == null) {
			return;
		}
		topLeft(root.left);
		System.out.print(root.data + " ");
	}

	static void topRight(Node root) {
		if (root == null) {
			return;
		}
		topRight(root.right);
		System.out.print(root.data + " ");
	}

	static void levelOrder(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> treeNodes = new ArrayDeque<>();
		treeNodes.add(root);
		while (!treeNodes.isEmpty()) {
			Node parentNode = treeNodes.peek();
			System.out.print(parentNode.data + " ");
			treeNodes.poll();
			if (parentNode.left != null)
				treeNodes.add(parentNode.left);
			if (parentNode.right != null)
				treeNodes.add(parentNode.right);
		}
	}

	static void huffmanDecoding(String code, Node root) {
		if (root == null) {
			return;
		} else if (root.left == null && root.right == null) {
			System.out.println(root.data);
		} else {
			Node currentNode = root;
			for (int i = 0; i < code.length(); i++) {
				currentNode = (code.charAt(i) == '0') ? currentNode.left : currentNode.right;
				if (currentNode.left == null && currentNode.right == null) {
					System.out.println(currentNode.data + " ");
					currentNode = root;
				}
			}
		}
	}

	static Node leastCommonAncestor(Node root, int v1, int v2) {
		if (root == null) {
			return null;
		} else if (v1 < root.data && v2 < root.data) {
			return leastCommonAncestor(root.left, v1, v2);
		} else if (v1 > root.data && v2 > root.data) {
			return leastCommonAncestor(root.right, v1, v2);
		} else {
			return root;
		}
	}

	static boolean isBST(Node root) {
		if (root == null) {
			return true;
		} else if (root.left == null && root.right == null) {
			return true;
		} else {
			Stack<Node> treeNodes = new Stack<>();
			treeNodes.push(root);
			while (!treeNodes.isEmpty()) {
				Node parentNode = treeNodes.pop();
				if (parentNode.left != null) {
					if (parentNode.left.data < parentNode.data) {
						treeNodes.push(parentNode.left);
					} else {
						return false;
					}
				}
				if (parentNode.right != null) {
					if (parentNode.right.data > parentNode.data) {
						treeNodes.push(parentNode.right);
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	static boolean checkBST(Node root) {
		if (root == null) {
			return true;
		} else {
			return inorderCheck(root);
		}
	}

	static boolean inorderCheck(Node root) {
		Stack<Node> nodes = new Stack<>();
		Node currentNode = root;
		while (currentNode != null) {
			nodes.push(currentNode);
			currentNode = currentNode.left;
		}
		int min = Integer.MIN_VALUE;
		while (!nodes.isEmpty()) {
			Node node = nodes.pop();
			if (node.data > min) {
				min = node.data;
			} else {
				return false;
			}
			currentNode = node.right;
			while (currentNode != null) {
				nodes.push(currentNode);
				currentNode = currentNode.left;
			}
		}
		return true;
	}
}