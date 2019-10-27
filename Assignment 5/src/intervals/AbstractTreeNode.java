package intervals;

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
  protected String getNestedSpaces(int depth) {
    StringBuilder text = new StringBuilder();
    for (int i = 0; i < depth; i++) {
      text.append("    ");
    }
    return text.toString();
  }
}
