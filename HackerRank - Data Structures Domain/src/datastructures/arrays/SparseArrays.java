package datastructures.arrays;

import java.util.Scanner;

public class SparseArrays {
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = sc.next();
		}
		int Q = sc.nextInt();
		String[] queries = new String[Q];
		for (int i = 0; i < Q; i++) {
			queries[i] = sc.next();
		}
		sc.close();
		for (String query : queries) {
			int count = 0;
			for (String word : str) {
				if (query.equals(word)) {
					count++;
				}
			}
			System.out.println(count);
		}
    }
}
