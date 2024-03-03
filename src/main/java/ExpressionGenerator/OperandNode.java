package ExpressionGenerator;

public class OperandNode extends BaseNode {
    private static final char[] OPERANDS = {'+', '-', '*', '/'};

    private final char operand;
    private final int maxLength; // Max child nodes this operand will have
    private final int maxDepth; // Max sub nodes the tree can have
    private int currentDepth = 0; // Current node depth

    private boolean maxDepthReached(){return (this.currentDepth == maxDepth);}


    private static char getRandomOperand(){
        return OperandNode.OPERANDS[BaseNode.random.nextInt(OperandNode.OPERANDS.length)];
    }

    /**
     * Generates random sub node of type OperandNode or CharNode
     *
     */
    private void generateRandomSubNode(){
        BaseNode node;
        if (this.maxDepthReached() || BaseNode.random.nextBoolean()) {
            node = new CharNode();
        } else {
            node = new OperandNode(this.currentDepth, this.maxLength, this.maxDepth);
        }
        this.addNode(node);
    }

    /**
     * Generates n sub nodes from 2 and maxLength of either type CharNode or OperandNode
     * <p>
     * This will limit the max sub nodes to 2 if the operand is division or multiplication
     * </p>
     */
    private void populateSubNodes() {
        int nodesToGenerate;
        if (this.maxLength > 2 && this.operand != '/' && this.operand != '*') {
            nodesToGenerate = BaseNode.random.nextInt(2, this.maxLength);
        } else {nodesToGenerate = 2;}

        for (int i = 0; i < nodesToGenerate; i++) {
            this.generateRandomSubNode();
        }
    }

    OperandNode(int currentDepth, int maxLength, int maxDepth) {
        this.operand = OperandNode.getRandomOperand();
        this.currentDepth = currentDepth + 1;
        this.maxLength = maxLength;
        this.maxDepth = maxDepth;
        this.populateSubNodes();
    }

    OperandNode(int maxLength, int maxDepth) {
        this.operand = OperandNode.getRandomOperand();
        this.maxDepth = maxDepth;
        this.maxLength = maxLength;
        this.populateSubNodes();
    }

    @Override
    public String toString() {
        final StringBuilder expression = new StringBuilder();

        expression.append("(");

        for (int i = 0; i < this.childNodes.size(); i++) {
            expression.append(this.childNodes.get(i));

            if (i != this.childNodes.size() - 1){expression.append(this.operand);}
        }

        expression.append(")");

        return expression.toString();
    }
}
