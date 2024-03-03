package ExpressionGenerator;

public class Expression {
    private final BaseNode head;

    public Expression(int maxLength, int maxDepth) {
        this.head = new OperandNode(maxLength, maxDepth);
    }

    public String getExpression() {
        return this.head.toString();
    }
}
