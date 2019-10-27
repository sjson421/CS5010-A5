package tree;

public class UpperLeafNode<T> extends AbstractTreeNode<T> {
  public UpperLeafNode(T data) {
    this.data = data;
  }

  @Override
  public String textTree(int depth, boolean firstChild) {
    return data.toString();
  }

  @Override
  public TreeNode<T> addChild(TreeNode<T> child) {
    //promote this to a group tree node
    UpperGroupNode<T> newNode = new UpperGroupNode<T>(this.data);
    newNode.addChild(child);
    return newNode;
  }
}
