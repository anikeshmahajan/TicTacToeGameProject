import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {
		
			System.out.println("Welcome to Tic Tac Toe");
			TicTacToeGame game = new TicTacToeGame();
			board();
			char userLetter=chooseLetter();
			char compLetter=(userLetter =='x')?'o' :'x';
		
			
		}	
		
		
		
	
	static char[] board()
	{
		 char gameBoard[] = new char[10];
		for (int i = 0; i < gameBoard.length; i++) {
			
			gameBoard[i]= ' ';
	 }
		return gameBoard;
		}
	static char chooseLetter()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose the Letter o or x");
		char choosedLetter =scanner.next().toLowerCase().charAt(0);
		
		if(choosedLetter == 'o')
		{
			return choosedLetter;
		}
		else if(choosedLetter == 'x')
		{
			return choosedLetter;
		}
		return choosedLetter;
		
		
		
			
		
	}
	
}
