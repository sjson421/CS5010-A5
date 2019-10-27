package expression;

import tree.UpperLeafNode;

/**
 * Expression node without children, with its own specific functions.
 * @param <T> Type of node data
 */
public class LeafNode<T> extends UpperLeafNode<T> {
  public LeafNode(T data) {
    super(data);
  }

  @Override
  public String infix() {
    return data.toString();
  }

  @Override
  public String scheme() {
    return data.toString();
  }

  @Override
  public double evaluateDouble() {
    return Double.parseDouble(data.toString());
  }
}
