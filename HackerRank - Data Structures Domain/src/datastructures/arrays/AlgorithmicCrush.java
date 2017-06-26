package datastructures.arrays;

import java.util.Scanner;

public class AlgorithmicCrush {
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		long[] arr = new long[N + 1];
		long maxValue = 0;
		while (Q-- != 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int k = sc.nextInt();
			for (int i = a; i <= b && k != 0; i++) {
				arr[i] += k;
				if (arr[i] > maxValue) {
					maxValue = arr[i];
				}
			}
		}
		sc.close();
		System.out.println(maxValue);
    }
}
