package Expressions;

import java.util.Stack;

public class Postfix {
    private final Stack<Character> operatorStack = new Stack<>();
    private final StringBuilder postFixExpression = new StringBuilder();
    private final String infixExpression;

    public Postfix(String infixExpression) {
        this.infixExpression = infixExpression.replaceAll("\\s", "");

        this.infixToPostfix();
    }

    public Postfix(StringBuilder infixExpression) {
        this.infixExpression = infixExpression.toString().replaceAll("\\s", "");

        this.infixToPostfix();
    }

    private int getOperatorWeight(char operator) {
        return switch (operator) {
            case '/', '*' -> 1;
            case '+', '-' -> 0;
            default -> -1;
        };
    }

    /**
     * Unloads the operator stack to the this.infixExpression string
     */
    private void unloadStack(){
        if (this.operatorStack.empty()) {
            return;
        }

        for (int i = 0; i <= this.operatorStack.size(); i++) {
            this.postFixExpression.append(this.operatorStack.pop());
        }
    }

    /**
     * Unloads the operator stack to the this.infixExpression string with weight
     *
     * @param operator: The current operator to do weight comparison
     */
    private void unloadStackWithWeight(char operator){
        if (this.operatorStack.empty()) {
            return;
        }

        int operatorWeight = this.getOperatorWeight(operator);

        while (!this.operatorStack.empty() && operatorWeight <= this.getOperatorWeight(this.operatorStack.peek())) {
            this.postFixExpression.append(this.operatorStack.pop());
        }
    }

    /**
     * Unloads the operator stack to the this.infixExpression string until opening curly braces found
     *
     */
    private void unloadStackUntilOpenBrace(){
        if (this.operatorStack.empty()) {
            return;
        }

        while (!this.operatorStack.empty() && this.operatorStack.peek() != '(') {
            this.postFixExpression.append(this.operatorStack.pop());
        }

        // Remove opening curly brace from stack
        this.operatorStack.pop();
    }

    /**
     *
     */
    private void infixToPostfix() {
        char currentChar;

        for (int i=0; i < this.infixExpression.length(); i++) {
            currentChar = this.infixExpression.charAt(i);

            // Check if current char is operand
            switch (currentChar) {
                case '(' -> this.operatorStack.push(currentChar);
                case ')' -> this.unloadStackUntilOpenBrace();
                case '+', '-', '/', '*' -> {
                    if (!this.operatorStack.empty()) {
                        this.unloadStackWithWeight(currentChar);
                        this.operatorStack.push(currentChar);
                    } else {
                        this.operatorStack.push(currentChar);
                    }
                }
                default -> this.postFixExpression.append(currentChar);
            }
        }

        // Append what's left in stack to postFix
        this.unloadStack();
    }

    public StringBuilder getPostFixExpression() {return this.postFixExpression;}

    @Override
    public String toString() {
        return this.postFixExpression.toString();
    }
}
