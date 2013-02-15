package net.ciklum.web.fifteen.model;

import java.util.ArrayList;
import java.util.Collections;

public class PuzzleGame {

	private PuzzleBoard board;

	public PuzzleGame(PuzzleBoard board) {
		this.board = board;
	}

	public void start() {
		Collections.shuffle(board.getBoard());
		fillCanMove();
		board.setModified(true);
	}

	public int findnumber(ArrayList<PuzzleBoardTile> board, int strtofind) {
		for (int i = 0; i < 16; i++) {
			if (board.get(i).getV() == strtofind) {
				return i;
			}
		}
		return 0;
	}

	public boolean movetile(int value) {
		if (board.isFinished()) {
			return false;
		}
		ArrayList<PuzzleBoardTile> aboard = board.getBoard();
		int position = findnumber(aboard, value);
		int empty = findnumber(aboard, 0);
		if (canmove(position, empty)) {

			PuzzleBoardTile temp = aboard.get(empty);
			aboard.set(empty, aboard.get(position));
			aboard.set(position, temp);
			board.setBoard(aboard);
			board.setModified(true);
			board.setMoves(board.getMoves() + 1);
			fillCanMove();
			checksolution();
			return true;
		} else {
			return false;
		}
	}

	private void fillCanMove() {
		ArrayList<PuzzleBoardTile> aboard = board.getBoard();
		int empty = findnumber(aboard, 0);
		for (int i = 0; i < 16; i++) {
				aboard.get(i).setCanmove(canmove(i,empty));
		}
	}

	public boolean canmove(int from, int to) {
		if (((to == from + 1) && (from % 4 != 3)) || ((to == from - 1) && (from % 4 != 0)) || (to == from - 4) || (to == from + 4)) {
			return true;
		}
		return false;
	}

	protected void checksolution() {
		ArrayList<PuzzleBoardTile> aboard = board.getBoard();
		if (aboard.get(15).getV() != 0) {
			board.setFinished(false);
			return;
		}
		for (int i = 0; i < 15; i++) {
			if (aboard.get(i).getV() != i + 1) {
				board.setFinished(false);
				return;
			}
		}
		board.setFinished(true);
	}

}
