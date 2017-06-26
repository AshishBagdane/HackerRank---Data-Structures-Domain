package datastructures.linkedlists;

import java.util.Scanner;

public class DoublyLinkedList {
    
	static class DNode {

		int data;
		DNode prev, next;

		public DNode() {
		}

		public DNode(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DNode head = null;
		for (int i = 1; i <= 10; i++) {
			head = sortedInsert(head, (int) (Math.random() * 100));
			printList(head);
		}
		sc.close();
	}

	static void printList(DNode head) {
		for (DNode temp = head; temp != null; temp = temp.next) {
			System.out.print(temp.data + " ");
		}
		System.out.println();
	}

	static DNode insertNode(DNode head, int data) {
		DNode newNode = new DNode(data);
		if (head != null) {
			newNode.next = head;
			head.prev = newNode;
		}
		return newNode;
	}

	static void deleteNode(DNode dNode) {
		if (dNode != null) {
			if (dNode.prev == null) {
				dNode = dNode.next;
			} else {
				dNode.prev.next = dNode.next;
			}
		}
	}

	static DNode reverse(DNode head) {
		DNode current = head;
		DNode temp = null;
		DNode newHead = null;
		while (current != null) {
			temp = current.next;
			current.next = current.prev;
			current.prev = temp;
			newHead = current;
			current = temp;
		}
		return newHead;
	}

	static DNode sortedInsert(DNode head, int data) {
		DNode newNode = new DNode(data);
		if (head == null) {
			return insertNode(head, data);
		} else {
			DNode temp = head;
			if (temp.next == null && temp.prev == null) {
				if (temp.data > data) {
					head = insertNode(head, data);
				} else {
					temp.next = newNode;
					newNode.prev = temp;
				}
			} else {
				while (temp.data < data && temp.next != null) {
					temp = temp.next;
				}
				if (temp.data >= data) {
					if (temp.prev != null) {
						temp.prev.next = newNode;
						newNode.prev = temp.prev;
						temp.prev = newNode;
						newNode.next = temp;
					} else {
						head = insertNode(head, data);
					}
				} else {
					temp.next = newNode;
					newNode.prev = temp;
				}
			}
		}
		return head;
	}
}