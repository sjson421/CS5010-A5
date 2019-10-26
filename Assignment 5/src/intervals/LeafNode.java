package intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
  public String toString() {
    return data.toString();
  }

  @Override
  public Interval evaluate() {
    Scanner s = new Scanner(data.toString());
    s.useDelimiter(",");

    int start = Integer.parseInt(s.next());
    int end = Integer.parseInt(s.next());

    return new Interval(start, end);
  }
}
