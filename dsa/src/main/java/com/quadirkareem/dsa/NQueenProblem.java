package com.quadirkareem.dsa;
import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

	public static void main(String[] args) {
		List<Position> queens = solveNQueenProblem(6);
		System.out.println("======");
		System.out.println(queens);
	}

	/**
	 * @param n
	 * @return
	 */
	private static List<Position> solveNQueenProblem(int n) {
		List<Position> queenPos = new ArrayList<Position>();
		for (int i = 0; i < n; i++) {
			placeQueen(n, queenPos, Position.create(0, i));
			if (queenPos.size() == n) {
				break;
			}
			else {
				queenPos.clear();
			}
		}
		if (queenPos.size() == n) {
			return queenPos;
		} else {
			return null;
		}
	}

	private static void placeQueen(int n, List<Position> queenPos, Position position) {
		System.out.println(queenPos + ": " + position);
		if (n == 1) {
			queenPos.add(position);
		} else if (position != null) {
			boolean isAttacked = isAttacked(queenPos, position);
			if (!isAttacked) {
				queenPos.add(position);
				if (queenPos.size() != n && position.x != n - 1) {
					for (int i = 0; i < n; i++) {
						placeQueen(n, queenPos, Position.create(position.x + 1, i));
						if (queenPos.size() == n) {
							break;
						}
					}
				}
				if (queenPos.size() != n && queenPos.size() > 0) {
					queenPos.remove(queenPos.size() - 1);
				}
			}
		}
	}

	private static boolean isAttacked(List<Position> queenPos, Position position) {
		boolean isAttacked = false;
		for (int i = 0; i < queenPos.size(); i++) {
			isAttacked = position.isAttackedBy(queenPos.get(i));
			if (isAttacked) {
				break;
			}
		}
		return isAttacked;
	}

	private static class Position {
		private int x;
		private int y;

		static Position create(int i, int j) {
			return new Position(i, j);
		}

		private Position(int i, int j) {
			x = i;
			y = j;
		}

		Position getFromNextRow(int n) {
			if (x == (n - 1)) {
				return null;
			} else {
				return new Position(x + 1, 0);
			}
		}

		boolean isDiagonalWith(Position p) {
			return Math.abs(x - p.x) == Math.abs(y - p.y);
		}

		boolean isHorizontalWith(Position p) {
			if (p == null) {
				return false;
			}
			return x == p.x;
		}

		boolean isVerticalWith(Position p) {
			if (p == null) {
				return false;
			}
			return y == p.y;
		}

		boolean isAttackedBy(Position p) {
			return isDiagonalWith(p) || isHorizontalWith(p) || isVerticalWith(p);
		}

		@Override
		public boolean equals(Object p) {
			if (p == null || !(p instanceof Position)) {
				return false;
			}
			return x == ((Position) p).x && y == ((Position) p).y;
		}

		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}
}
