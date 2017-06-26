package datastructures.queues.medium;

import java.util.HashMap;
import java.util.Scanner;

public class DownToZeroII {
    
	public static void main(String[] args) {
		HashMap<Integer, Integer> numberReductions = new HashMap<>();
		int MAX = 1000000;
		int sqrtMAX = (int) Math.floor(Math.sqrt(MAX));
		for (int i = 0; i <= MAX; i++) {
			numberReductions.put(i, i);
		}
		for (int i = 1; i < MAX; i++) {
			int score = numberReductions.get(i) + 1;
			int limit;

			if (numberReductions.get(i + 1) > score) {
				numberReductions.put(i + 1, score);
			}

			if (i > sqrtMAX)
				limit = MAX;
			else
				limit = i * i;
			for (int j = i + i; j <= limit; j += i) {
				if (numberReductions.get(j) > score)
					numberReductions.put(j, score);
			}
		}
		Scanner sc = new Scanner(System.in);
		StringBuffer output = new StringBuffer();
		int Q = sc.nextInt();
		while (Q-- != 0) {
			int N = sc.nextInt();
			output.append(numberReductions.get(N)).append('\n');
		}
		sc.close();
		System.out.println(output);
	}
}
