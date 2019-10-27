package expression;

import tree.UpperGroupNode;

/**
 * Expression node with children, with its own specific functions.
 * @param <T> Type of node data
 */
public class GroupNode<T> extends UpperGroupNode<T> {
  public GroupNode(T data) {
    super(data);
  }

  @Override
  public String infix() {
    return "( " + children.get(0).infix() + " " + data.toString() + " "
            + children.get(1).infix() + " )";
  }

  @Override
  public String scheme() {
    return "(" + data.toString() + " " + children.get(0).scheme() + " "
            + children.get(1).scheme() + ")";
  }

  @Override
  public double evaluateDouble() {
    if (children.size() == 2) {
      if (data.equals("+")) {
        return children.get(0).evaluateDouble() + children.get(1).evaluateDouble();
      } else if (data.equals("-")) {
        return children.get(0).evaluateDouble() - children.get(1).evaluateDouble();
      } else if (data.equals("*")) {
        return children.get(0).evaluateDouble() * children.get(1).evaluateDouble();
      } else {
        // Due to the check from the tree, this must be division "/"
        return children.get(0).evaluateDouble() / children.get(1).evaluateDouble();
      }
    } else {
      return 0;
    }
  }

}
