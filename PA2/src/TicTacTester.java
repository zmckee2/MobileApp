import java.util.Scanner;
public class TicTacTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe");
        System.out.println("When prompted to make a move, enter it in this format: \'row column\'");
        System.out.println("Make sure to add the space between the numbers");
        System.out.print("Please enter your board size (between 3 and 9 inclusive): ");
        int boardSize = input.nextInt();
        int maxMoves = boardSize * boardSize;
        int curMoves = 0;
        input.nextLine();

        TicTacToeBoard theBoard = new TicTacToeBoard(boardSize);
        boolean hasWinner = false;
        while(!hasWinner && curMoves < maxMoves)
        {
            boolean goodMove = false;
            while(!goodMove)
            {
                System.out.println(theBoard);
                System.out.print("Player O's move: ");
                String curInput = input.nextLine();
                while (curInput.length() != 3) {
                    System.out.println("Invalid input! Enter your input as \'row column\'.");
                    System.out.println("Make sure to include the space (e.g. \'1 1\')");
                    System.out.println(theBoard);
                    System.out.print("Player X's move: ");
                    curInput = input.nextLine();
                }
                int row = Integer.parseInt(curInput.substring(0, 1));
                int column = Integer.parseInt(curInput.substring(2));
                Coordinates curMove = new Coordinates(row, column);
                if(theBoard.isValidMove(curMove))
                {
                    goodMove = true;
                    theBoard.makeMove(curMove, 'O');
                    hasWinner = theBoard.isWinner('O');
                    curMoves++;
                }
                else
                {
                    System.out.println("Invaid move! That space is already taken or out of bounds");
                }
            }
            if(hasWinner || !(curMoves < maxMoves))
                break;
            goodMove = false;
            while(!goodMove)
            {
                System.out.println(theBoard);
                System.out.print("Player X's move: ");
                String curInput = input.nextLine();
                while (curInput.length() != 3) {
                    System.out.println("Invalid input! Enter your input as \'row column\'.");
                    System.out.println("Make sure to include the space (e.g. \'1 1\')");
                    System.out.println(theBoard);
                    System.out.print("Player X's move: ");
                    curInput = input.nextLine();
                }
                int row = Integer.parseInt(curInput.substring(0, 1));
                int column = Integer.parseInt(curInput.substring(2));
                Coordinates curMove = new Coordinates(row, column);
                if(theBoard.isValidMove(curMove))
                {
                    goodMove = true;
                    theBoard.makeMove(curMove, 'X');
                    hasWinner = theBoard.isWinner('X');
                    curMoves++;
                }
                else
                {
                    System.out.println("Invaid move! That space is already taken or out of bounds");
                }
            }
        }
        System.out.println(theBoard);
        if(theBoard.isWinner('X'))
        {
            System.out.println("Player 2 won!");
        }
        else if (theBoard.isWinner('O'))
        {
            System.out.println("Player 1 won!");
        }
        else
        {
            System.out.println("Too bad! Scratch game!");
        }

    }
}
