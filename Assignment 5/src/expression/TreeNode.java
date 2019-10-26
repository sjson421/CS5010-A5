package expression;

import java.util.List;
import java.util.function.Predicate;

public interface TreeNode<T> {
  /**
   * Adds a new child under the current node.
   *
   * @param child The node to add as a child of this node.
   * @return The current node, with its associated child nodes.
   */
  TreeNode<T> addChild(TreeNode<T> child);

  /**
   * Returns the entire tree as a list, depth first.
   *
   * @return List of the tree, depth first.
   */
  List<T> toList();

  /**
   * Returns the tress expression as an infix expression
   *
   * @return The infix expression.
   */
  String infix();
}
