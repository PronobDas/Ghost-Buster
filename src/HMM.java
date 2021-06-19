import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class HMM {
    static int N = 6;
    static int ghostX = (new Random()).nextInt(N); // row
    static int ghostY = (new Random()).nextInt(N); // col

    public static void timeAdvanced(double[][] grid)
    {
        double rand = (new Random()).nextDouble() * 100;

        if (rand <= 4.0)
        {
            if (ghostX > 0 && ghostX < N-1 && ghostY > 0 && ghostY < N-1)
            {
                if (rand <= 0.8){
                    ghostX--;
                    ghostY--;
                }
                else if (rand <= 1.6){
                    ghostX++;
                    ghostY--;
                }
                else if (rand <= 2.4){
                    ghostX--;
                    ghostY++;
                }
                else if (rand <= 3.2) {
                    ghostX++;
                    ghostY++;
                }
            }
            else if (ghostX == 0 && ghostY == 0)
            {
                if (rand <= 2){
                    ghostX++;
                    ghostY++;
                }
            }
            else if (ghostX == 0 && ghostY == N-1)
            {
                if (rand <= 2){
                    ghostX--;
                    ghostY--;
                }
            }
            else if (ghostX == N-1 && ghostY == 0)
            {
                if (rand <= 2){
                    ghostX--;
                    ghostY++;
                }
            }
            else if (ghostX == N-1 && ghostY == N-1)
            {
                if (rand <= 2){
                    ghostX--;
                    ghostY--;
                }
            }
            else if (ghostX == 0)
            {
                if (rand <= 1.333){
                    ghostY--;
                    ghostX++;
                }
                else if (rand <= 2.66){
                    ghostY++;
                    ghostX++;
                }
            }
            else if (ghostX == N-1)
            {
                if (rand <= 1.333){
                    ghostY--;
                    ghostX--;
                }
                else if (rand <= 2.66){
                    ghostY++;
                    ghostX--;
                }
            }
            else if (ghostY == 0)
            {
                if (rand <= 1.333){
                    ghostY++;
                    ghostX++;
                }
                else if (rand <= 2.66){
                    ghostY++;
                    ghostX--;
                }
            }
            else if (ghostY == N-1)
            {
                if (rand <= 1.333){
                    ghostY--;
                    ghostX--;
                }
                else if (rand <= 2.66){
                    ghostY--;
                    ghostX++;
                }
            }
        }
        else
        {
            if (ghostX > 0 && ghostX < N-1 && ghostY > 0 && ghostY < N-1)
            {
                if (rand <= 28)
                    ghostX--;
                else if (rand <= 52)
                    ghostX++;
                else if (rand <= 76)
                    ghostY--;
                else
                    ghostY++;
            }
            else if (ghostX == 0 && ghostY == 0)
            {
                if (rand <= 52)
                    ghostX++;
                else
                    ghostY++;
            }
            else if (ghostX == 0 && ghostY == N-1)
            {
                if (rand <= 52)
                    ghostX++;
                else
                    ghostY--;
            }
            else if (ghostX == N-1 && ghostY == 0)
            {
                if (rand <= 52)
                    ghostX--;
                else
                    ghostY++;
            }
            else if (ghostX == N-1 && ghostY == N-1)
            {
                if (rand <= 52)
                    ghostX--;
                else
                    ghostY--;
            }
            else if (ghostX == 0)
            {
                if (rand <= 36)
                    ghostX++;
                else if (rand <= 68)
                    ghostY++;
                else
                    ghostY--;
            }
            else if (ghostX == N-1)
            {
                if (rand <= 36)
                    ghostX--;
                else if (rand <= 68)
                    ghostY++;
                else
                    ghostY--;
            }
            else if (ghostY == 0)
            {
                if (rand <= 36)
                    ghostY++;
                else if (rand <= 68)
                    ghostX++;
                else
                    ghostX--;
            }
            else if (ghostY == N-1)
            {
                if (rand <= 36)
                    ghostY--;
                else if (rand <= 68)
                    ghostX++;
                else
                    ghostX--;
            }
        }

        //System.out.println(ghostX+"  "+ghostY);
        double temp[][] = new double[N][N]; //copy of the previous values.
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                temp[i][j] = grid[i][j];

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if ( i == 0 ) // first row
                {
                    if(j == 0)
                        grid[i][j] = 0.32*temp[i][j+1] + 0.32*temp[i+1][j] + 0.008*temp[i+1][j+1] + 0.02*temp[i][j];   //0,0
                    else if(j == 1)
                        grid[i][j] = 0.48*temp[i][j-1] + 0.32*temp[i][j+1] + 0.24*temp[i+1][j] + 0.013*temp[i+1][j-1] +0.008*temp[i+1][j+1] + 0.013*temp[i][j];
                    else if (j == N-2)
                        grid[i][j] = 0.48*temp[i][j+1] + 0.32*temp[i][j-1] + 0.24*temp[i+1][j] + 0.013*temp[i+1][j+1] +0.008*temp[i+1][j-1] + 0.013*temp[i][j];
                    else if (j == N-1)
                        grid[i][j] = 0.32*temp[i][j-1] + 0.32*temp[i+1][j] + 0.008*temp[i+1][j-1] + 0.02*temp[i][j]; // 0,N-1
                    else
                        grid[i][j] = 0.32*temp[i][j-1] + 0.32*temp[i][j+1] + 0.24*temp[i+1][j] + 0.008*temp[i+1][j-1] + 0.008*temp[i+1][j+1] + 0.13*temp[i][j];
                }
                else if (i == 1) // second
                {
                    if(j == 0)
                        grid[i][j] = 0.24*temp[i][j+1] + 0.32*temp[i+1][j] +0.48*temp[i-1][j] + 0.008*temp[i+1][j+1] + 0.013*temp[i-1][j+1]+ 0.013*temp[i][j];   //0,0
                    else if(j == 1)
                        grid[i][j] = 0.32*temp[i][j-1] + 0.24*temp[i][j+1] + 0.24*temp[i+1][j] +0.32*temp[i-1][j] + 0.013*temp[i+1][j-1] +0.008*temp[i+1][j+1] +0.02*temp[i-1][j-1]+ 0.013*temp[i-1][j+1] + 0.008*temp[i][j];
                    else if (j == N-2)
                        grid[i][j] = 0.24*temp[i][j-1] + 0.32*temp[i][j+1] + 0.24*temp[i+1][j] +0.32*temp[i-1][j] + 0.008*temp[i+1][j-1] +0.013*temp[i+1][j+1] +0.013*temp[i-1][j-1]+ 0.02*temp[i-1][j+1] + 0.008*temp[i][j];
                    else if (j == N-1)
                        grid[i][j] = 0.24*temp[i][j-1] + 0.32*temp[i+1][j] +0.48*temp[i-1][j] + 0.008*temp[i+1][j-1] + 0.013*temp[i-1][j-1]+ 0.013*temp[i][j]; // 0,N-1
                    else
                        grid[i][j] = 0.24*temp[i][j-1] + 0.24*temp[i][j+1] + 0.24*temp[i+1][j] +0.32*temp[i-1][j] + 0.008*temp[i+1][j-1] +0.008*temp[i+1][j+1] +0.013*temp[i-1][j-1]+ 0.013*temp[i-1][j+1] + 0.008*temp[i][j];
                }
                else if (i == N-2) //second last row
                {
                    if(j == 0)
                        grid[i][j] = 0.24*temp[i][j+1] + 0.48*temp[i+1][j] +0.32*temp[i-1][j] + 0.013*temp[i+1][j+1] + 0.008*temp[i-1][j+1]+ 0.013*temp[i][j];   //0,0
                    else if(j == 1)
                        grid[i][j] = 0.32*temp[i][j-1] + 0.24*temp[i][j+1] + 0.32*temp[i+1][j] +0.24*temp[i-1][j] + 0.02*temp[i+1][j-1] +0.013*temp[i+1][j+1] +0.013*temp[i-1][j-1]+ 0.008*temp[i-1][j+1] + 0.008*temp[i][j];
                    else if (j == N-2)
                        grid[i][j] = 0.24*temp[i][j-1] + 0.32*temp[i][j+1] + 0.32*temp[i+1][j] +0.24*temp[i-1][j] + 0.013*temp[i+1][j-1] +0.02*temp[i+1][j+1] +0.008*temp[i-1][j-1]+ 0.013*temp[i-1][j+1] + 0.008*temp[i][j];
                    else if (j == N-1)
                        grid[i][j] = 0.24*temp[i][j-1] + 0.48*temp[i+1][j] +0.32*temp[i-1][j] + 0.013*temp[i+1][j-1] + 0.008*temp[i-1][j-1]+ 0.013*temp[i][j]; // 0,N-1
                    else
                        grid[i][j] = 0.24*temp[i][j-1] + 0.24*temp[i][j+1] + 0.32*temp[i+1][j] +0.24*temp[i-1][j] + 0.013*temp[i+1][j-1] +0.013*temp[i+1][j+1] +0.008*temp[i-1][j-1]+ 0.008*temp[i-1][j+1] + 0.008*temp[i][j];
                }
                else if (i == N-1) // last row
                {
                    if(j == 0)
                        grid[i][j] = 0.32*temp[i][j+1] + 0.32*temp[i-1][j] + 0.008*temp[i-1][j+1] + 0.02*temp[i][j];   //0,0
                    else if(j == 1)
                        grid[i][j] = 0.48*temp[i][j-1] + 0.32*temp[i][j+1] + 0.24*temp[i-1][j] + 0.013*temp[i-1][j-1] +0.008*temp[i-1][j+1] + 0.013*temp[i][j];
                    else if (j == N-2)
                        grid[i][j] = 0.48*temp[i][j+1] + 0.32*temp[i][j-1] + 0.24*temp[i-1][j] + 0.013*temp[i-1][j+1] +0.008*temp[i-1][j-1] + 0.013*temp[i][j];
                    else if (j == N-1)
                        grid[i][j] = 0.32*temp[i][j-1] + 0.32*temp[i-1][j] + 0.008*temp[i-1][j-1] + 0.02*temp[i][j]; // 0,N-1
                    else
                        grid[i][j] = 0.32*temp[i][j-1] + 0.32*temp[i][j+1] + 0.24*temp[i-1][j] + 0.008*temp[i-1][j-1] + 0.008*temp[i-1][j+1] + 0.13*temp[i][j];
                }
                else // middle rows
                {
                    if(j == 0)
                        grid[i][j] = 0.24*temp[i][j+1] + 0.32*temp[i+1][j] +0.32*temp[i-1][j] + 0.008*temp[i+1][j+1] + 0.008*temp[i-1][j+1]+ 0.013*temp[i][j];   //0,0
                    else if(j == 1)
                        grid[i][j] = 0.32*temp[i][j-1] + 0.24*temp[i][j+1] + 0.24*temp[i+1][j] +0.24*temp[i-1][j] + 0.013*temp[i+1][j-1] +0.008*temp[i+1][j+1] +0.013*temp[i-1][j-1]+ 0.008*temp[i-1][j+1] + 0.008*temp[i][j];
                    else if (j == N-2)
                        grid[i][j] = 0.24*temp[i][j-1] + 0.32*temp[i][j+1] + 0.24*temp[i+1][j] +0.24*temp[i-1][j] + 0.008*temp[i+1][j-1] +0.013*temp[i+1][j+1] +0.008*temp[i-1][j-1]+ 0.013*temp[i-1][j+1] + 0.008*temp[i][j];
                    else if (j == N-1)
                        grid[i][j] = 0.24*temp[i][j-1] + 0.32*temp[i+1][j] +0.32*temp[i-1][j] + 0.008*temp[i+1][j-1] + 0.008*temp[i-1][j-1]+ 0.013*temp[i][j]; // 0,N-1
                    else
                        grid[i][j] = 0.24*temp[i][j-1] + 0.24*temp[i][j+1] + 0.24*temp[i+1][j] +0.24*temp[i-1][j] + 0.008*temp[i+1][j-1] +0.008*temp[i+1][j+1] +0.008*temp[i-1][j-1]+ 0.008*temp[i-1][j+1] + 0.008*temp[i][j];
                }
            }
        }
    }

    public static void observe(double[][] grid, int x, int y)
    {
        System.out.println("After observation at ("+x+","+y+"):");
        int dist = getDistance(grid, x, y);
        if (dist <= 2)
        {
            System.out.println("RED.");
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    int temp = Math.abs(i-x) + Math.abs(j-y);
                    if (temp > 2)
                        grid[i][j] = 0;
                }
            }
        }
        else if (dist <= 4)
        {
            System.out.println("ORANGE.");
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    int temp = Math.abs(i-x) + Math.abs(j-y);
                    if (temp > 4 || temp <= 2)
                        grid[i][j] = 0;
                }
            }
        }
        else
        {
            System.out.println("GREEN.");
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    int temp = Math.abs(i-x) + Math.abs(j-y);
                    if (temp <= 4)
                        grid[i][j] = 0;
                }
            }
        }
        normalize(grid);
    }

    public static int getDistance(double[][] grid, int x, int y) //manhattan distance
    {
        return Math.abs(x - ghostX) + Math.abs(y - ghostY);
    }

    public static void normalize(double[][] grid)
    {
        float sum = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                sum += grid[i][j];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = grid[i][j]/sum;
    }


    public static void print(double[][] grid)
    {
        DecimalFormat df = new DecimalFormat("#.###");
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (grid[i][j] == 0)
                    System.out.print("-----     ");
                else
                    System.out.print(df.format(grid[i][j]) +"     ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double board[][] = new double[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = 1.0/(N*N);
        print(board);

        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n\nWhat do you want to do now? (1 to Time_Advance, 2 to OBSERVE, 3 to Catch the_Ghost)");
            System.out.print("Your Input:");

            int input = scanner.nextInt();
            if (input == 1)
            {
                timeAdvanced(board);
                System.out.println("After Time Advancement:");
                print(board);
            }
            else if (input == 2)
            {
                int temp1, temp2;
                System.out.print("Enter position (row col): ");
                temp1 = scanner.nextInt();
                temp2 = scanner.nextInt();
                while (temp1 < 0 || temp1 >= N)
                {
                    System.out.print("Enter a valid input of row: ");
                    temp1 = scanner.nextInt();
                }
                while (temp2 < 0 || temp2 >= N)
                {
                    System.out.print("Enter a valid input of col: ");
                    temp2 = scanner.nextInt();
                }

                observe(board, temp1, temp2);
                print(board);
            }
            else
            {
                int temp1, temp2;
                System.out.print("Enter position (row col): ");
                temp1 = scanner.nextInt();
                temp2 = scanner.nextInt();
                while (temp1 < 0 || temp1 >= N)
                {
                    System.out.print("Enter a valid input of row: ");
                    temp1 = scanner.nextInt();
                }
                while (temp2 < 0 || temp2 >= N)
                {
                    System.out.print("Enter a valid input of col: ");
                    temp2 = scanner.nextInt();
                }

                if (temp1 == ghostX && temp2 == ghostY)
                {
                    System.out.println("Congrats, That's a hit.");
                    System.out.println("Good Job. See you again.");
                    break;
                }
                else
                    System.out.println("Sorry, You Failed.\nBetter Luck Next Time.");
            }
        }
    }
}
