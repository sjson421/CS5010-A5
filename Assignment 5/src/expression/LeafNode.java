package expression;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LeafNode<T> extends AbstractTreeNode<T> {
  private LeafNode() {
  }

  public LeafNode(T data) {
    this.data = data;
  }

  //Taken from lecture 9 notes
  @Override
  public TreeNode<T> addChild(TreeNode<T> child) {
    //promote this to a group tree node
    GroupNode<T> newNode = new GroupNode<T>(this.data);
    newNode.addChild(child);
    return newNode;
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
  public double evaluate() {
    return Double.parseDouble(data.toString());
  }

  @Override
  public String toString() {
    return data.toString();
  }
}
