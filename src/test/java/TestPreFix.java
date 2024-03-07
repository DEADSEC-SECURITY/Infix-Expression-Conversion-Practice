import Expressions.Prefix;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPreFix {
    private void testPreFixExpression(String infix, String output) {
        Prefix expression;

        expression = new Prefix(infix);
        assertEquals(output, expression.toString());
    }

    @Test
    public void testPostFixConversion() {
        // Expressions
        testPreFixExpression("A + (B * C)", "+A*BC");
        testPreFixExpression("(( A + (B * C)) / (D - E))", "/+A*BC-DE");
        testPreFixExpression("(A + B) * (C + E)", "*+AB+CE");
        testPreFixExpression("A * (B * (((C + A) + B) * C))", "*A*B*++CABC");
        testPreFixExpression("(( H * ((((A + ((B + C) * D)) * F) * G) * E)) + J)", "+*H***+A*+BCDFGEJ");
    }
}
