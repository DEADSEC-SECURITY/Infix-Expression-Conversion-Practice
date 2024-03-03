package ExpressionGenerator;

import java.util.ArrayList;
import java.util.Random;

public class BaseNode {
    protected static final Random random = new Random();
    protected ArrayList<BaseNode> childNodes;

    BaseNode() {
        this.childNodes = new ArrayList<>();
    }



    public void addNode(BaseNode node) {
        this.childNodes.add(node);
    }
}
