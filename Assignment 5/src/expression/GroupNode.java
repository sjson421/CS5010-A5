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
  public TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child) {
    if (identifier.test(this.data)) {
      this.children.add(child); //add it here and return
      return this;
    }
    for (int i = 0; i < this.children.size(); i++) {
      //add to child and mutate the child
      this.children.set(
              i,
              this.children.get(i).addChild(identifier, child));
    }
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
}
