// Write a program to create quiz application.

import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "Which keyword is used to create a class in Java?",
            "Which method is the entry point of a Java program?",
            "Which of these data types stores decimal values?",
            "Which loop is guaranteed to execute at least once?",
            "Which symbol is used to end a statement in Java?"
        };

        String[][] options = {
            {"1. function", "2. class", "3. define", "4. object"},
            {"1. start()", "2. run()", "3. main()", "4. execute()"},
            {"1. int", "2. double", "3. char", "4. boolean"},
            {"1. for", "2. while", "3. do-while", "4. foreach"},
            {"1. ;", "2. :", "3. .", "4. #"}
        };

        int[] correctAnswers = {2, 3, 2, 3, 1};
        int score = 0;

        System.out.println("Welcome to the Quiz Application!");

        for (int i = 0; i < questions.length; i++) {
            System.out.println();
            System.out.println("Question " + (i + 1) + ": " + questions[i]);

            for (int j = 0; j < options[i].length; j++) {
                System.out.println(options[i][j]);
            }

            int userAnswer;

            while (true) {
                System.out.print("Enter your answer (1-4): ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid option number.");
                    sc.next();
                    continue;
                }

                userAnswer = sc.nextInt();

                if (userAnswer >= 1 && userAnswer <= 4) {
                    break;
                }

                System.out.println("Option must be between 1 and 4.");
            }

            if (userAnswer == correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong answer.");
            }
        }

        System.out.println();
        System.out.println("Quiz completed.");
        System.out.println("Your score is " + score + " out of " + questions.length + ".");

        if (score == questions.length) {
            System.out.println("Excellent performance!");
        } else if (score >= 3) {
            System.out.println("Good job!");
        } else {
            System.out.println("Keep practicing and try again.");
        }

        sc.close();
    }
}
