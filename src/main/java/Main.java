import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            int min = 0;
            int max = 10;
    
            Random random = new Random();
            int value = random.nextInt(max+min)+min;
    
            try(Scanner obj = new Scanner(System.in)) {
            System.out.print("Do you want to play easy, medium, or hard? (1-3) ");
            int userDifficulty = obj.nextInt();

            if(userDifficulty > 3 || userDifficulty < 1) {
                System.out.println("Pick a number within range!");
                return;
            }

            System.out.print("Pick a number (0-10): ");
            int userNumber = obj.nextInt();
            
            if(userNumber == value && userDifficulty == 1) {
                System.out.println("Your answer is the same. You Won!");
            }
            else if (userNumber == value && userDifficulty == 2) {
                System.out.println("Your answer is the same. Computer Wins!");
            }
            else if (userNumber < value) {
                System.out.println("Your answer was too low. Computer Wins!");
            } 
           else  if (userNumber > 10 && userNumber > value) {
                System.out.println("Number outside range");
            }
            else if(userNumber > value && userDifficulty == 3) {
                System.out.println("Your answer was too high. Computer Wins!");
            }
            else {
                System.out.println("Your answer was higher. You Win!");
            }
        }
        catch(Exception e) {
            System.out.println("Make sure you type in a number!");
        }
    }
}
