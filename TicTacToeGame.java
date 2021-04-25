import java.util.Scanner;

public class TicTacToeGame {
  
	public static void main(String[] args) {
		
		
			TicTacToeGame game = new TicTacToeGame();
			Scanner scanner = new Scanner(System.in);
			board();
			char userLetter=chooseLetter(scanner);
			char compLetter=(userLetter =='x')?'o' :'x';
			char[] c = board();
			showBoard(c);
			
			
		}	
		
		
		
	
	static char[] board()
	{
		 char gameBoard[] = new char[10];
		for (int i = 0; i < gameBoard.length; i++) {
			
			gameBoard[i]= ' ';
	 }
		return gameBoard;
		}
	static char chooseLetter(Scanner scanner)
	{
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
	 static void showBoard( char gameBoard[])
	{
		    System.out.println(" ");
	        System.out.println("\n "+ gameBoard[1] + " | "+ gameBoard[2] + " | " +gameBoard[3]);
	        System.out.println("---------");
	        System.out.println(" "+ gameBoard[4] + " | " + gameBoard[5] + " | " + gameBoard[6]);
	        System.out.println("---------");
	        System.out.println(" "+ gameBoard[7] + " | " + gameBoard[8] + " | " + gameBoard[9]);
	        System.out.println(" ");
	}
	 
	 
}
