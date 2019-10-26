import org.junit.Before;
import org.junit.Test;

import intervals.*;

public class IntervalTest {
  Intervals f1;
  Intervals f2;
  Intervals f3;
  Intervals f4;
  Intervals i;

  @Before
  public void setUp() {
    i = new IntervalTree("3,10 5,12 U 4,4 I");
  }
  @Test
  public void testExpression() {

  }
}
