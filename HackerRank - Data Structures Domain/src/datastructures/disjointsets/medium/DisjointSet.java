package datastructures.disjointsets.medium;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    
	Map<Integer, Integer> parent = new HashMap<>();
	Map<Integer, Integer> rank = new HashMap<>();

	public DisjointSet(int N) {
		makeSet(N);
	}

	public final void makeSet(int N) {
		for (int i = 1; i <= N; i++) {
			parent.put(i, i);
			rank.put(i, 1);
		}
	}

	public int find(int x) {
		if (parent.get(x) == x) {
			return x;
		} else {
			parent.put(x, find(parent.get(x)));
			return parent.get(x);
		}
	}

	public boolean union(int setA, int setB) {
		int parentA = find(setA);
		int parentB = find(setB);
		if (parentA != parentB) {
			if (rank.get(parentA) < rank.get(parentB)) {
				parent.put(parentA, parentB);
				rank.put(parentB, rank.get(parentA) + rank.get(parentB));
			} else {
				parent.put(parentB, parentA);
				rank.put(parentA, rank.get(parentA) + rank.get(parentB));
			}
			return true;
		}
		return false;
	}

	public void otherUnion(int x, int y) {
		int xParent = find(x);
		int yParent = find(y);

		if (xParent == yParent) {
			return;
		}

		int xRank = rank.get(xParent);
		int yRank = rank.get(yParent);

		if (xRank >= yRank) {
			parent.put(yParent, xParent);
			rank.put(xParent, rank.get(xParent) + rank.get(yParent));
		} else {
			parent.put(xParent, yParent);
			rank.put(yParent, rank.get(xParent) + rank.get(yParent));
		}
	}
}
