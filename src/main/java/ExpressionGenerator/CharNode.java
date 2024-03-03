package ExpressionGenerator;

public class CharNode extends BaseNode {
    private final char character;

    private static char getRandomChar(){
        return (char)(BaseNode.random.nextInt(26) + 'A');
    }

    CharNode() {
        this.character = CharNode.getRandomChar();
    }

    @Override
    public String toString() {
        return String.valueOf(this.character);
    }
}
