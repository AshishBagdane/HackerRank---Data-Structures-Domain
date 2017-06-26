package datastructures.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicArray {
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		ArrayList<ArrayList<Integer>> sequences = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			sequences.add(new ArrayList<>());
		}
		int lastAns = 0;
		while (q-- != 0) {
			int qNo = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int seqNo = (x ^ lastAns) % n;
			switch (qNo) {
			case 1:
				sequences.get(seqNo).add(y);
				break;
			case 2:
				System.out.println(lastAns = sequences.get(seqNo).get(y % sequences.get(seqNo).size()));
				break;
			}
		}
		sc.close();
    }
}