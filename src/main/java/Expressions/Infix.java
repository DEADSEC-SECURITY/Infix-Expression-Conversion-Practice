package Expressions;

public class Infix {
    private final String expression;
    private final Postfix postFixExpression;
    private final Prefix preFixExpression;
    public Infix(String infixExpression) {
        this.expression = infixExpression;
        this.postFixExpression = new Postfix(infixExpression);
        this.preFixExpression = new Prefix(infixExpression);
    }

    public String toPostfix(){return this.postFixExpression.toString();}
    public String toPrefix(){return this.preFixExpression.toString();}

    @Override
    public String toString() {
        return this.expression;
    }
}
