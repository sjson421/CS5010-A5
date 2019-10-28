import org.junit.Before;
import org.junit.Test;

import expression.Expression;
import expression.ExpressionTree;

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
  private Expression i8;
  private Expression i9;
  private Expression i10;
  private Expression i11;
  private Expression i12;
  private Expression i13;
  private Expression i14;
  private Expression i15;
  private Expression i16;
  private Expression i17;
  private Expression i18;
  private Expression i19;
  private Expression i20;
  private Expression i21;
  private Expression i22;
  private Expression i23;

  @Before
  public void setUp() {
//    i = new ExpressionTree("2 4 +");
//    i1 = new ExpressionTree("2 4 -");
//    i2 = new ExpressionTree(" -0.003  4  * ");
//    i3 = new ExpressionTree("2.2 -4 /");
//    i4 = new ExpressionTree("0 0 +");
//    i5 = new ExpressionTree("0 0 -");
//    i6 = new ExpressionTree(" 0  0  * ");
//    i7 = new ExpressionTree("0 0 /");
//    i8 = new ExpressionTree("2 -41.23 + 3 -");
//    i9 = new ExpressionTree("2 4 - 3 *");
//    i10 = new ExpressionTree("2 4 * 3 /");
//    i11 = new ExpressionTree("2 4 / 3 +");
//    i12 = new ExpressionTree("2 -4 3 + -");
//    i13 = new ExpressionTree("-2 4 3 - *");
//    i14 = new ExpressionTree("2 -4 3 * /");
//    i15 = new ExpressionTree("-2 4 3 / +");
//    i16 = new ExpressionTree("0 0 + 0 -");
//    i17 = new ExpressionTree("0 0 - 0 *");
//    i18 = new ExpressionTree("0 0 * 0 /");
//    i19 = new ExpressionTree("0 0 / 0 +");
//    i20 = new ExpressionTree("0 0 0 + -");
//    i21 = new ExpressionTree("0 0 0 - *");
//    i22 = new ExpressionTree("0 0 0 * /");
//    i23 = new ExpressionTree("0 0 0 / +");
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
}
