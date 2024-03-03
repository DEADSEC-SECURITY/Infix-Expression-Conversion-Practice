import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestInfixExpression {
    private void testPostFixExpression(String infix, String output) {
        InfixExpression expression;

        expression = new InfixExpression(infix);
        assertEquals(output, expression.convertToPostfix());
    }
    private void testPreFixExpression(String infix, String output) {
        InfixExpression expression;

        expression = new InfixExpression(infix);
        assertEquals(output, expression.convertToPrefix());
    }

    @Test
    public void testPostFixConversion() {
        // Expressions
        testPostFixExpression("A + (B * C)", "ABC*+");
        testPostFixExpression("(( A + (B * C)) / (D - E))", "ABC*+DE-/");
        testPostFixExpression("(A + B) * (C + E)", "AB+CE+*");
        testPostFixExpression("A * (B * (((C + A) + B) * C))", "ABCA+B+C***");
        testPostFixExpression("(( H * ((((A + ((B + C) * D)) * F) * G) * E)) + J)", "HABC+D*+F*G*E**J");
    }

    @Test
    public void testPreFixConversion() {
        // Expressions
        testPreFixExpression("A + (B * C)", "+A*BC");
        testPreFixExpression("(( A + (B * C)) / (D - E))", "/+A*BC-DE");
        testPreFixExpression("(A + B) * (C + E)", "*+AB+CE");
        testPreFixExpression("A * (B * (((C + A) + B) * C))", "*A*B*++CABC");
        testPreFixExpression("(( H * ((((A + ((B + C) * D)) * F) * G) * E)) + J)", "+*H***+A*+BCDFGEJ");
    }
}
