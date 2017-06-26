package datastructures.advanced.hard;

import java.util.Scanner;
import java.util.TreeMap;

public class CubeSummation {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuffer output = new StringBuffer();
		while (T-- != 0) {
			sc.nextInt();
			int M = sc.nextInt();
			TreeMap<String, Long> grid = new TreeMap<>();
			while (M-- != 0) {
				String operation = sc.next();
				if (operation.equals("UPDATE")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					int z = sc.nextInt();
					long W = sc.nextInt();
					String key = x + "-" + y + "-" + z;
					if (!grid.containsKey(key) && W != 0) {
						grid.put(key, W);
					} else {
						if (W == 0) {
							grid.remove(key);
						} else {
							grid.put(key, W);
						}
					}
				} else {
					int x1 = sc.nextInt();
					int y1 = sc.nextInt();
					int z1 = sc.nextInt();
					int x2 = sc.nextInt();
					int y2 = sc.nextInt();
					int z2 = sc.nextInt();
					long totalWeight = getSum(grid, x1, y1, z1, x2, y2, z2);
					output.append(totalWeight).append('\n');
				}
			}
		}
		System.out.println(output);
		sc.close();
	}

	public static long getSum(TreeMap<String, Long> grid, int x1, int y1, int z1, int x2, int y2, int z2) {
		long sum = 0;
		for (String key : grid.keySet()) {
			String[] coords = key.split("-");
			int x = Integer.parseInt(coords[0]);
			int y = Integer.parseInt(coords[1]);
			int z = Integer.parseInt(coords[2]);
			if (x1 <= x && x <= x2 && y1 <= y && y <= y2 && z1 <= z && z <= z2) {
				sum += grid.get(key);
			}
		}
		return sum;
	}
}
