package datastructures.arrays;

import java.util.Scanner;

public class LeftRotation {
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		int[] arr = new int[n];
		int[] arrRotated = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		for (int i = d; i < n + d; i++) {
			arrRotated[i - d] = arr[i % n];
		}
		for (int i : arrRotated) {
			System.out.print(i + " ");
		}
    }
}
