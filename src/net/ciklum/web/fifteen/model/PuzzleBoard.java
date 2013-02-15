package net.ciklum.web.fifteen.model;

import java.util.ArrayList;

public class PuzzleBoard {

	private ArrayList<PuzzleBoardTile> board;
	private boolean finished;
	private boolean modified;
	private int moves = 0;

	public PuzzleBoard() {
		board = new ArrayList<PuzzleBoardTile>();
		PuzzleBoardTile tile;
		for (int i = 0; i < 16; i++) {
			tile = new PuzzleBoardTile();
			if (i == 15) {
				tile.setV(0);
			} else {
				tile.setV(i + 1);
			}
			board.add(tile);
		}
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public ArrayList<PuzzleBoardTile> getBoard() {
		return board;
	}

	public void setBoard(ArrayList<PuzzleBoardTile> board) {
		this.board = board;
	}

}
