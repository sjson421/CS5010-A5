package expression;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
    this.children.add(child); //add it here and return
    return this;
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
  public double evaluate() {
    if (children.size() == 2) {
      if (data.equals("+")) {
        return children.get(0).evaluate() + children.get(1).evaluate();
      } else if (data.equals("-")) {
        return children.get(0).evaluate() - children.get(1).evaluate();
      } else if (data.equals("*")) {
        return children.get(0).evaluate() * children.get(1).evaluate();
      } else {
        // Due to the check from the tree, this must be division "/"
        return children.get(0).evaluate() / children.get(1).evaluate();
      }
    } else {
      return 0;
    }
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
}
