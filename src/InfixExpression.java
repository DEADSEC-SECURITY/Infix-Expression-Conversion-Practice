import java.util.Stack;

public class InfixExpression {
    private static final char[] OPERANDS = {'+', '-', '*', '/', '(', ')'};
    private final String expression;
    InfixExpression(String expression) {
        this.expression = expression.replaceAll("\\s", "");
    }

    private static boolean checkValidOperand(char operand) {
        for (int i = 0; i < InfixExpression.OPERANDS.length; i++) {
            if (InfixExpression.OPERANDS[i] == operand) {
                return true;
            }
        }
        return false;
    }

    public static StringBuilder convertToPostfix(String expression) {
        Stack<Character> operandStack = new Stack<>();
        StringBuilder postFix = new StringBuilder();

        char currentChar;
        char currentOperand;
        for (int i=0; i < expression.length(); i++) {
            currentChar = expression.charAt(i);

            // Check if current char is operand
            if (InfixExpression.checkValidOperand(currentChar)) {
                // Check if operand is not ending curly brace
                if (currentChar == ')') {
                    // Add from stack to postFix until opening curly brace found
                    for (int x = 0; x <= operandStack.size(); x++) {
                        currentOperand = operandStack.pop();
                        if (currentOperand == '(') {break;}
                        postFix.append(currentOperand);
                    }
                } else {
                    operandStack.push(currentChar);
                }

                continue;
            }

            postFix.append(currentChar);
        }

        // Append what's left in stack to postFix
        for (int i = 0; i < operandStack.size(); i++) {
            postFix.append(operandStack.pop());
        }

        return postFix;
    }

    public String convertToPostfix() {
        return InfixExpression.convertToPostfix(this.expression).toString();
    }

    public String convertToPrefix() {
        // Reverse expression
        String expression = (new StringBuilder(this.expression)).reverse().toString();

        // Switch ) with ( and vice-versa so parentheses are in right order
        expression = expression.replaceAll("\\(", "?");
        expression = expression.replaceAll("\\)", "(");
        expression = expression.replaceAll("\\?", ")");

        StringBuilder preFix = InfixExpression.convertToPostfix(expression);
        return preFix.reverse().toString();
    }
}
