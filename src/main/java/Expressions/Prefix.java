package Expressions;

public class Prefix extends Postfix {
    private final StringBuilder preFixExpression;

    public Prefix(String infixExpression) {
        // Not pretty but the only way to switch the parentheses given that super needs to be the first statement
        super((new StringBuilder(
                infixExpression
                        .replaceAll("\\(", "?")
                        .replaceAll("\\)", "(")
                        .replaceAll("\\?", ")")
        )).reverse());

        this.preFixExpression = this.getPostFixExpression().reverse();
    }

    @Override
    public String toString() {
        return this.preFixExpression.toString();
    }
}
