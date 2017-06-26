package datastructures.linkedlists;

public class LinkedListOperations {
	
	static class Node {
		int data;
		Node next;
	}

	public static void main(String[] args) {
		Node headA = null, headB = null;
		for (int i = 10; i > 0; i--) {
			headA = insertAtHead(headA, i);
		}
		printList(headA);
		for (int i = 5; i > 0; i--) {
			headB = insertAtHead(headB, i);
		}
		printList(headB);
		printList((mergeLists(headA, headB)));
	}

	static Node insertAtHead(Node head, int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;
		if (head != null)
			newNode.next = head;
		return newNode;
	}

	static Node insertAtTail(Node head, int data) {
		if (head == null) {
			head = new Node();
			head.data = data;
		} else {
			Node temp = head;
			for (; temp.next != null; temp = temp.next)
				;
			temp.next = new Node();
			temp.next.data = data;
		}
		return head;
	}

	static Node InsertNth(Node head, int data, int position) {
		Node newNode = new Node();
		newNode.data = data;
		if (position == 0) {
			newNode.next = head;
			return newNode;
		} else {
			Node temp = head, i;
			for (int index = 0; index > 0; --index, temp = temp.next)
				;
			i = temp.next;
			temp.next = newNode;
			temp.next.next = i;
		}
		return head;
	}

	static void printList(Node head) {
		for (Node temp = head; temp != null; temp = temp.next)
			System.out.print(temp.data + " ");
		System.out.println();
	}

	static Node deleteNode(Node head, int position) {
		Node temp = head;
		if (position == 0)
			head = head.next;
		else
			for (; temp != null && --position != 0; temp = temp.next)
				;
		temp.next = (temp.next.next != null) ? temp.next.next : null;
		return head;
	}

	static void printReverse(Node head) {
		if (head == null)
			return;
		printReverse(head.next);
		System.out.println(head.data);
	}

	static Node reverse(Node head) {
		Node prev = null;
		Node current = head;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	int compareLists(Node headA, Node headB) {
		if (headA == null || headB == null)
			return 0;
		for (Node tempA = headA, tempB = headB; tempA != null && tempB != null; tempA = tempA.next, tempB = tempB.next)
			if (headA.data != headB.data)
				return 0;
		return 1;
	}

	static Node mergeLists(Node headA, Node headB) {
		Node resultant = null;
		Node tempA = headA, tempB = headB;
		while (tempA != null || tempB != null) {
			if (tempA != null && tempB != null) {
				if (tempA.data <= tempB.data) {
					resultant = insertAtHead(resultant, tempA.data);
					tempA = tempA.next;
				} else {
					resultant = insertAtHead(resultant, tempB.data);
					tempB = tempB.next;
				}
			} else if (tempA != null) {
				resultant = insertAtHead(resultant, tempA.data);
				tempA = tempA.next;
			} else {
				resultant = insertAtHead(resultant, tempB.data);
				tempB = tempB.next;
			}
		}
		return resultant;
	}

	static int getNode(Node head, int n) {
		for (Node temp = reverse(head); temp != null; temp = temp.next)
			if (n-- == 0)
				return temp.data;
		return -1;
	}

	static Node removeDuplicates(Node head) {
		for (Node temp = head; temp.next != null;)
			if (temp.data == temp.next.data)
				temp.next = (temp.next.next != null) ? temp.next.next : null;
			else {
				temp = temp.next;
			}
		return head;
	}

	static boolean checkCycle(Node head) {
		for (Node tempA = head, tempB = tempA.next; tempB != null || tempB.next != null
				|| tempA != null; tempA = tempA.next, tempB = tempB.next.next)
			if (tempA == tempB)
				return true;
		return false;
	}
}