import java.security.SecureRandom;
import java.util.Scanner;

public class Driver {
    public static final SecureRandom rng = new SecureRandom();


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Select the difficulty Level: 1-4");
            int difficultyLevel = input.nextInt();
            System.out.println("Select the problem type: 1-5");
            int problemType = input.nextInt();

            int count = 0;
            for (int i = 0; i < 10; i++) {
                Question current = Question.from(difficultyLevel, problemType);
                current.ask();
                double resp = input.nextDouble();
                if (current.isCorrect(resp)) {
                    count++;
                    System.out.println(getCorrectResp());
                } else System.out.println(getWrongResp());
            }
            double percentageRight = count * (1.0 / 10);
            System.out.println("Your percentage right was " + String.format("%.1f", percentageRight * 100) + "%!");
            if (percentageRight < .75)
                System.out.println("Please ask your teacher for extra help.");
            else
                System.out.println("Congratulations, you are ready to go to the next level!");
        }
    }

    public static String getCorrectResp() {
        switch (rng.nextInt(4)) {
            default:
            case 0:
                return "Very good!";
            case 1:
                return "Keep up the good work!";
            case 2:
                return "Nice work!";
            case 3:
                return "Excellent!";
        }
    }

    public static String getWrongResp() {
        switch (rng.nextInt(4)) {
            default:
            case 0:
                return "Never give up!";
            case 1:
                return "No. Please try again.";
            case 2:
                return "Wrong. Try once more.";
            case 3:
                return "No. Keep trying.!";
        }


    }
}