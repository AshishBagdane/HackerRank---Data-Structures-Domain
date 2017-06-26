package datastructures.heaps.easy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class QHEAP1 {
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		sc.nextLine();
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		while (Q-- != 0) {
			switch (sc.nextInt()) {
			case 1:
				heap.add(sc.nextInt());
				break;
			case 2:
				heap.remove(sc.nextInt());
				break;
			case 3:
				int polled = heap.poll();
				System.out.println(polled);
				heap.add(polled);
				break;
			}
		}
		sc.close();
    }
}
