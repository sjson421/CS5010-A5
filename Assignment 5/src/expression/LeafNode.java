package expression;

import tree.UpperLeafNode;

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
