import org.junit.Before;
import org.junit.Test;

import expression.Expression;
import expression.ExpressionTree;

import static org.junit.Assert.assertEquals;

/**
 * Test for the expression tree.
 */
public class ExpressionTest {
  private Expression i;
  private Expression i1;
  private Expression i2;
  private Expression i3;
  private Expression i4;
  private Expression i5;
  private Expression i6;
  private Expression i7;
  private Expression i18;
  private Expression i24;
  private Expression i25;
  private Expression i26;
  private Expression i27;
  private Expression i28;
  private Expression i29;
  private Expression i30;

  @Before
  public void setUp() {
    i = new ExpressionTree("2.2 4.3 +");
    i1 = new ExpressionTree("2 4 -");
    i2 = new ExpressionTree(" -0.003  4  * ");
    i3 = new ExpressionTree("2.2 -4 /");
    i4 = new ExpressionTree("0 0 +");
    i5 = new ExpressionTree("0 0 -");
    i6 = new ExpressionTree(" 0  0  * ");
    i7 = new ExpressionTree("0 0 /");
    i18 = new ExpressionTree("0 0 * 0 /");
    i24 = new ExpressionTree("-29912 -37982 *");
    i25 = new ExpressionTree("2 4 / 1.5 3.6 + 6 * - ");
    i26 = new ExpressionTree("-8 -2 /");
    i27 = new ExpressionTree("-7.4 -3.5 -");
    i28 = new ExpressionTree("4 0 /");
    i29 = new ExpressionTree("12 25 + 12 / -57 * 0 12 61 - 29 + - /");
    i30 = new ExpressionTree("4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitializeFail1() {
    Expression f = new ExpressionTree(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitializeFail2() {
    Expression f = new ExpressionTree("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitializeFail4() {
    Expression f = new ExpressionTree("2 3 - *");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitializeFail5() {
    Expression f = new ExpressionTree("A");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitializeFail6() {
    Expression f = new ExpressionTree("1 2 -3 + 4 +");
  }

  @Test
  public void testSingleNumberEvaluation() {
    assertEquals(4, i30.evaluate(), 0);
  }

  @Test
  public void testAddition() {
    assertEquals(6.5, i.evaluate(), 0.0);
  }

  @Test
  public void testSubtraction() {
    assertEquals(-2, i1.evaluate(), 0.0);
  }

  @Test
  public void testMultiplication() {
    assertEquals(-0.012, i2.evaluate(), 0);
  }

  @Test
  public void testDivision() {
    assertEquals(-0.55, i3.evaluate(), 0);
  }

  @Test
  public void testNegativeMultiplication() {
    assertEquals(1136117584, i24.evaluate(), 0);
  }

  @Test
  public void testNegativeDivision() {
    assertEquals(4, i26.evaluate(), 0);

  }

  @Test
  public void testZeroMultiplication() {
    assertEquals(0.0, i6.evaluate(), 0);
  }

  @Test
  public void testZeroDivision() {
    assertEquals(Double.NaN, i7.evaluate(), 0);
  }

  @Test
  public void testNumberDividedByZero() {
    assertEquals(Double.POSITIVE_INFINITY, i28.evaluate(), 0);
  }

  @Test
  public void testNegativeSubtraction() {
    assertEquals(-3.9, i27.evaluate(), 0.0001);
  }

  @Test
  public void testAllOperators() {
    assertEquals(-30.1, i25.evaluate(), 0.01);
  }

  @Test
  public void testSingleNumberInfix() {
    assertEquals("4", i30.infix());
  }

  @Test
  public void testInfixAdd() {
    assertEquals("( 2.2 + 4.3 )", i.infix());
  }

  @Test
  public void testInfixSubtraction() {
    assertEquals("( 2 - 4 )", i1.infix());
  }

  @Test
  public void testInfixMultiplication() {
    assertEquals("( -0.003 * 4 )", i2.infix());
  }

  @Test
  public void testInfixDivision() {
    assertEquals("( 2.2 / -4 )", i3.infix());
  }

  @Test
  public void testInfixAllOperators() {
    assertEquals("( ( 2 / 4 ) - ( ( 1.5 + 3.6 ) * 6 ) )", i25.infix());
  }

  @Test
  public void testInfixZero() {
    assertEquals("( ( 0 * 0 ) / 0 )", i18.infix());
  }

  @Test
  public void testSingleNumberScheme() {
    assertEquals("4", i30.schemeExpression());
  }

  @Test
  public void testSchemeExpressionAdd() {
    assertEquals("(+ 2.2 4.3)", i.schemeExpression());
  }

  @Test
  public void testSchemeSubtraction() {
    assertEquals("(- 2 4)", i1.schemeExpression());
  }

  @Test
  public void testSchemeMultiplication() {
    assertEquals("(* -0.003 4)", i2.schemeExpression());
  }

  @Test
  public void testSchemeDivision() {
    assertEquals("(/ 2.2 -4)", i3.schemeExpression());
  }

  @Test
  public void testSchemeExpressionAllOperators() {
    assertEquals("(- (/ 2 4) (* (+ 1.5 3.6) 6))", i25.schemeExpression());
  }

  @Test
  public void testSchemeExpressionZero() {
    assertEquals("(/ (* 0 0) 0)", i18.schemeExpression());
  }

  @Test
  public void testSingleNumberText() {
    assertEquals("4", i30.textTree());
  }

  @Test
  public void testText1() {
    assertEquals("+\n" +
            "|\n" +
            "|\n" +
            "|___2.2\n" +
            "|\n" +
            "|___4.3", i.textTree());
  }

  @Test
  public void testText2() {
    assertEquals("+\n" +
            "|\n" +
            "|\n" +
            "|___2.2\n" +
            "|\n" +
            "|___4.3", i.textTree());
  }

  @Test
  public void testText3() {
    assertEquals("*\n" +
            "|\n" +
            "|\n" +
            "|___-0.003\n" +
            "|\n" +
            "|___4", i2.textTree());
  }

  @Test
  public void testText4() {
    assertEquals("/\n" +
            "|\n" +
            "|\n" +
            "|___2.2\n" +
            "|\n" +
            "|___-4", i3.textTree());
  }

  @Test
  public void testText5() {
    assertEquals("+\n" +
            "|\n" +
            "|\n" +
            "|___0\n" +
            "|\n" +
            "|___0", i4.textTree());
  }

  @Test
  public void testText6() {
    assertEquals("-\n" +
            "|\n" +
            "|\n" +
            "|___0\n" +
            "|\n" +
            "|___0", i5.textTree());
  }

  @Test
  public void testText7() {
    assertEquals("*\n" +
            "|\n" +
            "|\n" +
            "|___0\n" +
            "|\n" +
            "|___0", i6.textTree());
  }

  @Test
  public void testText8() {
    assertEquals("/\n" +
            "|\n" +
            "|\n" +
            "|___0\n" +
            "|\n" +
            "|___0", i7.textTree());
  }

  @Test
  public void testLengthyText1() {
    assertEquals("/\n" +
            "|\n" +
            "|\n" +
            "|___*\n" +
            "|   |\n" +
            "|   |\n" +
            "|   |___/\n" +
            "|   |   |\n" +
            "|   |   |\n" +
            "|   |   |___+\n" +
            "|   |   |   |\n" +
            "|   |   |   |\n" +
            "|   |   |   |___12\n" +
            "|   |   |   |\n" +
            "|   |   |   |___25\n" +
            "|   |   |\n" +
            "|   |   |___12\n" +
            "|   |\n" +
            "|   |___-57\n" +
            "|\n" +
            "|___-\n" +
            "    |\n" +
            "    |\n" +
            "    |___0\n" +
            "    |\n" +
            "    |___+\n" +
            "        |\n" +
            "        |\n" +
            "        |___-\n" +
            "        |   |\n" +
            "        |   |\n" +
            "        |   |___12\n" +
            "        |   |\n" +
            "        |   |___61\n" +
            "        |\n" +
            "        |___29", i29.textTree());
  }
}
