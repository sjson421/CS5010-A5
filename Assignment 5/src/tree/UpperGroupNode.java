package tree;

import java.util.ArrayList;
import java.util.List;

import intervals.Interval;

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
  public String textTree(int depth) {
    if (children.size() == 2) {
      String spaces = getNestedSpaces(depth);
      return spaces + data.toString() + "\n"
              + spaces + "/\n" + spaces + "/\n" + spaces + "/___"
              + children.get(1).textTree(depth + 1) + "\n"
              + spaces + "/\n" + spaces + "/___" + children.get(0).textTree(depth + 1);
    } else {
      return "Invalid tree";
    }
  }
}
