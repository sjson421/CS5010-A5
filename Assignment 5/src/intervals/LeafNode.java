package intervals;

import java.util.Scanner;

import tree.UpperLeafNode;

/**
 * Interval node without children, with its own specific functions.
 * @param <T> Type of node data
 */
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
