package expression;

import java.util.List;
import java.util.function.Predicate;

import intervals.Interval;

public interface TreeNode<T> {
  /**
   * Adds a new child under the current node.
   *
   * @param child The node to add as a child of this node.
   * @return The current node, with its associated child nodes.
   */
  TreeNode<T> addChild(TreeNode<T> child);

  /**
   * Returns the expression tree as an infix expression.
   *
   * @return The infix expression.
   */
  String infix();

  /**
   * Returns the expression tree as a format similar to that used in Scheme.
   *
   * @return The scheme expression
   */
  String scheme();

  /**
   * Gets the evaluated double after specified algebraic expressions.
   *
   * @return The evaluated double after the operations provided
   */
  double evaluate();

  /**
   * Returns the data stored in the node.
   *
   * @return Data of the node.
   */
  T getData();

  /**
   * Returns the string form of the current node, added to the tree.
   *
   * @return The current node data, added to the tree.
   */
  String toString();
}
