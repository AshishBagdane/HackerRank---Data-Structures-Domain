package datastructures.arrays;

import java.util.Scanner;

public class ArraysDS {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		sc.close();
		for (int i = n - 1; i >= 0; i--) {
			System.out.println(num[i] + " ");
		}
    }
}
