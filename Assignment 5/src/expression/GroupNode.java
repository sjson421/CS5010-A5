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

  //Taken from lecture 9 notes
  @Override
  public List<T> toList() {
    List<T> result = new ArrayList<T>();
    result.add(this.data);
    for (TreeNode<T> child : children) {
      result.addAll(child.toList());
    }
    return result;
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

}
