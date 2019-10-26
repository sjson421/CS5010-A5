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
  public TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T>
          child) {
    if (identifier.test(data)) {
      //promote this to a group tree node
      GroupNode<T> newNode = new GroupNode<T>(this.data);
      newNode.addChild(identifier, child);
      return newNode;
    }
    return this;
  }

  //Taken from lecture 9 notes
  @Override
  public List<T> toList() {
    List<T> result = new ArrayList<T>();
    result.add(this.data);
    return result;
  }
}
