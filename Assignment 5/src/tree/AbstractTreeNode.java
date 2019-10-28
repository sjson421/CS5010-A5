package tree;

import intervals.Interval;

/**
 * Abstract tree node class for holding onto data and holding onto temporary or commonly used
 * functions.
 * @param <T> Type of tree node.
 */
public abstract class AbstractTreeNode<T> implements TreeNode<T> {
  protected T data;

  @Override
  public T getData() {
    return data;
  }

  /**
   * Gets the amount of spaces necessary for each depth of nesting in the tree in a text tree.
   * @param depth Current depth of the tree.
   * @return String of spaces for text tree depth.
   */
  protected String getNestedSpaces(int depth, int branchStart) {
    StringBuilder text = new StringBuilder();
    for (int i = 0; i < branchStart; i++) {
      text.append("    ");
    }
    for (int i = branchStart; i < depth; i++) {
      text.append("|   ");
    }
    return text.toString();
  }

  @Override
  public Interval evaluateInterval() {
    return null;
  }

  @Override
  public double evaluateDouble() {
    return 0;
  }

  @Override
  public String infix() {
    return null;
  }

  @Override
  public String scheme() {
    return null;
  }
}
