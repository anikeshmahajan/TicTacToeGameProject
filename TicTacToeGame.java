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
					index = computerTurn(board, compLetter, userLetter);
					valueAssign(index, board, compLetter);
				showBoard(board);
				check = checkWinAndTieCondition(board, compLetter);
				turn = player;
				}
			} while (!check);
			showBoard(board);
		}	
		
		
		
	
	private static boolean checkWinAndTieCondition(char[] board, char letter) {
		boolean check;
		if ((board[1] == letter && board[2] == letter && board[3] == letter) || (board[4] == letter && board[5] == letter && board[6] == letter)
				|| (board[7] == letter && board[8] == letter && board[9] == letter)
				|| (board[1] == letter && board[4] == letter && board[7] == letter)
				|| (board[2] == letter && board[5] == letter && board[8] == letter)
				|| (board[3] == letter && board[6] == letter && board[9] == letter)
				|| (board[1] == letter && board[5] == letter && board[9] == letter)
				|| (board[3] == letter && board[5] == letter && board[7] == letter)) {
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
	    
	    private static int checkingWinningMove(char[] board, char letter) {
			int index;
			index = checkingWinningLine(1, 2, 3, board, letter);
			if (index == 0)
				index = checkingWinningLine(4, 5, 6, board, letter);
			if (index == 0)
				index = checkingWinningLine(7, 8, 9, board, letter);
			if (index == 0)
				index = checkingWinningLine(1, 4, 7, board, letter);
			if (index == 0)
				index = checkingWinningLine(2, 5, 6, board, letter);
			if (index == 0)
				index = checkingWinningLine(3, 6, 9, board, letter);
			if (index == 0)
				index = checkingWinningLine(1, 5, 9, board, letter);
			if (index == 0)
				index = checkingWinningLine(3, 5, 7, board, letter);
			return index;
		}

		private static int checkingWinningLine(int a, int b, int c, char[] board, char letter) {
			int index = 0;
			if ((board[a] == letter && board[b] == letter) || (board[b] == letter && board[c] == letter)
					|| (board[a] == letter && board[c] == letter)) {

				if ((board[a] == ' ') || (board[b] == ' ') || (board[c] == ' ')) {
					if ((board[a] == ' '))
						index = a;
					if ((board[b] == ' '))
						index = b;
					if ((board[c] == ' '))
						index = c;
				}

			}
			return index;
		}
		private static int computerTurn(char[] board, char compLetter, char userLetter) {
			int index = 0;
			index = checkingWinningMove(board, compLetter);
			if (index == 0)
				index = checkingWinningMove(board, userLetter);
			return index;
		}
		

	
	    
}
