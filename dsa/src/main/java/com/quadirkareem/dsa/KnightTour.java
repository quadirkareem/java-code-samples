package com.quadirkareem.dsa;
import java.util.ArrayList;
import java.util.List;

public class KnightTour {

	private static int SIZE = 8;
	private static int TOTAL_MOVES = SIZE * SIZE;

	public static void main(String[] args) {
		Knight k = new Knight(0, 0);

		List<Knight> path = new ArrayList<Knight>();
		path.add(k);
		tourBoard(path, k);
		System.out.println(path);
		System.out.println(path.size());
	}

	private static void tourBoard(List<Knight> path, Knight k) {
		//System.out.println(path);
		List<Knight> moves = k.getNextMoves();
		for (Knight d : moves) {
			if (!path.contains(d)) {
				path.add(d);
				if (path.size() == TOTAL_MOVES) {
					break;
				}
				tourBoard(path, d);
			}
		}
		if (path.size() < TOTAL_MOVES) {
			path.remove(path.size()-1);
		}
		
	}

	private static class Knight {
		private int x;
		private int y;

		private static final Knight[] DELTA_POS = { new Knight(-2, -1), new Knight(-2, 1), new Knight(-1, -2),
				new Knight(-1, 2), new Knight(1, -2), new Knight(1, 2), new Knight(2, -1), new Knight(2, 1) };

		Knight(int i, int j) {
			x = i;
			y = j;
		}

		// 0
		List<Knight> getNextMoves() {
			List<Knight> nextMoves = new ArrayList<Knight>();
			for (Knight d : DELTA_POS) {
				Knight k = getNext(d);
				if (isValid(k)) {
					nextMoves.add(k);
				}
			}
			return nextMoves;
		}

		private Knight getNext(Knight delta) {
			return new Knight(x + delta.x, y + delta.y);
		}

		private boolean isValid(Knight k) {
			return k.x >= 0 && k.x < SIZE && k.y >= 0 && k.y < SIZE;
		}

		@Override
		public boolean equals(Object k) {
			if (k == null || !(k instanceof Knight)) {
				return false;
			}
			return x == ((Knight) k).x && y == ((Knight) k).y;
		}

		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}

	}
}
