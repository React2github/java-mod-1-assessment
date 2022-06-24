import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        int min = 0;
        int max = 10;
        int width = 100;
        int height = 20;

        // Buffered image
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("TimesNewRoman", Font.BOLD, 10));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("Guess the #", 20, 20);

        // Ascii Art section;

        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {

                sb.append(image.getRGB(x, y) == -16777216 ? " " : "#");

            }

            if (sb.toString().trim().isEmpty()) {
                continue;
            }

            System.out.println(sb);
        }

        // Game logic 

        Random random = new Random();
        int value = random.nextInt(max + min) + min;

        try (Scanner obj = new Scanner(System.in)) {
            System.out.println("Welcome Guest!");
            System.out.print("Do you want to play on easy(0), medium(1), or hard(2)? ");
            int userDifficulty = obj.nextInt();
            String[] Levels = {"easy", "medium", "hard"};
            System.out.println("You choose " + Levels[userDifficulty]);

            String[] Instructions = {
                    "User wins if you guess higher or same as Computer",
                    "User wins if you guess higher than Computer",
                    "User wins if you guess exactly as Computer" };

            System.out.println(Instructions[userDifficulty]);

            if (userDifficulty > 2 || userDifficulty < 0) {
                System.out.println("Pick a number within range!");
                return;
            }

            System.out.print("Pick a number (0-10): ");
            int userNumber = obj.nextInt();

            if (userNumber == value && userDifficulty == 0) {
                System.out.println("Your answer is the same. You Won!");
            } else if (userNumber == value && userDifficulty == 1) {
                System.out.println("Your answer is the same. Computer Wins!");
            } else if (userNumber < value) {
                System.out.println("Your answer was too low. Computer Wins!");
            } else if (userNumber > 10 && userNumber > value) {
                System.out.println("Number outside range");
            } else if (userNumber > value && userDifficulty == 2) {
                System.out.println("Your answer was too high. Computer Wins!");
            } else {
                System.out.println("Your answer was higher. You Win!");
            }
        } catch (Exception e) {
            System.out.println("Type a postive number within range!");
        }
    }
}
