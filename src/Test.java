import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int N = 6;
        int ghostX = 0, ghostY = 0;
        double d=2343.5476;
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println(df.format(d));

       for (int i = 0; i < 100; i++)
       {
           Random rand1 = new Random();
           double rand = rand1.nextDouble() * 100;

           //System.out.println(rand);
           if (rand <= 4.0)
           {
               if (ghostX > 0 && ghostX < N-1 && ghostY > 0 && ghostY < N-1)
               {
                   if (rand < 0.8){
                       ghostX--;
                       ghostY--;
                   }
                   else if (rand < 1.6){
                       ghostX++;
                       ghostY--;
                   }
                   else if (rand < 2.4){
                       ghostX--;
                       ghostY++;
                   }
                   else if (rand < 3.2) {
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
                   if (rand <=1.333){
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
                   if (rand <=1.333){
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
                   if (rand <=1.333){
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
                   if (rand <=1.333){
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
                   if (rand < 28)
                       ghostX--;
                   else if (rand < 52)
                       ghostX++;
                   else if (rand < 76)
                       ghostY--;
                   else
                       ghostY++;
               }
               else if (ghostX == 0 && ghostY == 0)
               {
                   if (rand < 52)
                       ghostX++;
                   else
                       ghostY++;
               }
               else if (ghostX == 0 && ghostY == N-1)
               {
                   if (rand < 52)
                       ghostX++;
                   else
                       ghostY--;
               }
               else if (ghostX == N-1 && ghostY == 0)
               {
                   if (rand < 52)
                       ghostX--;
                   else
                       ghostY++;
               }
               else if (ghostX == N-1 && ghostY == N-1)
               {
                   if (rand < 52)
                       ghostX--;
                   else
                       ghostY--;
               }
               else if (ghostX == 0)
               {
                   if (rand <36)
                       ghostX++;
                   else if (rand < 68)
                       ghostY++;
                   else
                       ghostY--;
               }
               else if (ghostX == N-1)
               {
                   if (rand <36)
                       ghostX--;
                   else if (rand < 68)
                       ghostY++;
                   else
                       ghostY--;
               }
               else if (ghostY == 0)
               {
                   if (rand <36)
                       ghostY++;
                   else if (rand < 68)
                       ghostX++;
                   else
                       ghostX--;
               }
               else if (ghostY == N-1)
               {
                   if (rand <36)
                       ghostY--;
                   else if (rand < 68)
                       ghostX++;
                   else
                       ghostX--;
               }
           }

           System.out.println(ghostX +" "+ ghostY);
       }







    }
}
