import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {
		
		    Scanner scanner = new Scanner(System.in);
			
			 char[] board=board();
			char userLetter=chooseLetter(scanner);
			char compLetter=(userLetter =='x')?'o' :'x';
			
			showBoard(board);
		    int userMove=	indexChooser(board,scanner);
		    board[userMove]=userLetter;
		    showBoard(board);
			
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
	 static void showBoard( char board[])
	{
		    System.out.println(" ");
	        System.out.println("\n "+ board[1] + " | "+ board[2] + " | " +board[3]);
	        System.out.println("---------");
	        System.out.println(" "+ board[4] + " | " + board[5] + " | " + board[6]);
	        System.out.println("---------");
	        System.out.println(" "+ board[7] + " | " + board[8] + " | " + board[9]);
	        System.out.println(" ");
	}
	 
	 static int indexChooser(char board[],Scanner scanner)
	   {
	      
	        Integer[] validCells = {1, 2, 3, 4, 5, 6, 7, 8, 9};


	        while (true)
	        {
			System.out.println("What is your next move ? (1-9");
			int index = scanner.nextInt();
	            	if (Arrays.asList(validCells).contains(index) && isSpaceFree(board, index))
				
	            		return index;
		}

	    }
	    private static boolean isSpaceFree(char[] board, int index)
	    {
	        return board[index] == ' ';
	    }
}
