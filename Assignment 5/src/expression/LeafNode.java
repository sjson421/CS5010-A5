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

  //Taken from lecture 9 notes
  @Override
  public List<T> toList() {
    List<T> result = new ArrayList<T>();
    result.add(this.data);
    return result;
  }

  @Override
  public String infix() {
    return data.toString();
  }

  @Override
  public String scheme() {
    return data.toString();
  }
}
