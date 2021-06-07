package view;

import mod.Game;

public class Board {

	//Declares and initializes the icons for the board
	public static String _comp = "◼";
	public static String _ply = "◻";
	public static String _bspace = " X";
	private final String _space = "   ";
	private Game _maze;
	
	//Creates a board constructor 
	public Board(Game m) {
		_maze = m;

	}
	
	//Generates the board, changing the icon to represent each user and their piece
	public String generateGame() {
		 String map = "";
		 for(int r = 0; r < _maze.getMaze().length; r++) {
			 for(int c = 0; c < _maze.getMaze()[0].length; c++) {
				 if(_maze.getMaze()[r][c] == 2) {
					 map += _ply + _space;
				 }
				 else if(_maze.getMaze()[r][c] == 1) {
					 map += _comp + _space;
				 }
				 else {
					map += _bspace + _space; 
				 }
			 }
			 map += "\n";
		 }
		 map += "\n";
		
		 return map;
	}
	
}