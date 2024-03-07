import ExpressionGenerator.Expression;
import Expressions.Infix;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Infix to Prefix and Postfix practice");
        System.out.println("From (easy) 1 to 5 (hard) select your difficulty level: ");
        int difficultyLevel = scanner.nextInt();

        System.out.println("What would you like to practice? Postfix, Prefix or BOTH? ");
        String practiceSelection = scanner.next().toLowerCase();

        String expression;
        String solution;
        int maxLength;
        int maxDepth;
        Infix infixExpression;
        while (scanner.hasNextLine()) {
            maxLength = difficultyLevel > 1 ? random.nextInt(1, difficultyLevel) * 2 : 2;
            maxDepth = difficultyLevel > 1 ? random.nextInt(1, difficultyLevel) : 1;
            expression = new Expression(maxLength, maxDepth).getExpression();
            System.out.println("Here is your expression: " + expression);

            infixExpression = new Infix(expression);
            if (practiceSelection.equals("both") || practiceSelection.equals("postfix")) {
                System.out.println("Please type your Postfix solution: ");
                solution = scanner.next();
                solution = solution.replaceAll("\\s", "");
                if (solution.equals(infixExpression.toPostfix())) {
                    System.out.println("Correct");
                } else {
                    System.out.println("Incorrect");
                    System.out.println("Correct solution: " + infixExpression.toPostfix());
                }
            }
            if (practiceSelection.equals("both") || practiceSelection.equals("prefix")) {
                System.out.println("Please type your Prefix solution: ");
                solution = scanner.next();
                solution = solution.replaceAll("\\s", "");
                if (solution.equals(infixExpression.toPrefix())) {
                    System.out.println("Correct");
                } else {
                    System.out.println("Incorrect");
                    System.out.println("Correct solution: " + infixExpression.toPrefix());
                }
            }
        }
    }
}
