package datastructures.disjointsets.medium;

import java.util.Scanner;

public class ComponentsInAGraph {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		DisjointSet ds = new DisjointSet(N * 2);
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			ds.otherUnion(x, y);
		}
		sc.close();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= 2 * N; i++) {
			int rank = ds.rank.get(ds.find(i));
			if (rank > 1) {
				if (rank > max) {
					max = rank;
				}
				if (rank < min) {
					min = rank;
				}
			}
			System.out.println(i + " " + rank);
		}
		System.out.println(min + " " + max);
	}
}
