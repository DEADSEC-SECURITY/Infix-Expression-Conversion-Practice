import Expressions.Postfix;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPostFix {
    private void testPostFixExpression(String infix, String output) {
        Postfix expression;

        expression = new Postfix(infix);
        assertEquals(output, expression.toString());
    }

    @Test
    public void testPrecedence() {
        testPostFixExpression("A + B * C / D + E", "ABC*D/+E+");
    }

    @Test
    public void testPostFixConversion() {
        // Expressions
        testPostFixExpression("A + (B * C)", "ABC*+");
        testPostFixExpression("A + B * C", "ABC*+");
        testPostFixExpression("(( A + (B * C)) / (D - E))", "ABC*+DE-/");
        testPostFixExpression("(A + B) * (C + E)", "AB+CE+*");
        testPostFixExpression("A * (B * (((C + A) + B) * C))", "ABCA+B+C***");
        testPostFixExpression("(( H * ((((A + ((B + C) * D)) * F) * G) * E)) + J)", "HABC+D*+F*G*E**J+");
    }
}
