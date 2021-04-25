import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {
		
			System.out.println("Welcome to Tic Tac Toe");
			TicTacToeGame game = new TicTacToeGame();
			board();
			
			
		}	
		
		
		
	
	static char[] board()
	{
		 char gameBoard[] = new char[10];
		for (int i = 0; i < gameBoard.length; i++) {
			
			gameBoard[i]= ' ';
	 }
		return gameBoard;
		}
	
}
