package datastructures.queues.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class CastleOnTheGrid {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] grid = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = str.charAt(j);
			}
		}

		String[] inputs = br.readLine().split(" ");
		int startX = Integer.parseInt(inputs[0]);
		int startY = Integer.parseInt(inputs[1]);
		Point startPosition = new Point(startX, startY);
		int endX = Integer.parseInt(inputs[2]);
		int endY = Integer.parseInt(inputs[3]);
		Point endPosition = new Point(endX, endY);

		System.out.println(moveCastle(grid, startPosition, endPosition));
	}

	static ArrayList<Point> getAdjacentPoints(int[][] grid, Point startPosition) {
		ArrayList<Point> points = new ArrayList<>();

		int x = startPosition.getX();
		int y = startPosition.getY();

		while (x > 0) {
			x--;
			if (grid[x][y] == 'X') {
				break;
			}
			points.add(new Point(x, y));
		}

		x = startPosition.getX();
		while (x < grid[0].length - 1) {
			x++;
			if (grid[x][y] == 'X') {
				break;
			}
			points.add(new Point(x, y));
		}

		x = startPosition.getX();
		while (y > 0) {
			y--;
			if (grid[x][y] == 'X') {
				break;
			}
			points.add(new Point(x, y));
		}

		y = startPosition.getY();
		while (y < grid[0].length - 1) {
			y++;
			if (grid[x][y] == 'X') {
				break;
			}
			points.add(new Point(x, y));
		}

		return points;
	}

	static int moveCastle(int[][] grid, Point startPosition, Point endPosition) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(startPosition);
		grid[startPosition.getX()][startPosition.getY()] = 0;

		while (!queue.isEmpty()) {
			Point currentPosition = queue.poll();
			int currentDistance = grid[currentPosition.getX()][currentPosition.getY()];
			for (Point point : getAdjacentPoints(grid, currentPosition)) {
				if (grid[point.getX()][point.getY()] == '.') {
					grid[point.getX()][point.getY()] = currentDistance + 1;
					queue.offer(point);
					if (point.getX() == endPosition.getX() && point.getY() == endPosition.getY()) {
						return currentDistance + 1;
					}
				}
			}
		}

		return -1;
	}

	static class Point {

		private int x;
		private int y;

		public Point() {
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}
	}
}
