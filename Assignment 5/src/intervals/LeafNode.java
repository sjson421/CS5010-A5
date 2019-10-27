package intervals;

import java.util.Scanner;

import tree.UpperLeafNode;

public class LeafNode<T> extends UpperLeafNode<T> {
  public LeafNode(T data) {
    super(data);
  }

  @Override
  public Interval evaluateInterval() {
    Scanner s = new Scanner(data.toString());
    s.useDelimiter(",");

    int start = Integer.parseInt(s.next());
    int end = Integer.parseInt(s.next());

    return new Interval(start, end);
  }
}
