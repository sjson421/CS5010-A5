package intervals;

import java.util.ArrayList;
import java.util.List;

public class GroupNode<T> extends AbstractTreeNode<T> {
  private List<TreeNode<T>> children;

  private GroupNode() {
  }

  public GroupNode(T data) {
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
  public String toString() {
    if (children.size() == 2) {
      return data.toString() + "\n/\n/\n/___" + children.get(0).toString()
              + "\n/\n/___" + children.get(1).toString();
    } else {
      return "Invalid tree";
    }
  }

  @Override
  public Interval evaluate() {
    if (children.size() == 2) {
      if (data.equals("U")) {
        return children.get(0).evaluate().union(children.get(1).evaluate());
      } else {
        // Due to the check from the tree, this must be an intersection "I"
        return children.get(0).evaluate().intersect(children.get(1).evaluate());
      }
    } else {
      return null;
    }
  }
}
