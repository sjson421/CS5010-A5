package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Group node holding onto the common operations of both types of group nodes in expression and
 * interval.
 *
 * @param <T> Type of tree node.
 */
public class UpperGroupNode<T> extends AbstractTreeNode<T> {
  protected List<TreeNode<T>> children;

  public UpperGroupNode(T data) {
    children = new ArrayList<TreeNode<T>>();
    this.data = data;
  }

  //Taken from lecture 9 notes
  @Override
  public TreeNode<T> addChild(TreeNode<T> child) {
    this.children.add(child);
    return this;
  }

  @Override
  public String textTree(int depth, boolean firstChild, int branchStart) {
    String spaces;
    if (firstChild) {
      if (branchStart == Integer.MAX_VALUE) {
        branchStart = depth - 1;
      }
      spaces = getNestedSpaces(depth, branchStart);
    } else {
      spaces = getNestedSpaces(depth, depth);
    }
    return data.toString() + "\n"
            + spaces + "|\n"
            + spaces + "|\n"
            + spaces + "|___" + children.get(1).textTree(depth + 1, true, branchStart) + "\n"
            + spaces + "|\n"
            + spaces + "|___" + children.get(0).textTree(depth + 1, false, branchStart);
  }
}
