import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
	private static String player = "player";
	private static String computer = "computer";
	
	public static void main(String[] args) {
		
		    Scanner scanner = new Scanner(System.in);
			boolean check = true;
		    String turn ;
			int index ;
			char[] board=board();
			
			char userLetter=chooseLetter(scanner);
			char compLetter=(userLetter =='x')?'o' :'x';
			showBoard(board);
		    String firstPlayer=	firstPlayCheck();
			if(firstPlayer.equalsIgnoreCase(player)) {
				turn = player;
				System.out.println("Player  Turns First");
			}
			else {
				
				System.out.println("Computer Turns First");	
				turn =computer;
			}
			
		    
			do {
				if (turn.equalsIgnoreCase(player)) {
					index = indexChooser(board, scanner);
					valueAssign(index, board, userLetter);	
					check = checkWinAndTieCondition(board, userLetter);
					turn = computer;
				} 
				else {
					index = 9;
				board[index] = compLetter;
				showBoard(board);
				check = checkWinAndTieCondition(board, compLetter);
				turn = player;
				}
			} while (!check);
			showBoard(board);
		}	
		
		
		
	
	private static boolean checkWinAndTieCondition(char[] board, char userLetter) {
		boolean check;
		if ((board[1] == userLetter && board[2] == userLetter && board[3] == userLetter) || (board[4] == userLetter && board[5] == userLetter && board[6] == userLetter)
				|| (board[7] == userLetter && board[8] == userLetter && board[9] == userLetter)
				|| (board[1] == userLetter && board[4] == userLetter && board[7] == userLetter)
				|| (board[2] == userLetter && board[5] == userLetter && board[8] == userLetter)
				|| (board[3] == userLetter && board[6] == userLetter && board[9] == userLetter)
				|| (board[1] == userLetter && board[5] == userLetter && board[9] == userLetter)
				|| (board[3] == userLetter && board[5] == userLetter && board[7] == userLetter)) {
			check = true;
			System.out.println("Player Won");
		} else {
			int valid = 0;
			for (int index = 1; index < board.length; index++) {
				if (board[index] == ' ')
					valid++;
			}
			check = (valid == 9) ? (true) : (false);

		}
		return check;
		
	}




	static char[] board()
	{
		 char gameBoard[] = new char[10];
		for (int i = 0; i < gameBoard.length; i++) {
			
			gameBoard[i]= '\0';
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
	        return board[index] == '\0';
	    }
	    
	    private static String firstPlayCheck() {
			int toss = (int) (Math.random() * 10) % 2;
			return (toss == 0) ? (player) : (computer);
		}
	    
	    private static char[] valueAssign(int index, char[] board, char letter) {
			board[index] = letter;

			return board;
		}
	    
}
