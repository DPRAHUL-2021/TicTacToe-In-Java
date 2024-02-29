import java.util.Scanner;
public class TicTacToe 
{
    static char board[][] = new char[3][3];
    static char currentUser = 'X';
    public static void main(String[] args) 
    {
        initialization();
        printBoard();
        while(!checkBoardIsFull() && !findingWinner())
        {
            takingInput();
            printBoard();
            if (!findingWinner()) 
            {
                switchUser();   
            }
        }
        if(findingWinner())
        {
            System.out.println("Player "+currentUser+" Wins The Game");
        }
        else
        {
            System.out.println("The Game Is A Draw");
        }
    } 

    static void initialization()
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                board[i][j] = '_';   
            }
        }
    }

    static void printBoard()
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                System.out.print(board[i][j]+"\t"); 
            }
            System.out.println();
        }
        System.out.println();
    }

    static void takingInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player "+currentUser+" ,Make Your Move (Row space Column) : ");
        int rows = sc.nextInt();
        int column = sc.nextInt();
        while(rows < 0 || rows >= 3 || column < 0 || column >= 3 || board[rows][column] != '_' )
        {
            System.out.println("Invalid Input");
            System.out.println("Player "+currentUser+" ,Make Your Move Again (Row space Column) : ");
            rows = sc.nextInt();
            column = sc.nextInt();
        }
        board[rows][column] = currentUser;
    }

    static boolean checkBoardIsFull()
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j] == '_')
                {
                    return false;
                }   
            }
        }
        return true;
    }

    static boolean findingWinner()
    {
        for(int i=0;i<board.length;i++)
        {
            if(board[i][0] == currentUser && board[i][1] == currentUser && board[i][2] == currentUser)
            {
                return true;
            }
            if(board[0][i] == currentUser && board[1][i] == currentUser && board[2][i] == currentUser)
            {
                return true;
            } 
        }
        if(board[0][0] == currentUser && board[1][1] == currentUser && board[2][2] == currentUser)
        {
            return true;
        }
        if(board[0][2] == currentUser && board[1][1] == currentUser && board[2][0] == currentUser)
        {
            return true;
        }
        return false;
    }

    static void switchUser()
    {
        if(currentUser == 'X')
        {
            currentUser = 'O';
        }
        else
        {
            currentUser = 'X';
        }
    }
}