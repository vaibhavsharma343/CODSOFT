 

import java.util.Scanner; 
import java.util.Random;
 public class NumGame {
    public static void main(String ar[])
    {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
         int numtoguess = r.nextInt(101);
         int max_tries = 4; 
         int guess ;
         int score = 0 ;
         int numoftries = 0 ;
         boolean guesscorrect = false;
         System.out.println("wellcome to NUMBER GAME");
         System.out.println("You will get "+ max_tries + "to win the game" );
         System.out.println("guess the number between 1 to 100 only ");
         while(!guesscorrect &&  numoftries<max_tries) {
            System.out.println("enter your guessed number");
            guess = s.nextInt();
            numoftries++;
               
            if(guess < numtoguess){
                System.out.println("too low.. ,   plz try again");
            }
            else if(guess > numtoguess){
                System.out.println(" too high.. , try again ");
            }
            else {
                guesscorrect = true;
                score = 100 - (numoftries - 1)*15;
                System.out.println("You guessed number in " + numoftries + "tries");
                System.out.println("your score is " + score);
            } 
         }
         if(!guesscorrect){
            System.out.println("you out and ur score is 0");
            System.out.print("guessed number was" +numtoguess );

         }

    }

    
}
