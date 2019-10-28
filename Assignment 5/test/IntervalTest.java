import org.junit.Before;
import org.junit.Test;

import intervals.Intervals;
import intervals.IntervalTree;

import static org.junit.Assert.assertEquals;

/**
 * Test for the interval tree.
 */
public class IntervalTest {
  private Intervals h;
  private Intervals i;
  private Intervals i2;
  private Intervals i3;
  private Intervals i4;
  private Intervals i5;
  private Intervals i6;
  private Intervals i7;
  Intervals i8 = new IntervalTree("1,4 2,5 I 1,2 U 5,7 U 2,5 I");

  @Before
  public void setUp() {
    h = new IntervalTree("1,4 2,5 I");
    i = new IntervalTree("1,4 2,5 U");
    i2 = new IntervalTree("-4,4 2,5 U  -1,7 I ");
    i3 = new IntervalTree("3,7 2,8 4,10 I U");
    i4 = new IntervalTree("0,0 0,0 I");
    i5 = new IntervalTree("0,0 0,0 U");
    i6 = new IntervalTree("0,1 0,1 I");
    i7 = new IntervalTree("0,1 0,1 U");
  }

  @Test
  public void test() {
    assertEquals("I\n/\n/\n/___1,4\n/\n/___2,5", i8.textTree());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitializeFail1() {
    Intervals f1 = new IntervalTree(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitializeFail2() {
    Intervals f2 = new IntervalTree("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitializeFail4() {
    Intervals f4 = new IntervalTree("2 3 I U");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitializeFail5() {
    Intervals f4 = new IntervalTree("A");
  }

  @Test
  public void testEvaluate1() {
    assertEquals("2,4", h.evaluate().toString());
  }

  @Test
  public void testEvaluate2() {
    assertEquals("1,5", i.evaluate().toString());
  }

  @Test
  public void testEvaluate3() {
    assertEquals("-1,5", i2.evaluate().toString());
  }

  @Test
  public void testEvaluate4() {
    assertEquals("3,8", i3.evaluate().toString());
  }

  @Test
  public void testEvaluate5() {
    assertEquals("0,0", i4.evaluate().toString());
  }

  @Test
  public void testEvaluate6() {
    assertEquals("0,0", i5.evaluate().toString());
  }

  @Test
  public void testEvaluate7() {
    assertEquals("0,1", i6.evaluate().toString());
  }

  @Test
  public void testEvaluate8() {
    assertEquals("0,1", i7.evaluate().toString());
  }

  @Test
  public void testText1() {
    assertEquals("I\n/\n/\n/___1,4\n/\n/___2,5", h.textTree());
  }

  @Test
  public void testText2() {
    assertEquals("U\n/\n/\n/___1,4\n/\n/___2,5", i.textTree());
  }

  @Test
  public void testText3() {
    assertEquals("I\n" +
            "/\n" +
            "/\n" +
            "/___U\n" +
            "/   /\n" +
            "/   /\n" +
            "/   /___-4,4\n" +
            "/   /\n" +
            "/   /___2,5\n" +
            "/\n" +
            "/___-1,7", i2.textTree());
  }

  @Test
  public void testText4() {
    assertEquals("U\n" +
            "/\n" +
            "/\n" +
            "/___3,7\n" +
            "/\n" +
            "/___I\n" +
            "    /\n" +
            "    /\n" +
            "    /___2,8\n" +
            "    /\n" +
            "    /___4,10", i3.textTree());
  }

  @Test
  public void testText5() {
    assertEquals("I\n" +
            "/\n" +
            "/\n" +
            "/___0,0\n" +
            "/\n" +
            "/___0,0", i4.textTree());
  }

  @Test
  public void testText6() {
    assertEquals("U\n" +
            "/\n" +
            "/\n" +
            "/___0,0\n" +
            "/\n" +
            "/___0,0", i5.textTree());
  }

  @Test
  public void testText7() {
    assertEquals("I\n" +
            "/\n" +
            "/\n" +
            "/___0,1\n" +
            "/\n" +
            "/___0,1", i6.textTree());
  }

  @Test
  public void testText8() {
    assertEquals("U\n" +
            "/\n" +
            "/\n" +
            "/___0,1\n" +
            "/\n" +
            "/___0,1", i7.textTree());
  }
}
