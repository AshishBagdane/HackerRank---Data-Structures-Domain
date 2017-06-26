package datastructures.arrays;

import java.util.Scanner;

public class TwoDArrayDS {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] num = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				num[i][j] = sc.nextInt();
			}
		}
		sc.close();
		int currSum = 0, maxSum = -99;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				currSum = num[i][j] + num[i][j + 1] + num[i][j + 2] + num[i + 1][j + 1] + num[i + 2][j]
						+ num[i + 2][j + 1] + num[i + 2][j + 2];
				if (currSum >= maxSum) {
					maxSum = currSum;
				}
			}
		}
		System.out.println(maxSum);
    }
}
