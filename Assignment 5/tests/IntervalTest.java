import org.junit.Before;
import org.junit.Test;

import intervals.Intervals;
import intervals.IntervalTree;

import static org.junit.Assert.assertEquals;

public class IntervalTest {
  private Intervals h;
  private Intervals i;
  private Intervals i2;
  private Intervals i3;
  private Intervals i4;
  private Intervals i5;
  private Intervals i6;
  private Intervals i7;

  @Before
  public void setUp() {
    h = new IntervalTree("1,4 2,5 I");
    i = new IntervalTree("1,4 2,5 U");
    //i2 = new IntervalTree("-4,4 2,5 U  -1,7 I ");
    i3 = new IntervalTree("3,7 2,8 4,10 I U");
    i4 = new IntervalTree("0,0 0,0 I");
    i5 = new IntervalTree("0,0 0,0 U");
    i6 = new IntervalTree("0,1 0,1 I");
    i7 = new IntervalTree("0,1 0,1 U");
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
  public void testInitializeFail3() {
    Intervals f3 = new IntervalTree("4");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitializeFail4() {
    Intervals f4 = new IntervalTree("2 3 - *");
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
    assertEquals("", i.textTree());
  }

  @Test
  public void testText3() {
    assertEquals("", i2.textTree());
  }

  @Test
  public void testText4() {
    assertEquals("", i3.textTree());
  }

  @Test
  public void testText5() {
    assertEquals("", i4.textTree());
  }
  @Test
  public void testText6() {
    assertEquals("", i5.textTree());
  }

  @Test
  public void testText7() {
    assertEquals("", i6.textTree());
  }
  @Test
  public void testText8() {
    assertEquals("", i7.textTree());
  }
  /*
    h = new IntervalTree("1,4 2,5 I");
    i = new IntervalTree("1,4 2,5 U");
    i2 = new IntervalTree("-4,4 2,5 U  -1,7 I ");
    i3 = new IntervalTree("3,7 2,8 4,10 I U");
    i4 = new IntervalTree("0,0 0,0 I");
    i5 = new IntervalTree("0,0 0,0 U");
    i6 = new IntervalTree("0,1 0,1 I");
    i7 = new IntervalTree("0,1 0,1 U");
   */
}
