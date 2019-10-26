package expression;

public abstract class AbstractTreeNode<T> implements TreeNode<T> {
  protected T data;

  @Override
  public T getData() {
    return data;
  }
}
