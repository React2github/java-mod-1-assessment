import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            int min = 0;
            int max = 10;
    
            Random random = new Random();
            int value = random.nextInt(max+min)+min;
    
            Scanner obj = new Scanner(System.in);
            System.out.print("Pick a number (0-10): ");
            int userNumber = obj.nextInt();
    
    
            if(userNumber == value) {
                System.out.println("Your answer is the same. Tied!");
            }
            else if (userNumber < value) {
                System.out.println("Your answer was too low. Computer Wins!");
            } 
           else  if (userNumber > 10 && userNumber > value) {
                System.out.println("Number outside range");
            }
            else {
                System.out.println("Your answer was higher. You Win!");
            }
    }
}
