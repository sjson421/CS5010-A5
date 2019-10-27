package intervals;

import tree.UpperGroupNode;

public class GroupNode<T> extends UpperGroupNode<T> {
  public GroupNode(T data) {
    super(data);
  }

  @Override
  public Interval evaluateInterval() {
    if (children.size() == 2) {
      if (data.equals("U")) {
        return children.get(0).evaluateInterval().union(children.get(1).evaluateInterval());
      } else {
        // Due to the check from the tree, this must be an intersection "I"
        return children.get(0).evaluateInterval().intersect(children.get(1).evaluateInterval());
      }
    } else {
      return null;
    }
  }
}
