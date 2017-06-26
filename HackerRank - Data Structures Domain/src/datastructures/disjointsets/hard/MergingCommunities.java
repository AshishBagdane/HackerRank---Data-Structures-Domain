package datastructures.disjointsets.hard;

import java.util.Scanner;

public class MergingCommunities {
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		DisjointSet ds = new DisjointSet(N);
		sc.nextLine();
		while (Q-- != 0) {
			String ch = sc.next();
			if (ch.charAt(0) == 'M') {
				int setA = sc.nextInt();
				int setB = sc.nextInt();
				ds.union(setA, setB);
			} else {
				int item = sc.nextInt();
				System.out.println(ds.rank.get(ds.find(item)));
			}
		}
		sc.close();
    }
}
