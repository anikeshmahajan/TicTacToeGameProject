import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {
		
		
			TicTacToeGame game = new TicTacToeGame();
			game.board();
			System.out.println(game.chooseLetter());
		}
		
		
		
	
	void board()
	{
		char gameBoard[] = new char[9];
		for (int i = 0; i < gameBoard.length; i++) {
			
			gameBoard[i]= '\0';
	}
		}
	String chooseLetter()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose the Letter o or x");
		String choosedLetter =scanner.next();
		if(choosedLetter.equalsIgnoreCase("o"))
		{
			return choosedLetter;
		}
		else if(choosedLetter.equalsIgnoreCase("x"))
		{
			return choosedLetter;
		}
		
			return " ";
		
	}
}
