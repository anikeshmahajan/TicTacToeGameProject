import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
	private static String player = "player";
	private static String computer = "computer";
	
	public static void main(String[] args) {
		
		   System.out.println("Welcome To TicTacToe Game");
		   Scanner scanner = new Scanner(System.in);
		   boolean check = true;
		   String turn ;
		   int index ;
		   char compLetter;
		   int newGame;
		 
		   
		   do{
			  char[] board=board();
	
			 char userLetter = chooseLetter(scanner);
			 compLetter = (userLetter =='x')  ?  (compLetter ='o') : (compLetter = 'x');
			 showBoard(board);
		    
			if(firstPlayCheck().equalsIgnoreCase(player)) {
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
					showBoard(board);
					check = checkWinAndTieCondition(board, userLetter,player);
					turn = computer;
				} 
				else {
					System.out.println("Computer Chance  \n");
					index = computerTurn(board, compLetter, userLetter);
					valueAssign(index, board, compLetter);
				    showBoard(board);
				    check = checkWinAndTieCondition(board, compLetter,computer);
				    turn = player;
				}
			} while (!check);
			System.out.println(" <------------------------>");
			System.out.println("Do you want play another GAME.\n" + "Enter 1 to play again \n" + "Enter 2  to Quit" );
			newGame = scanner.nextInt();
			scanner.nextLine();
		} while (newGame == 1);
}
			
		
		
		
	
	private static boolean checkWinAndTieCondition(char[] board, char letter, String user) {
		boolean check;
		if ((board[1] == letter && board[2] == letter && board[3] == letter) || (board[4] == letter && board[5] == letter && board[6] == letter)
				|| (board[7] == letter && board[8] == letter && board[9] == letter)
				|| (board[1] == letter && board[4] == letter && board[7] == letter)
				|| (board[2] == letter && board[5] == letter && board[8] == letter)
				|| (board[3] == letter && board[6] == letter && board[9] == letter)
				|| (board[1] == letter && board[5] == letter && board[9] == letter)
				|| (board[3] == letter && board[5] == letter && board[7] == letter)) {
			if(user.equalsIgnoreCase(player))
			{
				System.out.println("!!!......You Have Won the game......!!!!");
			}else
			{
				System.out.println("!!.....You Lost the game....!!!!!!!");
			}
			check = true;
			
		} else {
			int valid = 0;
			for (int index = 1; index < board.length; index++) {
				if (board[index] == ' ')
					valid++;
			}
			check = (valid == 9) ? (true) : (false);
			if(check)
			{
				System.out.println("Game Tie .......!!!!!");
			}
		}
		return check;
		
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
		        return board[index] ==  ' ';
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
				if (index == 0);
				
					index = checkcorner(board, compLetter);
				if (index == 0)
					index = checkingCenter_Sides(board, compLetter);
				return index;
				
			}
			
	
			private static int checkcorner(char[]board,char compLetter) {
				int index=0;
				if(board[1]==' ') index=1;
				if(board[3]==' ') index=3;
				if(board[7]==' ') index=7;
				if(board[9]==' ') index=9;
				return index;
			}
			
			
			private static int checkingCenter_Sides(char[] board, char compLetter) {
				int index = 0;
				if (board[5] == ' ')
					index = 5;
				else {
					if (board[2] == ' ')
						index = 2;
					if (board[4] == ' ')
						index = 4;
					if (board[6] == ' ')
						index = 6;
					if (board[8] == ' ')
						index = 8;
				}
	
				return index;
			}
		    
}
